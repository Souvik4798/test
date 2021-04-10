package com.example.retrofitinsert

import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface myapi {
@FormUrlEncoded
@POST("/android/connection.php")
fun getdata(@Field("fullname1")fullname:String, @Field("email")email:String,
@Field("address")address:String, @Field("password")password:String): Call<model>
}