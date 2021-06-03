package br.com.rubiotechnews.ui.viewpager.pages

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.ViewPager2
import br.com.rubiotechnews.R
import br.com.rubiotechnews.databinding.FragmentPageOneBinding
import br.com.rubiotechnews.databinding.FragmentPageSecondBinding

class PageSecondFragment : Fragment() {

    private var _binding: FragmentPageSecondBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPageSecondBinding.inflate(inflater, container, false)

        //val viewPager = activity?.findViewById<ViewPager2>(R.id.viewPager)
        binding.finish.setOnClickListener {
            findNavController().navigate(R.id.action_viewPagerFragment_to_mainActivity)
            onBoardingFinish()
        }
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private val onBoardingFinish:() -> Unit = {

        val sharedPref = requireActivity().getSharedPreferences("onBoarding", Context.MODE_PRIVATE)
        val editor = sharedPref.edit()
        editor.putBoolean("Finished", true)
        editor.apply()


    }
}