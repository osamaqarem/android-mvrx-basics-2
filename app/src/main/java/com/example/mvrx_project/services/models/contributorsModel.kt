package com.example.mvrx_project.services.models

import com.google.gson.annotations.SerializedName

data class contributorsModel(
    @SerializedName("login") val login: String
)