package dependencies

object AndroidTestDependencies{

    const val espresso_core = "androidx.test.espresso:espresso-core:${Versions.espresso_core}"
    const val espresso_contrib = "androidx.test.espresso:espresso-contrib:${Versions.espresso_core}"
    const val fragment_testing = "androidx.fragment:fragment-testing:${Versions.fragment}"
    const val androidx_test_ext = "androidx.test.ext:junit-ktx:${Versions.androidx_test_ext}"
    const val navigation_testing = "androidx.navigation:navigation-testing:${Versions.nav_components}"

    const val instrumentation_runner = "androidx.test.runner.AndroidJUnitRunner"
}