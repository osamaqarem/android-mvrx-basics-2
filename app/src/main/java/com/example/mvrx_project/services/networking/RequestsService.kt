package com.example.mvrx_project.services.networking

import android.util.Log
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

object RequestsService {

    fun getRepos() {

        val retrofit = RetrofitService.getRetrofit()

        val mAPIService: APIService = retrofit.create(APIService::class.java)

        val mDisposable: Disposable = mAPIService.listRepos()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({

                print("Request!")

            }, { t: Throwable? ->
                Log.e("getRepos", t?.message)
            })
    }
}