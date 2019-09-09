package com.example.mvrx_project.data.networking

import com.example.mvrx_project.data.networking.models.ContributorResponseModel
import io.reactivex.Observable
import retrofit2.http.GET

interface APIService {
    @GET("/repos/airbnb/MvRx/contributors")
    fun fetchRepos(): Observable<List<ContributorResponseModel>>
}