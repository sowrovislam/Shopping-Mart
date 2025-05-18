plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.google.gms.google.services)
    kotlin("kapt")
    id("kotlin-parcelize")
    alias(libs.plugins.safeArgs)
}

android {
    namespace = "com.example.shoppingmart"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.shoppingmart"
        minSdk = 24
        targetSdk = 35
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
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }

    viewBinding {
        enable=true
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.firebase.auth)
    implementation(libs.androidx.credentials)
    implementation(libs.androidx.credentials.play.services.auth)
    implementation(libs.googleid)
    implementation(libs.androidx.navigation.fragment.ktx)
    implementation(libs.androidx.navigation.ui.ktx)
    implementation(libs.firebase.storage)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)


    implementation(libs.moshi)
    implementation(libs.moshi.kotlin)
    implementation(libs.moshi.converter)
    implementation(libs.room)
    implementation(libs.room.coroutines)
    kapt("androidx.room:room-compiler:2.6.1")
    implementation(libs.coroutines.core)
    implementation(libs.coroutines.android)
    implementation(libs.work)
    implementation(libs.timber)
    implementation(libs.picasso)
    implementation(libs.retrofit)
    implementation(libs.retrofit.scalars)
    implementation(libs.glide)
    implementation(libs.androidx.lifecycle.viewmodel.android)
    implementation(libs.converter.gson)

    implementation(libs.circleimageview)
}