package br.com.rubiotechnews.ui.favorito

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import br.com.rubiotechnews.R

class DetailFavoritosFragment : Fragment() {


    //private lateinit var viewModel: DetailFavoritosViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.detail_favoritos_fragment, container, false)
    }


}