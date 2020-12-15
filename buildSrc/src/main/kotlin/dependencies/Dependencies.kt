package dependencies

object Dependencies {

    const val apache_commons_lang3 = "org.apache.commons:commons-lang3:${Versions.apache_commons_lang3}"

    const val dagger_hilt = "com.google.dagger:hilt-android:${Versions.dagger_hilt}"

    const val glide = "com.github.bumptech.glide:glide:${Versions.glide}"

    const val hilt_android = "androidx.hilt:hilt-lifecycle-viewmodel:${Versions.hilt_android}"

    const val lifecycle_coroutines = "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.lifecycle}"
    const val lifecycle_runtime = "androidx.lifecycle:lifecycle-runtime:${Versions.lifecycle}"
    const val lombok = "org.projectlombok:lombok:${Versions.lombok}"

    const val map_struct = "org.mapstruct:mapstruct:${Versions.map_struct}"

    const val navigation_dynamic = "androidx.navigation:navigation-dynamic-features-fragment:${Versions.nav_components}"
    const val navigation_fragment = "androidx.navigation:navigation-fragment-ktx:${Versions.nav_components}"
    const val navigation_runtime = "androidx.navigation:navigation-runtime:${Versions.nav_components}"
    const val navigation_ui = "androidx.navigation:navigation-ui-ktx:${Versions.nav_components}"

    const val ok_http = "com.squareup.okhttp3:okhttp:${Versions.ok_http}"
    const val ok_http_logging_interceptor = "com.squareup.okhttp3:logging-interceptor:${Versions.ok_http_logging_interceptor}"

    const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit2}"
    const val retrofit_jakson = "com.squareup.retrofit2:converter-jackson:${Versions.retrofit2}"
    const val room_runtime = "androidx.room:room-runtime:${Versions.room}"

    const val sdp = "com.intuit.sdp:sdp-android:${Versions.sdp}"

    const val timber = "com.jakewharton.timber:timber:${Versions.timber}"
}