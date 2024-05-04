# Snappier

Snappier is an open-source **Server-Driven UI** multiplatform library based on [Compose Multiplatform UI Framework](https://www.jetbrains.com/lp/compose-multiplatform/) with the goal of being open and customizable.

**Currently supported platforms:**

- Android (5.0+)
- iOS
- Web (JavaScript)
- Desktop (Java)

## Setup

### Create a Compose Multiplatform project ([help](https://www.jetbrains.com/help/kotlin-multiplatform-dev/compose-multiplatform-create-first-app.html))

You can use

- [Compose Multiplatform Wizard (terrakok.github.io)](https://terrakok.github.io/Compose-Multiplatform-Wizard/)  
  or
- [Kotlin Multiplatform Wizard | JetBrains](https://kmp.jetbrains.com/)

### Import the library in your Kotlin Multiplatform Project

<small>In the app's `build.gradle.kts` file (outside the `src` dir):</small>
Add `kotlinx-serialization-json` to the
project ([help](https://kotlinlang.org/docs/serialization.html#example-json-serialization)):

```kotlin
plugins {
    //...
    alias(libs.plugins.kotlinxSerialization)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            implementation(libs.kotlinx.serialization.json)
        }
    }
}
```

### Specify supported targets:

<small>For Android, set target Java version to 11,
enable [API desugaring support](https://developer.android.com/studio/write/java8-support#library-desugaring),
and compose build feature</small>

```kotlin
kotlin {
    androidTarget {
        // ...
    }

    jvm("desktop")

    js(IR) {
        // ...
    }

    // iOS / Apple...
}

compose.experimental {
    web.application {}
}
```

### Add required dependencies and the snappier library:

```kotlin
kotlin {
    sourceSets {
        val desktopMain by getting

        commonMain.dependencies {
            implementation("br.com.androidvip.snappier:lib:1.0.0")
            // [Compose libs...]
            implementation(libs.kotlinx.serialization.json)
            implementation(libs.bundles.ktor.common)
        }
    }
}
```

## Usage

```kotlin
@Composable
fun App() {
    val snappier = Snappier {
        // Optional Composable drawn while the lib is making requests
        onLoadingErrorComposable { progress ->
            Text("Loading: $progress%")
        }

        // Optional Composable drawn when the request fails
        onErrorComposable { error ->
            Text("Error: $error")
        }

        // If using ktor, set a default method
        // Individual requests can still specify their client config (including method)
        setHttpMethod(HttpMethod.Get)

        // Customize your whole HttpClient
        withHttpClient {
            // this: HttpClientConfig<*>
        }
    }.apply {
        // Add an observer for component communication
        addObserver { event ->
            println("Received event: $event")
        }
    }

    MaterialTheme {
        // This composable function will fetch and draw a Component from a sample API
        snappier.draw("http://localhost:8081/api")

        // Or you can make your own requests and map the results to the `Component` class
        // and have snappier render it for you
        val myOwnComponentFromMyOwnHttpRequest = Component()
        snappier.draw(myOwnComponentFromMyOwnHttpRequestc)

        val manyComponents = listOf<Component>()
        snappier.draw(manyComponents) // Draws as `LazyList`
    }
}
```

## Building and running

#### Android

For Android, if using Android Studio, set up an Android Emulator, select the "app" run configuration
and press the run button.

#### Desktop

For Desktop, create a `main.kt` file in the `myAppName/src/desktopMain/kotlin` directory:

```kotlin
fun main() = application {
    Window(onCloseRequest = ::exitApplication, title = "My App Name") {
        // App()
    }
}
```

Run the project using:

    gradlew desktopRun -DmainClass=MainKt --quiet

#### WEB

For Web/Javascript, create a `index.html` file in the `myAppName/src/jsMain/resources` directory:

```html
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Multiplatform App</title>
    <script src="skiko.js"></script>
</head>
<body>
<div>
    <canvas id="ComposeTarget" width="800" height="600"></canvas>
</div>
<script src="myAppName.js"></script>
</body>
</html>
```

Create a `main.kt` file in the `myAppName/src/jsMain/kotlin` directory:

```kotlin
@OptIn(ExperimentalComposeUiApi::class)
fun main() {
    onWasmReady {
        CanvasBasedWindow("Multiplatform App") {
            App()
        }
    }
}
```

Run the project using:

    gradlew jsRun

## Creating components

TODO