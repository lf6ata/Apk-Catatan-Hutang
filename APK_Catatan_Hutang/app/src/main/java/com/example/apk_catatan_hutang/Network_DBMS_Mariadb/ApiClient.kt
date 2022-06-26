package com.example.apk_catatan_hutang.Network_DBMS_Mariadb

import com.example.apk_catatan_hutang.Model.SubmitModel
import com.example.apk_catatan_hutang.Model.RespondRead
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiClient {

    //List Data
    @GET("view_data.php")
    fun data() : Call<RespondRead>

    //Edit Data
    @FormUrlEncoded
    @POST("edit.php")
    fun edit(
        @Field("id") id: String,
        @Field("nm_penghutang") nm_penghutang: String,
        @Field("catatan") catatan: String,
        @Field("jumlah") jumlah: String
    ):Call<SubmitModel>

    //Untuk Delete Data
    @FormUrlEncoded
    @POST("hapus.php")
    fun hapus(
        @Field("id") id: String,
    ):Call<SubmitModel>

    //Tambah Data
    @FormUrlEncoded
    @POST("tambah.php")
    fun tambah(
        @Field("nm_penghutang") nm_penghutang: String,
        @Field("catatan") catatan: String,
        @Field("jumlah") jumlah: String
    ):Call<SubmitModel>




}