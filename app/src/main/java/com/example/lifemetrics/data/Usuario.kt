package com.example.lifemetrics.data

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

data class Usuario(
    val email: String,
    val contrasena: String
)

interface UsuarioApi {
    @POST("api/usuarios/")
    fun registrarUsuario(@Body usuario: Usuario): Call<Map<String, String>>

    @POST("api/usuarios/login")
    fun loginUsuario(@Body usuario: Usuario): Call<Map<String, String>>
}
