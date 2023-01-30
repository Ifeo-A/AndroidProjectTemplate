# Android project template for single and multi-module apps

A repo with base template files to help you quickly get up and running with your android
project. <br>
All you need to do is clone one of the template repos listed below with your desired structure e.g
single or multi-module app and customize the project name and files using the customizer.py python
script. <br>
A virtual environment is included so you do not need to have python installed on your computer.

Templates are compatible with the latest **stable** version of Android Studio.

| Template                                                                                              | Description                                   |
|-------------------------------------------------------------------------------------------------------|-----------------------------------------------|
| [`single_module_template`](https://github.com/Ifeo-A/AndroidProjectTemplate)                          | Compose, single module                        |
| [`multimodule_template`](https://github.com/Ifeo-A/AndroidProjectTemplate/tree/multi_module_template) | single module template + multimodule template |

## Screenshots

![App Screenshot](https://via.placeholder.com/468x300?text=App+Screenshot+Here)

## Usage/Examples

Run the following commands to use.

1. First activate venv

```
 source project_customizer/venv/bin/activate  
```

2. Then run the command to customize your project files

```
python customizer.py -packageName com.your.project [-appName YourAppName]
```

3. Finally deactivate venv

```
deactivate
```

You're good to go now.

## Features

### 🖼️ UI

* 100% Jetpack Compose

### 🧱 Build

* [KTS gradle files](https://docs.gradle.org/current/userguide/kotlin_dsl.html)
* [Version catalog](https://docs.gradle.org/current/userguide/platforms.html)

- 100% Jetpack compose
- Live previews

### 🏠 Architecture

* Dependency injection
  with [Hilt](https://developer.android.com/training/dependency-injection/hilt-android)
* [Jetpack ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel)
* UI using [Jetpack Compose](https://developer.android.com/jetpack/compose) and
  [Material3](https://developer.android.com/jetpack/androidx/releases/compose-material3)
* [Jetpack Navigation](https://developer.android.com/jetpack/compose/navigation)
* [Kotlin Coroutines and Flow](https://developer.android.com/kotlin/coroutines)
  [Hilt tests](https://developer.android.com/training/dependency-injection/hilt-testing)

### 🗂 Dependencies included

* Coroutines
* Compose Ui
* Timber
* Hilt
* Retrofit
* Moshi
* Mockk
* Google Truth


