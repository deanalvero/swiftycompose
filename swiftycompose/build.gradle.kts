plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
    id("com.vanniktech.maven.publish") version "0.30.0"
    signing
}

android {
    namespace = "io.github.deanalvero.swiftycompose"
    compileSdk = 36

    defaultConfig {
        minSdk = 21

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
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        compose = true
    }
}


mavenPublishing {
    coordinates("io.github.deanalvero", "swiftycompose", "0.1.0")

    pom {
        name.set("SwiftyCompose")
        description.set("Build Composable components in Jetpack Compose using SwiftUI-like syntax!")
        url.set("https://github.com/deanalvero/swiftycompose")
        licenses {
            license {
                name.set("The Apache License, Version 2.0")
                url.set("https://www.apache.org/licenses/LICENSE-2.0.txt")
            }
        }
        developers {
            developer {
                id.set("deanalvero")
                name.set("Dean Vernon Alvero")
                email.set((findProperty("email") as String?).orEmpty())
            }
        }
        scm {
            connection.set("scm:git:git://github.com/deanalvero/swiftycompose.git")
            developerConnection.set("scm:git:ssh://git@github.com:deanalvero/swiftycompose.git")
            url.set("https://github.com/deanalvero/swiftycompose")
        }
    }

    publishToMavenCentral(com.vanniktech.maven.publish.SonatypeHost.CENTRAL_PORTAL)
    signAllPublications()
}

signing {
    useGpgCmd()
}

dependencies {
    api(libs.material3)

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}