import java.lang.Integer.parseInt

@Suppress("DSL_SCOPE_VIOLATION") // Remove when fixed https://youtrack.jetbrains.com/issue/KTIJ-19369
plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
}

android {
    namespace = "com.ife.android_project_template.feature_example_secondary_screen"
    compileSdk = parseInt(myProjectConfig.versions.compileSdk.get())

    defaultConfig {
        minSdk = parseInt(myProjectConfig.versions.minSdk.get())
        targetSdk = parseInt(myProjectConfig.versions.targetSdk.get())

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = libs.versions.androidxComposeCompiler.get()
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {

    // Core android dependencies
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)

    // Compose
    implementation(libs.compose.ui)
    implementation(libs.compose.ui.tooling.preview)
    implementation(libs.androidx.compose.material3)

    // Material design icons
    implementation(libs.androidx.compose.material.icons.extended)

    // Arch Components
    implementation(libs.androidx.navigation.compose)

    // Tooling
    debugImplementation(libs.compose.ui.tooling)
}