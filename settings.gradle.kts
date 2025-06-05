rootProject.name = "hivemq-edge-extension-sdk"

pluginManagement {
    plugins {
        if (file("../hivemq-edge/edge-plugins").exists()) {
            includeBuild("../hivemq-edge/edge-plugins")
        }
    }
}
