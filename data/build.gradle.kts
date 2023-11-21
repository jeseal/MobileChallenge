plugins {
    id(GradlePlugings.androidLibrary)
    id(GradlePlugings.kotlinAndroid)

}

android {
    namespace = "${ProjectConfiguration.applicationId}.${project.name}"
    println("namespace: ${namespace.orEmpty()}")
    compileSdk = ProjectConfiguration.compileSdk

    defaultConfig {
        minSdk = ProjectConfiguration.minSdk
        targetSdk = ProjectConfiguration.targetSdk

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
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
}

dependencies {

    // modules
    implementation(project(":domain"))

    implementation(Deps.Core.coreKtx)
    //implementation("androidx.appcompat:appcompat:1.6.1")
    //implementation("com.google.android.material:material:1.10.0")

    //testing
    testImplementation(Deps.Core.jUnit)
    androidTestImplementation(Deps.Core.androidxJunit)
    androidTestImplementation(Deps.Core.espresso)
}