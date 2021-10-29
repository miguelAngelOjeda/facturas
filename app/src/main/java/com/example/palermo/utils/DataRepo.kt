package com.example.palermo.utils

import android.util.Log
import com.example.palermo.models.Categorias
import com.example.palermo.models.Facturas
import com.example.palermo.models.Precios
import com.example.palermo.models.Productos
import com.example.palermo.network.ApiInterface
import coomecipar.example.palermo.auth.ConnectionError
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import okhttp3.MediaType
import okhttp3.MultipartBody
import okhttp3.RequestBody
import java.io.File
import java.util.*

class DataRepo(val api: ApiInterface) {

    companion object {
        val DEFAULT_PAGE = 2000
    }

    private data class PayLoad(val form: HashMap<String, RequestBody>, val file: MultipartBody.Part? )

    private fun createPartFromString(partString: String): RequestBody {
        return RequestBody.create(MultipartBody.FORM, partString)
    }

    fun getProductos(): Observable<List<Productos>> = api.getProductos()
            .compose(RxUtils.basicApi())

    fun getCategorias(): Observable<List<Categorias>> = api.getCategorias()
            .compose(RxUtils.basicApi())

    fun getPrecios(): Observable<List<Precios>> = api.getPrecios()
            .compose(RxUtils.basicApi())


    fun getFacturas(): Single<List<Facturas>> {
        return api.getFacturas()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .flatMap {
                if (!it.rows.isEmpty()) {
                    val data = it.rows!!
                    Single.just(data)
                } else {
                    Single.error(ConnectionError("Error"))
                }
            }

    }
}