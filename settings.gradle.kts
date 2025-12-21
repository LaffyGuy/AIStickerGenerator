pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
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

rootProject.name = "AIStickerGenerator"
include(":app")
include(":core:essentials")
include(":core:common-android")
include(":features:init:domain")
include(":features:init:presentation")
include(":core:theme")
include(":features:main:domain")
include(":features:main:presentation")
include(":data")
include(":glue")
include(":features:prompts:domain")
include(":features:prompts:presentation")
include(":features:gallery:domain")
include(":features:gallery:presentation")
include(":core:data")
include(":navigation:common")
include(":navigation:host")
