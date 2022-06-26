package com.example.apk_catatan_hutang.Model

import java.io.Serializable

data class RespondRead (
    val hasil : List<Data>
){
    data class Data(
        val id:String?,
        val nm_penghutang:String?,
        val catatan:String?,
        val jumlah:String?
    ): Serializable
}