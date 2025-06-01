import org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi
import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    alias(libs.plugins.androidApplication)
//    alias(libs.plugins.jetbrainsKotlinAndroid)
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.compose.compiler)
    alias(libs.plugins.composeMultiplatform)
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
            baseName = "ComposeApp"
            isStatic = true
        }
    }

//    jvm("desktop")

//    @OptIn(ExperimentalWasmDsl::class)
//    wasmJs {
//        moduleName = "composeApp"
//        browser {
//            val rootDirPath = project.rootDir.path
//            val projectDirPath = project.projectDir.path
//            commonWebpackConfig {
//                outputFileName = "composeApp.js"
//                devServer = (devServer ?: KotlinWebpackConfig.DevServer()).apply {
//                    static = (static ?: mutableListOf()).apply {
//                        // Serve sources to debug inside browser
//                        add(rootDirPath)
//                        add(projectDirPath)
//                    }
//                }
//            }
//        }
//        binaries.executable()
//    }

    sourceSets {
//        val desktopMain by getting

        androidMain.dependencies {
            implementation(libs.androidx.core.ktx)
            implementation(libs.androidx.activity.compose)

            implementation(libs.androidx.ui.test.manifest)

            //Slider
            implementation("io.github.seyoungcho2:filled-slider-compose:1.0.0")

//            implementation(project(":droidcore"))

        //    implementation(projects.droidcore)

        }
        androidUnitTest.dependencies {
            implementation(libs.junit)
        }
        androidInstrumentedTest.dependencies {
//            implementation(libs.bundles.android.unit.test)
            implementation(libs.androidx.junit)
            implementation(libs.androidx.espresso.core)
        }
        iosMain.dependencies {
//            implementation(libs.ktor.client.darwin)
        }
        commonMain.dependencies {
            implementation(project(":droidcore"))

            //cmp
            implementation(libs.bundles.compose.multiplatform)
            implementation(libs.compose.ui) //implementation(libs.androidx.ui)
            implementation(compose.material3) //implementation(libs.androidx.material3)
            implementation(compose.runtime)
            implementation(compose.foundation)
            implementation(libs.compose.ui.tooling)
        }
        commonTest.dependencies {
//            implementation(libs.kotlin.test)
        }
//        desktopMain.dependencies {
////            implementation(compose.desktop.currentOs)
////            implementation(libs.kotlinx.coroutinesSwing)
//        }
    }
}

android {
    namespace = "id.neotica.droidcore"
    compileSdk = 35

    defaultConfig {
        applicationId = "id.neotica.droidcore"
        minSdk = 27
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

//        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
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
            isMinifyEnabled = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
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
}

//dependencies {
//    implementation(libs.androidx.core.ktx)
//    implementation(libs.androidx.activity.compose)
//
//    //cmp
//    implementation(libs.bundles.compose.multiplatform)
//    implementation(libs.compose.ui) //implementation(libs.androidx.ui)
//    implementation(compose.material3) //implementation(libs.androidx.material3)
//    implementation(compose.runtime)
//    implementation(compose.foundation)
//
//    testImplementation(libs.junit)
//    androidTestImplementation(libs.androidx.junit)
//    androidTestImplementation(libs.androidx.espresso.core)
//    debugImplementation(libs.compose.ui.tooling)
//    debugImplementation(libs.androidx.ui.test.manifest)
//
//    //Slider
//    implementation("io.github.seyoungcho2:filled-slider-compose:1.0.0")
//    implementation(project(":droidcore"))
////    implementation(projects.droidcore)
//
////    implementation ("com.github.laetuz:Droidcore:1.1")
//}

