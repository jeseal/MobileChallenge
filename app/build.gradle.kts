plugins {
    id(GradlePlugings.androidApplication)
    id(GradlePlugings.kotlinAndroid)
    kotlin(GradlePlugings.kaptPlugin)
    id(GradlePlugings.hiltAndroid)
}

android {
    namespace = ProjectConfiguration.applicationId
    compileSdk = ProjectConfiguration.compileSdk

    defaultConfig {
        applicationId = ProjectConfiguration.applicationId
        minSdk = ProjectConfiguration.minSdk
        targetSdk = ProjectConfiguration.targetSdk
        versionCode = ProjectConfiguration.versionCode
        versionName = ProjectConfiguration.versionName

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
        getByName("debug") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.3"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }

}


kapt {
    correctErrorTypes = true
}

dependencies {


    // modules
    implementation(project(":domain"))
    implementation(project(":data"))

    implementation(Deps.Core.coreKtx)
    implementation(Deps.Core.lifecycleKtx)

    implementation(Deps.Compose.activity)
    implementation(platform(Deps.Compose.composeBom))
    implementation(Deps.Compose.ui)
    implementation(Deps.Compose.graphics)
    implementation(Deps.Compose.uiToolingPreview)
    implementation(Deps.Compose.material3)

    // hilt
    implementation(Deps.Hilt.android)
    implementation(Deps.Hilt.hiltComposeNavigation)
    kapt(Deps.Hilt.androidCompiler)

    //test
    testImplementation(Deps.Core.jUnit)
    androidTestImplementation(Deps.Core.androidxJunit)
    androidTestImplementation(Deps.Core.espresso)

    androidTestImplementation(platform(Deps.Compose.composeBom))
    androidTestImplementation(Deps.Compose.jUnit4)
    debugImplementation(Deps.Compose.uiTooling)
    debugImplementation(Deps.Compose.testManifest)
}