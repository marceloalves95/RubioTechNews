package br.com.rubiotechnews.ui.bottomsheet

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatDelegate
import br.com.rubiotechnews.R
import br.com.rubiotechnews.databinding.FragmentBottomSheetBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

/**
 * Created by RubioAlves on 02/06/2021
 */
class BottomSheetFragment : BottomSheetDialogFragment() {

    private var _binding: FragmentBottomSheetBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentBottomSheetBinding.inflate(inflater, container, false)
        initListView()

        return binding.root


    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


    private fun initListView() {

        val imagens: Array<Int> = arrayOf(R.drawable.ic_light_mode, R.drawable.ic_dark_mode)
        val temas: Array<String> = arrayOf("Tema Claro", "Tema Escuro")

        val adapter = ListCustomAdapter(
            temas,
            imagens,
            requireActivity(),
            android.R.layout.simple_list_item_1
        )
        binding.list.adapter = adapter

        binding.list.setOnItemClickListener { adapterView, _, position, _ ->

            val item = adapterView.getItemAtPosition(position)
            when (position) {
                0 -> getTheme(item as String)
                1 -> getTheme(item as String)
            }
        }


    }


    private fun getTheme(tema: String) {

        val sharedPref = requireActivity().getSharedPreferences("AppSettingPref", Context.MODE_PRIVATE)
        val editor = sharedPref.edit()

        if (tema == "Tema Claro"){
            editor.putBoolean("NightMode", false)
            editor.apply()
        }
        else{
            editor.putBoolean("NightMode", true)
            editor.apply()
        }

    }

}
