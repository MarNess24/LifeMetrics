package com.example.lifemetrics.data

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST

data class Registro(
    val fechaHora: String,
    val glucosa: String,
    val presionS: String,
    val presionD: String,
    val pacienteId: String
)

interface RegistroApi {
    @GET("api/registros/")
    fun obtenerRegistros(@Header("Authorization") token: String): Call<List<Registro>>

    @POST("api/registros/")
    fun crearRegistro(
        @Header("Authorization") token: String,
        @Body registro: Registro
    ): Call<Registro>
}
