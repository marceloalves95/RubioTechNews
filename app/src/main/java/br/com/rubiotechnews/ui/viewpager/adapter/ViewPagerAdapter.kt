package br.com.rubiotechnews.ui.viewpager.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter

/**
 * Created by RubioAlves on 01/06/2021
 */
class ViewPagerAdapter(list:ArrayList<Fragment>, fm:FragmentManager, lifecycle:Lifecycle):FragmentStateAdapter(fm, lifecycle) {

    private val fragmentList = list

    override fun getItemCount(): Int = fragmentList.size
    override fun createFragment(position: Int): Fragment = fragmentList[position]
}