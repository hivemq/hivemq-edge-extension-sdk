rootProject.name = "hivemq-edge-extension-sdk"

pluginManagement {
    plugins {
        id("io.github.gradle-nexus.publish-plugin") version "${extra["plugin.nexus-publish.version"]}"
        id("io.github.sgtsilvio.gradle.defaults") version "${extra["plugin.defaults.version"]}"
        id("com.github.sgtsilvio.gradle.metadata") version "${extra["plugin.metadata.version"]}"
        id("com.github.sgtsilvio.gradle.javadoc-links") version "${extra["plugin.javadoc-links.version"]}"
        id("com.github.hierynomus.license") version "${extra["plugin.license.version"]}"
        if (file("../hivemq-edge/edge-plugins").exists()) {
            includeBuild("../hivemq-edge/edge-plugins")
        }
    }
}
