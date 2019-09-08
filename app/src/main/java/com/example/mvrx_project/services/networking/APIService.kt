package com.example.mvrx_project.services.networking

import com.example.mvrx_project.services.models.contributorsModel
import io.reactivex.Observable
import retrofit2.http.GET

interface APIService {

    @GET("/repos/airbnb/MvRx/contributors")
    fun listRepos(): Observable<List<contributorsModel>>
}