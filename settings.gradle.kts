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
    versionCatalogs {
        create("myProjectConfig") {
            from(files("gradle/myproject.config.toml"))
        }
    }
}
rootProject.name = "AndroidProjectTemplate"
include(":app")
include(":core-resource")
include(":core-ui")
