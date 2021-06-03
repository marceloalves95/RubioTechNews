package br.com.rubiotechnews.ui.favorito

import android.os.Bundle
import android.view.*
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import br.com.rubiotechnews.R
import br.com.rubiotechnews.databinding.FragmentFavoritosBinding

class FavoritosFragment : Fragment() {

    //private lateinit var favoritosViewModel: FavoritosViewModel
    private var _binding: FragmentFavoritosBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View{

        _binding = FragmentFavoritosBinding.inflate(inflater, container, false)
        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_main, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {

            R.id.action_configuration -> { findNavController().navigate(R.id.action_navigation_favorite_to_bottomSheetFragment)}

        }

        return super.onOptionsItemSelected(item)

    }
}