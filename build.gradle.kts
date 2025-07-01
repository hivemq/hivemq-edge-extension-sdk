buildscript {
    if (gradle.includedBuilds.any { it.name == "edge-plugins" }) {
        plugins {
            id("com.hivemq.edge-version-updater")
        }
    }
}

plugins {
    `java-library`
    `maven-publish`
    signing
    alias(libs.plugins.mavencentralpublishing)
    alias(libs.plugins.defaults)
    alias(libs.plugins.metadata)
    alias(libs.plugins.javadoclinks)
    alias(libs.plugins.license)
}

plugins.withId("com.hivemq.version-updater") {
    project.ext.set("versionUpdaterFiles", arrayOf("README.adoc"))
}

dependencies {
    api("com.hivemq:hivemq-extension-sdk:${property("hivemq.extension.sdk.version")}")
    compileOnly(libs.jetbrains.annotations)
}

group = "com.hivemq"
description = "SDK for the development of HiveMQ Edge extensions"

metadata {
    readableName.set("HiveMQ Edge SDK")
    organization {
        name.set("HiveMQ GmbH")
        url.set("https://www.hivemq.com/")
    }
    license {
        apache2()
    }
    developers {
        register("cschaebe") {
            fullName.set("Christoph Schaebel")
            email.set("christoph.schaebel@hivemq.com")
        }
        register("simon622") {
            fullName.set("Simon Johnson")
            email.set("simon.johnson@hivemq.com")
        }
    }
    github {
        org.set("hivemq")
        repo.set("hivemq-edge-extension-sdk")
        issues()
    }
}

repositories {
    mavenCentral()
}

dependencies {

}

/* ******************** java ******************** */

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(17))
    }
    withJavadocJar()
    withSourcesJar()
}

tasks.withType<Jar>().configureEach {
    manifest.attributes(
        "Implementation-Title" to project.name,
        "Implementation-Vendor" to metadata.organization.get().name.get(),
        "Implementation-Version" to project.version
    )
}

tasks.javadoc {
    title = "${metadata.readableName.get()} ${project.version} API"

    doLast {
        javaexec {
            classpath("gradle/tools/javadoc-cleaner-1.0.jar")
        }
    }

    doLast { // javadoc search fix for jdk 11 https://bugs.openjdk.java.net/browse/JDK-8215291
        copy {
            from(destinationDir!!.resolve("search.js"))
            into(temporaryDir)
            filter { line -> line.replace("if (ui.item.p == item.l) {", "if (item.m && ui.item.p == item.l) {") }
        }
        delete(destinationDir!!.resolve("search.js"))
        copy {
            from(temporaryDir.resolve("search.js"))
            into(destinationDir!!)
        }
    }
}

/* ******************** publishing ******************** */

publishing {
    publications {
        register<MavenPublication>("maven") {
            from(components["java"])
        }
    }
}

signing {
    val signingKey: String? by project
    val signingPassword: String? by project
    useInMemoryPgpKeys(signingKey, signingPassword)
    sign(publishing.publications["maven"])
}

/* ******************** checks ******************** */

license {
    header = file("HEADER")
    mapping("java", "SLASHSTAR_STYLE")
}
