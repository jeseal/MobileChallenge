object ProjectConfiguration {
    const val applicationId = "com.jeseal.mobilechallenge"
    const val compileSdk = 34
    const val buildToolsVersion = "30.0.3"
    const val minSdk = 24
    const val targetSdk = 34
    const val versionCode = 1
    const val versionName = "1.0"
}

object CommonVersions {
    const val androidLibraryVersion = "8.1.4"
    const val kotlinVersion = "1.8.10"
    const val hiltVersion = "2.44"
    const val hiltNavigationComposeVersion = "1.0.0"
}

object GradlePlugings {
    // plugings
    const val androidApplication = "com.android.application"
    const val androidLibrary = "com.android.library"
    const val kotlinAndroid = "org.jetbrains.kotlin.android"
    const val hiltAndroid = "com.google.dagger.hilt.android"
    const val kaptPlugin = "kapt"
}

object Deps {

    object Kotlin {
        private const val kotlinJdkVersion = "1.8.0"

        const val kotlinJdk7 = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:$kotlinJdkVersion"
        const val kotlinJdk8 = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:$kotlinJdkVersion"
    }

    object Hilt {
        const val android = "com.google.dagger:hilt-android:${CommonVersions.hiltVersion}"
        const val androidCompiler = "com.google.dagger:hilt-android-compiler:${CommonVersions.hiltVersion}"
        const val hiltComposeNavigation = "androidx.hilt:hilt-navigation-compose:${CommonVersions.hiltNavigationComposeVersion}"
    }
}