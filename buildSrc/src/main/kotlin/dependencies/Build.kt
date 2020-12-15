package dependencies

object Build {
    const val build_tools = "com.android.tools.build:gradle:${Versions.gradle}"

    const val check_for_update = "com.github.ben-manes:gradle-versions-plugin:${Versions.check_for_update}"

    const val hilt_plugin = "com.google.dagger:hilt-android-gradle-plugin:${Versions.dagger_hilt}"

    const val navigation_safe_args = "androidx.navigation:navigation-safe-args-gradle-plugin:${Versions.navigation_safe_args}"

    const val spotless = "com.diffplug.spotless:spotless-plugin-gradle:${Versions.spotless}"
}