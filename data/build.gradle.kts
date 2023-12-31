plugins {
    id(GradlePlugings.androidLibrary)
    id(GradlePlugings.kotlinAndroid)
    id(GradlePlugings.apolloGraph3)
    kotlin(GradlePlugings.kaptPlugin)
    id(GradlePlugings.hiltAndroid)

}

apollo {
    service("service") {
        packageName.set(ProjectConfiguration.applicationId)
    }
}
android {
    namespace = "${ProjectConfiguration.applicationId}.${project.name}"
    println("namespace: ${namespace.orEmpty()}")
    compileSdk = ProjectConfiguration.compileSdk

    buildFeatures {
        buildConfig = true
    }

    defaultConfig {
        minSdk = ProjectConfiguration.minSdk
        targetSdk = ProjectConfiguration.targetSdk

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")

        buildConfigField("String", "BASE_URL", (project.properties["baseUrl"] ?: "").toString())
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
        getByName("debug") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }

    hilt {
        enableAggregatingTask = true
    }
}

kapt {
    correctErrorTypes = true
}

dependencies {

    // modules
    implementation(project(":domain"))

    implementation(Deps.Core.coreKtx)
    //implementation("androidx.appcompat:appcompat:1.6.1")
    //implementation("com.google.android.material:material:1.10.0")

    // hilt
    implementation(Deps.Hilt.android)
    implementation(Deps.Hilt.hiltComposeNavigation)
    kapt(Deps.Hilt.androidCompiler)

    //ApolloGraph
    implementation(Deps.ApolloGraphQL.apolloGraph3)
    //testing
    testImplementation(Deps.Core.jUnit)
    androidTestImplementation(Deps.Core.androidxJunit)
    androidTestImplementation(Deps.Core.espresso)
}