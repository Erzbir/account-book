pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "AccountBook"
include(":app")
include("accountbook-api")
include("accountbook-core")
include("dispatcher-api")
include("dispatcher-core")
include("mock")
