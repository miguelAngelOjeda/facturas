package com.example.palermo.models


data class Precios(
        var id: Long = 0,
        var descripcion: String = "",
        var idDepartamento: String = "",
        var idPais: String = "",
        var idCiudad: String = "",
        var nivelUbicacion: String = "")