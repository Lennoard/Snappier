plugins {
    // this is necessary to avoid the plugins to be loaded multiple times
    // in each subproject's classloader
    alias(libs.plugins.androidApplication) apply false
    alias(libs.plugins.androidLibrary) apply false
    alias(libs.plugins.jetbrainsCompose) apply false
    alias(libs.plugins.kotlinCocoapods) apply false
    alias(libs.plugins.kotlinMultiplatform) apply false
    alias(libs.plugins.kotlinxSerialization) apply false

    id("com.google.gms.google-services") version "4.4.2" apply false
}

val snappierGitHubUser: String by project
val snappierGitHubToken: String by project

allprojects {

    repositories {
        google()
        mavenCentral()
        maven("https://jitpack.io")
        maven("https://maven.pkg.jetbrains.space/public/p/kotlinx-coroutines/maven")
        maven("https://maven.pkg.jetbrains.space/kotlin/p/kotlin/bootstrap")
        maven("https://maven.pkg.jetbrains.space/kotlin/p/wasm/experimental")
        maven("https://maven.pkg.jetbrains.space/kotlin/p/kotlin/dev/")

        maven {
            name = "Github Packages"
            url = uri("https://maven.pkg.github.com/Lennoard/Snappier")
            credentials {
                username = snappierGitHubUser
                password = snappierGitHubToken
            }
        }
    }
}
