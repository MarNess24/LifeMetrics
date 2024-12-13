package com.example.lifemetrics.actividad

import android.util.Log
import androidx.navigation.NavController
import com.example.lifemetrics.conexion.RetrofitClient
import com.example.lifemetrics.conexion.SessionManager
import com.example.lifemetrics.data.Usuario
import com.example.lifemetrics.data.UsuarioApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

fun iniciarSesion(
    email: String,
    contrasena: String,
    sessionManager: SessionManager,
    navController: NavController,
    onError: (String) -> Unit
){
    val usuarioApi = RetrofitClient.instance.create(UsuarioApi::class.java)
    val usuario = Usuario(email, contrasena)

    usuarioApi.loginUsuario(usuario).enqueue(object : Callback<Map<String, String>> {
        override fun onResponse(call: Call<Map<String, String>>, response: Response<Map<String, String>>) {
            if (response.isSuccessful) {
                val token = response.body()?.get("token")
                if (token != null) {
                    // Guardar el token en SessionManager
                    sessionManager.saveToken(token)

                    // Navegar a la pantalla principal
                    navController.navigate("home") {
                        popUpTo("login") { inclusive = true }
                    }
                } else {
                    //Log.e("API", "No se recibió token del servidor: ${response.body()}")
                    onError("No se recibió token del servidor")
                }
            } else {
                //Log.e("API", "Error en la solicitud: ${response.code()} - ${response.errorBody()?.string()}")
                onError("Credenciales invalidas")
            }
        }

        override fun onFailure(call: Call<Map<String, String>>, t: Throwable) {
            onError("Error en la solicitud: ${t.message}")
        }
    })
}

fun registrarse(
    email: String,
    contrasena: String,
    sessionManager: SessionManager,
    navController: NavController,
    onError: (String) -> Unit
){
    val usuarioApi = RetrofitClient.instance.create(UsuarioApi::class.java)
    val usuario = Usuario(email, contrasena)

    usuarioApi.registrarUsuario(usuario).enqueue(object : Callback<Map<String, String>> {
        override fun onResponse(call: Call<Map<String, String>>, response: Response<Map<String, String>>) {
            if (response.isSuccessful) {
                val token = response.body()?.get("token")
                if (token != null) {
                    // Guardar el token en SessionManager
                    sessionManager.saveToken(token)

                    // Navegar a la pantalla principal
                    navController.navigate("home") {
                        popUpTo("login") { inclusive = true }
                    }
                } else {
                    //Log.e("API", "No se recibió token del servidor: ${response.body()}")
                    onError("No se recibió token del servidor")
                }
            } else {
                //Log.e("API", "Error en la solicitud: ${response.code()} - ${response.errorBody()?.string()}")
                onError("Credenciales invalidas")
            }
        }

        override fun onFailure(call: Call<Map<String, String>>, t: Throwable) {
            onError("Error en la solicitud: ${t.message}")
        }
    })
}

fun cerrarSesion(navController: NavController, sessionManager: SessionManager) {
    sessionManager.clearSession() // Limpiar el token almacenado
    navController.navigate("login") {
        popUpTo("home") { inclusive = true } // Redirigir al login y limpiar la pila de navegación
    }
}


