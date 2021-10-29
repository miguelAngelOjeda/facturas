package com.example.palermo.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.palermo.R
import com.example.palermo.adapters.FacturasAdapter
import com.example.palermo.models.Facturas
import com.example.palermo.ui.BaseFragment
import com.example.palermo.utils.DataRepo
import com.example.palermo.utils.setup
import com.github.salomonbrys.kodein.instance
import kotlinx.android.synthetic.main.fragment_facturas.*


class FacturasFragment : BaseFragment() {
    val repo: DataRepo by injector.instance()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_facturas, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupUI()
    }

    private fun setupUI(){
        val valores = repo.getFacturas().blockingGet();
        val facturasAdapter = FacturasAdapter(valores);
        recyclerFacturas.setup(activity)
        recyclerFacturas.adapter = facturasAdapter

    }

}