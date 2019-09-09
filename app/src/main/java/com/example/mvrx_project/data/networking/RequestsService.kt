package com.example.mvrx_project.data.networking

import android.annotation.SuppressLint
import android.util.Log
import com.example.mvrx_project.App
import com.example.mvrx_project.data.db.models.ContributorEntity
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

object RequestsService {
    @SuppressLint("CheckResult")
    fun getRepos() {

        val retrofit = RetrofitService.getRetrofit()

        val mAPIService: APIService = retrofit.create(APIService::class.java)

        mAPIService.fetchRepos()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ response ->
                response.map {
                    val contributor = ContributorEntity()

                    contributor.setId(it.id)
                    contributor.setLogin(it.login)

                // TODO: handle disposable
                App
                    .dataStore
                    .insert(contributor)
                    .toObservable()
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe({
                        Log.d("insert", it.toString())
                    }, Throwable::printStackTrace)

                }
            }, Throwable::printStackTrace)
    }
}