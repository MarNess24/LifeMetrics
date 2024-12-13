package com.example.lifemetrics.actividad

import com.example.lifemetrics.conexion.RetrofitClient
import com.example.lifemetrics.data.Paciente
import com.example.lifemetrics.data.PacienteApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

fun registrarPaciente(
    token: String,
    paciente: Paciente,
    onSuccess: () -> Unit,
    onError: (String) -> Unit
) {
    val pacienteApi = RetrofitClient.instance.create(PacienteApi::class.java)

    pacienteApi.crearPaciente("Bearer $token", paciente).enqueue(object : Callback<Paciente> {
        override fun onResponse(call: Call<Paciente>, response: Response<Paciente>) {
            if (response.isSuccessful) {
                onSuccess()
            } else {
                onError("Error: ${response.errorBody()?.string()}")
            }
        }

        override fun onFailure(call: Call<Paciente>, t: Throwable) {
            onError("Error en la solicitud: ${t.message}")
        }
    })
}

fun obtenerPacientes(
    token: String,
    onSuccess: (List<Paciente>) -> Unit,
    onError: (String) -> Unit
) {
    val pacienteApi = RetrofitClient.instance.create(PacienteApi::class.java)

    pacienteApi.obtenerPacientes("Bearer $token").enqueue(object : Callback<List<Paciente>> {
        override fun onResponse(call: Call<List<Paciente>>, response: Response<List<Paciente>>) {
            if (response.isSuccessful) {
                response.body()?.let(onSuccess) ?: onError("Respuesta vacía del servidor")
            } else {
                onError("Error: ${response.errorBody()?.string()}")
            }
        }

        override fun onFailure(call: Call<List<Paciente>>, t: Throwable) {
            onError("Error en la solicitud: ${t.message}")
        }
    })
}

fun eliminarPaciente(
    token: String,
    id: String,
    onSuccess: () -> Unit,
    onError: (String) -> Unit
) {

    val pacienteApi = RetrofitClient.instance.create(PacienteApi::class.java)
    val body = mapOf("id" to id) // Crear el cuerpo de la solicitud

    pacienteApi.eliminarPaciente("Bearer $token", body).enqueue(object : Callback<Unit> {
        override fun onResponse(call: Call<Unit>, response: Response<Unit>) {
            if (response.isSuccessful) {
                //Log.d("EliminarPaciente", "Paciente eliminado exitosamente")
                onSuccess()
            } else {
                val errorBody = response.errorBody()?.string()
                //Log.e("EliminarPaciente", "Error en respuesta: $errorBody")
                onError("Error en la solicitud: ${response.code()} - $errorBody")
            }
        }

        override fun onFailure(call: Call<Unit>, t: Throwable) {
            //Log.e("EliminarPaciente", "Error de red: ${t.message}")
            onError("Error de red: ${t.message}")
        }
    })
}
