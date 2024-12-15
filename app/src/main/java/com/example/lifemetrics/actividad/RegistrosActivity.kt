package com.example.lifemetrics.actividad

import com.example.lifemetrics.conexion.RetrofitClient
import com.example.lifemetrics.data.Registro
import com.example.lifemetrics.data.RegistroApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

fun obtenerRegistros(
    pacienteId: String,
    onSuccess: (List<Registro>) -> Unit,
    onError: (String) -> Unit
) {
    val registroApi = RetrofitClient.instance.create(RegistroApi::class.java)
    val body = mapOf("id" to pacienteId) // Crear el cuerpo de la solicitud con el ID

    registroApi.obtenerRegistros(body).enqueue(object : Callback<List<Registro>> {
        override fun onResponse(call: Call<List<Registro>>, response: Response<List<Registro>>) {
            if (response.isSuccessful) {
                response.body()?.let(onSuccess) ?: onError("La respuesta del servidor está vacía")
            } else {
                val errorBody = response.errorBody()?.string()
                onError("Error en la solicitud: ${response.code()} - $errorBody")
            }
        }

        override fun onFailure(call: Call<List<Registro>>, t: Throwable) {
            onError("Error de red: ${t.message}")
        }
    })
}

fun enviarRegistro(
    pacienteId: String,
    fecha: String,
    hora: String,
    glucosa: String,
    presionSistolica: String,
    presionDiastolica: String,
    onSuccess: () -> Unit,
    onError: (String) -> Unit
) {
    val api = RetrofitClient.instance.create(RegistroApi::class.java)
    val body = mapOf(
        "id" to pacienteId,
        "fecha" to fecha,
        "hora" to hora,
        "glucosa" to glucosa,
        "presionS" to presionSistolica,
        "presionD" to presionDiastolica
    )

    api.crearRegistro(body).enqueue(object : Callback<Unit> {
        override fun onResponse(call: Call<Unit>, response: Response<Unit>) {
            if (response.isSuccessful) {
                onSuccess()
            } else {
                val errorBody = response.errorBody()?.string()
                onError("Error al guardar: $errorBody")
            }
        }

        override fun onFailure(call: Call<Unit>, t: Throwable) {
            onError("Error de red: ${t.message}")
        }
    })
}
