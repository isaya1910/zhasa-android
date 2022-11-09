plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    compileSdk = 33

    defaultConfig {
        applicationId = "com.zhasa_app"
        minSdk = 26
        targetSdk = 33
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
        sourceCompatibility(JavaVersion.VERSION_1_8)
        targetCompatibility(JavaVersion.VERSION_1_8)
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = Versions.kotlinCompilerExtensionVersion
    }

}

dependencies {
    implementation("androidx.core:core-ktx:1.9.0")
    implementation("androidx.appcompat:appcompat:1.5.1")
    implementation("com.google.android.material:material:1.6.1")
    testImplementation("junit:junit:4.13.2")
    testImplementation("org.junit.jupiter:junit-jupiter")
    testImplementation("org.junit.jupiter:junit-jupiter")
    testImplementation("org.junit.jupiter:junit-jupiter")
    testImplementation("org.junit.jupiter:junit-jupiter")
    testImplementation("org.testng:testng:6.9.6")
    androidTestImplementation("androidx.test.ext:junit:1.1.3")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.4.0")
    implementation(Dependencies.composeFoundation)
    implementation(Dependencies.composeMaterial)
    implementation(Dependencies.composeTooling)
    implementation(Dependencies.composeUI)
    implementation(Dependencies.composeViewModel)
    implementation(Dependencies.composeActivity)
    implementation(Dependencies.composeNavigation)
    implementation(Dependencies.composeMaterialIcons)
    testImplementation(Dependencies.composeUiTest)
    implementation(project(path = ":repository"))
    implementation(Dependencies.mpChartVersion)
    implementation(project(path = ":domain"))
    implementation(project(path = ":mvi"))
    testImplementation ("org.junit.jupiter:junit-jupiter-api:5.8.2")
    testImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.0")

}