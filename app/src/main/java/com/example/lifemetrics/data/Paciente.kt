package com.example.lifemetrics.data

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.HTTP
import retrofit2.http.Header
import retrofit2.http.POST

data class Paciente(
    val id: String,
    val nombre: String,
    val edad: String,
    val sexo: String,
    val peso: String,
    val altura: String
)

interface PacienteApi {
    @GET("api/pacientes/")
    fun obtenerPacientes(@Header("Authorization") token: String): Call<List<Paciente>>

    @POST("api/pacientes/")
    fun crearPaciente(
        @Header("Authorization") token: String,
        @Body paciente: Paciente
    ): Call<Paciente>

    @HTTP(method = "DELETE", path = "api/pacientes/", hasBody = true)
    fun eliminarPaciente(
        @Header("Authorization") token: String,
        @Body body: Map<String, String>
    ): Call<Unit>
}
