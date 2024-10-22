plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "com.example.museumholicapp"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.museumholicapp"
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

    buildFeatures{
        dataBinding = true
        viewBinding = true
    }


    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

dependencies {



    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)

    // Material Components Library for Material 3
    implementation("com.google.android.material:material:1.9.0")

    // AndroidX AppCompat to use AppCompatDelegate for dark mode handling
    implementation("androidx.appcompat:appcompat:1.6.1")

    implementation("androidx.recyclerview:recyclerview:1.2.1")
    implementation("com.android.support:multidex:1.0.3")

}