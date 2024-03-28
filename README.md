Droidcore
=====
![Release](https://jitpack.io/v/laetuz/Droidcore.svg)

Droidcore is an Android library that gives you various pre-built Jetpack Compose component, curated and built with love from the team of [Neotica](https://neotica.id).

<img src="https://github.com/laetuz/Droidcore/assets/100233549/8b34778f-2013-4962-994d-43d2f14f1989" width="300">


Implementing Droidcore to your project
=====
Go to your **settings.gradle** file:

settings.gradle
```gradle
    dependencyResolutionManagement {
        repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
        repositories {
            mavenCentral()
            //Add the line below
            maven { url 'https://jitpack.io' }
        }
    }
```

settings.gradle.kts
```gradle
    dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        //Add the line below
        maven { url = URI("https://jitpack.io") }
    }
```

And then add to your dependency on your build.gradle(app) file:
```gradle
dependencies {
    implementation ("com.github.laetuz:Droidcore:1.0.4.1")
}
```

List of components
=====
1. To be updated.
