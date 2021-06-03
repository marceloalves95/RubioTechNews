package br.com.rubiotechnews.ui.viewpager.viewpager

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.rubiotechnews.databinding.FragmentViewPagerBinding
import br.com.rubiotechnews.ui.viewpager.adapter.ViewPagerAdapter
import br.com.rubiotechnews.ui.viewpager.pages.PageOneFragment
import br.com.rubiotechnews.ui.viewpager.pages.PageSecondFragment

class ViewPagerFragment : Fragment() {

    private var _binding: FragmentViewPagerBinding? = null
    private val binding get()= _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View{
        // Inflate the layout for this fragment
        _binding = FragmentViewPagerBinding.inflate(layoutInflater, container, false)

        val fragmentList = arrayListOf(PageOneFragment(), PageSecondFragment())

        val adapter = ViewPagerAdapter(fragmentList, requireActivity().supportFragmentManager, lifecycle)
        binding.viewPager.adapter = adapter

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }



}