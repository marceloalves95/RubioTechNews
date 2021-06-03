package br.com.rubiotechnews.ui.splash

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatDelegate
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.preference.PreferenceManager
import br.com.rubiotechnews.R
import br.com.rubiotechnews.databinding.FragmentSplashBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashFragment : Fragment() {

    private var _binding:FragmentSplashBinding? = null
    private val binding get()= _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentSplashBinding.inflate(inflater, container, false)

        initSplash()
        return binding.root

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun initSplash(){

        CoroutineScope(Dispatchers.Main).launch {
            delay(3000L)

            if (onBoardingFinish()){
                findNavController().navigate(R.id.action_splashFragment_to_mainActivity)
                activity?.finish()
            }else{
                findNavController().navigate(R.id.action_splashFragment_to_viewPagerFragment)
            }

        }


    }

    private fun onBoardingFinish():Boolean{

        val sharedPref = requireActivity().getSharedPreferences("onBoarding", Context.MODE_PRIVATE)

        return sharedPref.getBoolean("Finished", false)


    }




}