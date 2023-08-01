package chl.ancud.m6_individual2.presentation

import android.os.Binder
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import chl.ancud.m6_individual2.R
import chl.ancud.m6_individual2.databinding.ActivityMainBinding
import chl.ancud.m6_individual2.databinding.FragmentAgregarBinding

/**
 * A simple [Fragment] subclass.
 * Use the [AgregarFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class AgregarFragment : Fragment() {
    lateinit var binding: FragmentAgregarBinding
    private val viewModel: ItemViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentAgregarBinding.inflate(inflater, container, false)
        initListener()
        return binding.root
    }

    private fun initListener() {
        binding.btAgregar.setOnClickListener {
            val nombre = binding.etNombre.text.toString()
            val cantidad = binding.etCantidad.text.toString().toInt()
            val precio = binding.etPrecio.text.toString().toInt()

            viewModel.insertItem(nombre, precio, cantidad)
            Toast.makeText(context, "Item $nombre ingresado.", Toast.LENGTH_SHORT).show()
        }
    }


}