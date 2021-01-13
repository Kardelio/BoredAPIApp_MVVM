package bk.personal.com.bored.network

import bk.personal.com.bored.model.BoredItem
import retrofit2.http.GET


interface IBoredService {

    @GET("/api/activity/")
    suspend fun getBoredActivity() : BoredItem

}