package com.example.mvrx_project.data.networking.models

import com.squareup.moshi.Json
import io.requery.Key

data class ContributorResponseModel(
    @Json(name = "login") val login: String? = null,
    @get:Key
    @Json(name = "id") val id: Int? = null
)