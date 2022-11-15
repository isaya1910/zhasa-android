plugins {
    id("java-library")
    id("org.jetbrains.kotlin.jvm")
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}

dependencies {
    implementation(Dependencies.retrofit)
    implementation(Dependencies.koin)
    implementation(Dependencies.gsonRetrofit)
    implementation(Dependencies.retrofitLoggingInterceptor)
}