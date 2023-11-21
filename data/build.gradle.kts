plugins {
    id(GradlePlugings.androidLibrary)
    id(GradlePlugings.kotlinAndroid)

}

android {
    namespace = "com.example.data"
    compileSdk = 34

    defaultConfig {
        minSdk = 24

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
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
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