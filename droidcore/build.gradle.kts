import com.vanniktech.maven.publish.SonatypeHost
import org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi
import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.composeMultiplatform)
    alias(libs.plugins.compose.compiler)
    alias(libs.plugins.mavenPublish)
    id("maven-publish")
}

kotlin {
    androidTarget {
        @OptIn(ExperimentalKotlinGradlePluginApi::class)
        compilerOptions {
            jvmTarget.set(JvmTarget.JVM_11)
        }
    }

    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach { iosTarget ->
        iosTarget.binaries.framework {
            baseName = "Droidcore"
            isStatic = true
        }
    }

    sourceSets {
        androidMain.dependencies {
            implementation(libs.androidx.material.icons.extended)
        }
        commonMain.dependencies {
            api(libs.compose.ui) //implementation(libs.androidx.ui)
            api(compose.material3) //implementation(libs.androidx.material3)
            api(compose.runtime)
            api(compose.foundation)
            api(compose.components.resources)

            api(compose.components.uiToolingPreview)
            //cmp
            api(libs.bundles.compose.multiplatform)
        }
        androidMain.dependencies {
            implementation(libs.androidx.core.ktx)
            implementation ("com.yogeshpaliyal:speld:1.0.0")
        }
        androidUnitTest.dependencies {
            implementation(libs.junit)
            implementation(libs.androidx.junit)
            implementation(libs.androidx.espresso.core)
        }
        iosMain.dependencies {  }
    }
}

android {
    namespace = "id.neotica.droidcore"
    compileSdk = 36

    defaultConfig {
        minSdk = 24

//        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }
    buildFeatures {
        compose = true
    }
    buildTypes {
        debug {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
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

    publishing {
        publishing {
            singleVariant("release") {
                withSourcesJar()
                withJavadocJar()
            }
        }
    }
}


mavenPublishing {
    publishToMavenCentral(SonatypeHost.CENTRAL_PORTAL)

    signAllPublications()

    coordinates(
        groupId = "id.neotica",
        artifactId = "droidcore",
        version = "1.3.1.3"
    )

    pom {
        name = "Droidcore"
        description = "Droidcore is a Kotlin MultiPlatform library that gives you various pre-built Compose-Multiplatform components, curated and built with love from the team at Neotica."
        inceptionYear = "2024"
        url = "https://github.com/laetuz/Droidcore"
        licenses {
            license {
                name = "The Apache License, Version 2.0"
                url = "https://www.apache.org/licenses/LICENSE-2.0.txt"
                distribution = "https://www.apache.org/licenses/LICENSE-2.0.txt"
            }
        }
        developers {
            developer {
                id = "laetuz"
                name = "Ryo Martin"
                url = "https://github.com/laetuz/"
            }
        }
        scm {
            url = "https://github.com/laetuz/Droidcore"
            connection = "scm:git:git://github.com/laetuz/Droidcore.git"
            developerConnection = "scm:git:ssh://git@github.com/laetuz/Droidcore.git"
        }
    }
}

//publishing {
//    publications {
//        create<MavenPublication>("bar") {
//            from(components["release"])
//            groupId = "com.github.laetuz"
//            artifactId = "droidcore-neotica"
//            version = "1.3.0"
//        }
//        publications.withType<MavenPublication> {
//            artifact(javadocJar.get())
//
//            pom {
//                name.set("Droidcore")
//                description.set("Droidcore")
//            }
//        }


//        groupId = "id.neotica"
//        artifactId = "droidcore"
//        version = "1.3.1"
//    }
//}

//afterEvaluate {
//    publishing.publications.all {
//        this as MavenPublication
//
//        groupId = "com.github.laetuz"
//        artifactId = "droidcore-neotica"
//        version = "1.3.1"
//    }

    /**og version**/
//    publishing {
//        publications {
//            create<MavenPublication>("maven") {
//                from(components["release"])
//                groupId = "com.github.laetuz"
//                artifactId = "droidcore-neotica"
//                version = "1.3.0"
//            }
//        }
//    }
//}

//val javadocJar by tasks.registering(Jar::class) {
//    archiveClassifier.set("javadoc")
//}