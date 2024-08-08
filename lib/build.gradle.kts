plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.kotlinCocoapods)
    alias(libs.plugins.kotlinxSerialization)
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.jetbrainsCompose)
    id("org.jetbrains.dokka") version "0.9.17"
    id("maven-publish")
}

val snappierGitHubUser: String by project
val snappierGitHubToken: String by project
val libraryGroup = "br.com.androidvip.snappier"
val libraryVersion = "1.0.4-alpha01"

group = libraryGroup
version = libraryVersion

kotlin {
    task("testClasses")

    androidTarget {
        publishLibraryVariants("release", "debug")
        publishLibraryVariantsGroupedByFlavor = true
        compilations.all {
            kotlinOptions {
                jvmTarget = "1.8"
            }
        }
    }

    js {
        browser {
            commonWebpackConfig {
                cssSupport {
                    enabled.set(true)
                }
            }
        }
        binaries.executable()
    }

    jvm("desktop")
    iosX64()
    iosArm64()
    iosSimulatorArm64()

    cocoapods {
        summary = "Multiplatform server-driven UI"
        homepage = "github.com/Lennoard/Snappier"
        version = libraryVersion
        ios.deploymentTarget = "16.0"
        framework {
            baseName = "lib"
            isStatic = true
        }
    }

    sourceSets {
        val desktopMain by getting

        commonMain.dependencies {
            implementation(compose.runtime)
            implementation(compose.foundation)
            implementation(compose.material3)
            implementation(compose.ui)
            implementation(compose.components.resources)
            implementation(compose.components.uiToolingPreview)
            implementation(libs.compose.material.icons.extended)

            implementation(libs.kotlinx.coroutines.core)
            implementation(libs.kotlinx.serialization.json)

            implementation(libs.bundles.ktor.common)
            implementation(libs.imageLoader)
        }

        commonTest.dependencies {
            implementation(libs.kotlin.test)
        }

        androidMain.dependencies {
            implementation(libs.compose.ui.tooling.preview)
            implementation(libs.androidx.activity.compose)

            implementation(libs.kotlinx.coroutines.android)

            implementation(libs.ktor.client.okhttp)
            implementation(libs.exoplayer)
        }

        iosMain.dependencies {
            implementation(libs.ktor.client.darwin)
        }

        jsMain.dependencies {
            implementation(compose.html.core)
            implementation(libs.ktor.client.js)
            implementation(libs.kotlinx.html.js)
            implementation(npm("video.js", "8.10.0"))
        }

        desktopMain.dependencies {
            implementation(compose.desktop.currentOs)
            implementation(libs.ktor.client.apache5)

            implementation(libs.vlcj)
        }
    }
}

compose.experimental {
    web.application {}
}

publishing {
    // gradlew lib:publish
    repositories {
        maven {
            setUrl("https://maven.pkg.github.com/Lennoard/Snappier")
            credentials {
                username = snappierGitHubUser
                password = snappierGitHubToken
            }
        }
    }
}

android {
    namespace = libraryGroup
    compileSdk = libs.versions.android.compileSdk.get().toInt()
    defaultConfig {
        minSdk = libs.versions.android.minSdk.get().toInt()
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}
