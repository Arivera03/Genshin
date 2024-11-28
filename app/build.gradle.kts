plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "com.example.genshin"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.genshin"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
    buildFeatures {
        viewBinding = true
    }
}

dependencies {

    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.constraintlayout)
    implementation(libs.navigation.fragment)
    implementation(libs.navigation.ui)
    implementation(libs.cronet.embedded)
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)
    implementation (libs.gson)
    implementation (libs.retrofit)
    implementation (libs.converter.gson)
    implementation (libs.glide)
    annotationProcessor (libs.compiler)
    val lifecycle_version = "2.6.0-alpha02"
    val arch_version = "2.1.0"

    // ViewModel
    implementation (libs.androidx.lifecycle.viewmodel)
    // LiveData
    implementation (libs.androidx.lifecycle.livedata)
    // Annotation processor
    // alternately - if using Java8, use the following instead of lifecycle-compiler
    implementation (libs.lifecycle.common.java8)

    val room_version = "2.4.3"

    implementation (libs.room.runtime)
    annotationProcessor (libs.room.compiler)
}