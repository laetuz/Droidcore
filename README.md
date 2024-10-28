Droidcore
=====
![Release](https://jitpack.io/v/laetuz/Droidcore.svg)

Droidcore is an Android library that gives you various pre-built Jetpack Compose component, curated and built with love from the team at [Neotica](https://neotica.id).

<img src="https://github.com/laetuz/Droidcore/assets/100233549/f05b510e-cdef-4e85-b1f5-a0008bdcce9a" width="300">

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
    implementation ("com.github.laetuz:Droidcore:1.2.5")
}
```
Remember to always add the latest release version.

List of components
=====
1. [NeoTextField](https://neotica.notion.site/9ee8c7af1e0f4c07a4e476726512fa34?pvs=25#bd553abe5644417b8740c55573704f56 'NeoTextField')

   <img src="https://github.com/laetuz/Droidcore/assets/100233549/92ae0a35-c8c9-4059-989e-aa5d2b67e19f" width="300">

2. [PasswordTextField](https://neotica.notion.site/9ee8c7af1e0f4c07a4e476726512fa34?pvs=25#e3dbcdc2b5b440f2a70bc47642464112 'PasswordTextField')

   <img src="https://github.com/laetuz/Droidcore/assets/100233549/a62614d0-358b-4d4e-ab7d-43e5b721104a" width="300">

3. [ButtonCard](https://neotica.notion.site/9ee8c7af1e0f4c07a4e476726512fa34?pvs=25#231c85863c224e40b2a5a188f0dabc53 'ButtonCard')

   <img src="https://github.com/laetuz/Droidcore/assets/100233549/da4f8e05-5426-4851-8305-fffa70c8839f" width="300">

4. [Pocket](https://neotica.notion.site/9ee8c7af1e0f4c07a4e476726512fa34?pvs=25#590db274f6164fcaa835636cd1d7533d 'Pocket')

   <img src="https://github.com/laetuz/Droidcore/assets/100233549/eb51b568-bbec-4edd-bcf6-4ada0d5ec5c9" width="300">

5. [NeoAlert](https://neotica.notion.site/9ee8c7af1e0f4c07a4e476726512fa34?pvs=25#dce2b0f3c01c4b7e83561fc7fc610011 'NeoAlert')

   <img src="https://github.com/laetuz/Droidcore/assets/100233549/027ac917-6115-423e-ad87-91ccb6e9f1fc" width="300">