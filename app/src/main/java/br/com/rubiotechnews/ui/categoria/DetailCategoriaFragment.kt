package br.com.rubiotechnews.ui.categoria

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import br.com.rubiotechnews.R

class DetailCategoriaFragment : Fragment() {

    //private lateinit var viewModel: DetailCategoriaViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.detail_categoria_fragment, container, false)
    }


}