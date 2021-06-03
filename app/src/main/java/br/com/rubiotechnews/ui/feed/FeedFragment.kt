package br.com.rubiotechnews.ui.feed

import android.content.Context
import android.os.Bundle
import android.view.*
import androidx.appcompat.app.AppCompatDelegate
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.rubiotechnews.R
import br.com.rubiotechnews.adapter.FeedAdapter
import br.com.rubiotechnews.databinding.FragmentFeedBinding
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect

@AndroidEntryPoint
class FeedFragment : Fragment() {

    private val feedViewModel: FeedViewModel by viewModels()
    private var _binding: FragmentFeedBinding? = null
    private val binding get() = _binding!!
    private lateinit var adapter:FeedAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentFeedBinding.inflate(inflater, container, false)
        setHasOptionsMenu(true)
        //verificadorTheme()
        binding.swipeLayout.setOnRefreshListener {

            binding.swipeLayout.isRefreshing = false

            //mensagemAtualizada("Atualização Concluida")

        }
        listaNoticias()
        return binding.root
    }

    private fun mensagemAtualizada(mensagem: String) {
        Snackbar.make(requireView(), mensagem, Snackbar.LENGTH_SHORT).show()
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

            R.id.action_configuration -> { findNavController().navigate(R.id.action_navigation_feed_to_bottomSheetFragment)}

        }

        return super.onOptionsItemSelected(item)

    }

    private fun verificadorTheme(){

        val sharedPref = requireActivity().getSharedPreferences("AppSettingPref", Context.MODE_PRIVATE)
        val isNightModeOn = sharedPref.getBoolean("NightMode", false)

        if (isNightModeOn){
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
        }
        else{
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        }


    }

    private fun setupRecyclerView(){

        binding.recyclerView.layoutManager = LinearLayoutManager(context)
        binding.recyclerView.setHasFixedSize(true)
        binding.recyclerView.adapter = adapter
        //binding.recyclerView.adapter = adapter
        //ed9fed978fd64d9082a6176832365789

    }

    fun listaNoticias(){
        feedViewModel.getNews()
        lifecycleScope.launchWhenStarted {

            feedViewModel.feedstate.collect { state->
                with(state){
                    when(this){
                        FeedState.Empty -> TODO()
                        is FeedState.Error -> {
                            mensagemAviso(message)
                        }
                        is FeedState.Loading -> {
                            binding.swipeLayout.isRefreshing = isLoading
                        }
                        is FeedState.Sucess ->{

                            response?.let {newsResponse->
                                adapter = FeedAdapter(newsResponse.articles)
                                setupRecyclerView()
                            }

                        }
                    }
                }

            }

        }
    }

    private fun mensagemAviso(mensagem: String) {
        Snackbar.make(requireView(), mensagem, Snackbar.LENGTH_SHORT).show()
    }
}