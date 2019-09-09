package com.example.mvrx_project.data.db.models

import io.requery.Entity
import io.requery.Key

@Entity
interface Contributor {
    val login: String?
    @get:Key
    val id: Int?
}