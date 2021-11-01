package com.example.palermo.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import com.example.palermo.R
import com.example.palermo.adapters.FacturasAdapter
import com.example.palermo.adapters.ProductosAdapter
import com.example.palermo.models.Productos
import com.example.palermo.ui.BaseFragment
import com.example.palermo.utils.DataRepo
import com.example.palermo.utils.d
import com.example.palermo.utils.setup
import com.github.salomonbrys.kodein.instance
import kotlinx.android.synthetic.main.fragment_facturas.*
import kotlinx.android.synthetic.main.fragment_nueva_factura.*


class FacturasAddFragment : BaseFragment() {
    val repo: DataRepo by injector.instance()
    val fm: FragmentManager?
        get() = activity?.supportFragmentManager

    val productos : MutableList<Productos> = ArrayList();
    val adapterTrabajos: ProductosAdapter by lazy  { ProductosAdapter(requireContext(),fm!!, repo, productos) }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_nueva_factura, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupUI()

    }

    private fun setupUI(){
        d("hola")
        recycler_datos_factura.setup(activity)
        recycler_datos_factura.adapter = adapterTrabajos
        fabAgregarProducto.setOnClickListener {
            productos.add(Productos())
            adapterTrabajos.notifyDataSetChanged()
        }
    }

}