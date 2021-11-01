package com.example.palermo.models


data class Productos(
        var id: Long = 0,
        var descripcion: String = "",
        var nombre: String = "",
        var codigo: String = "",
        var cantidad: Int? = null,
        var codCategoria: String? = null)