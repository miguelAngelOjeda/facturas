package com.example.palermo.network

import com.example.palermo.models.Categorias
import com.example.palermo.models.Facturas
import com.example.palermo.models.Precios
import com.example.palermo.models.Productos
import io.reactivex.Observable
import io.reactivex.Single
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Response
import retrofit2.http.*

interface ApiInterface {

    /*@POST("sps/solicitud/guardar")
    fun postSolicitudSPS(@Body solicitud: PreSolicitud): Single<SingleApiRequest<SolicitudResponse>>*/

    @GET("precios")
    fun getPrecios(
            @Query("todos") todos: Boolean = false,
            @Query("page") page: Int = 0,
            @Query("rows") pageSize: Int = 100,
            @Query("_search") search: Boolean = false
    ): Observable<ApiRequest<Precios>>

    @GET("facturas")
    fun getFacturas(
        @Query("all") todos: Boolean = true,
        @Query("page") page: Int = 1,
        @Query("rows") pageSize: Int = 100,
        @Query("_search") search: Boolean = false
    ): Single<List<Facturas>>

    @GET("categorias")
    fun getCategorias(
            @Query("todos") todos: Boolean = false,
            @Query("page") page: Int = 0,
            @Query("rows") pageSize: Int = 100,
            @Query("_search") search: Boolean = false
    ): Observable<ApiRequest<Categorias>>

    @GET("productos")
    fun getProductos(
            @Query("todos") todos: Boolean = true,
            @Query("page") page: Int = 0,
            @Query("rows") pageSize: Int = 1000,
            @Query("_search") search: Boolean = false
    ): Observable<ApiRequest<Productos>>
}