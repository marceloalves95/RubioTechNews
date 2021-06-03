package br.com.rubiotechnews.ui.feed

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import br.com.rubiotechnews.R

class DetailFeedFragment : Fragment() {

    //private lateinit var viewModel: DetailFeedViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.detail_feed_fragment, container, false)
    }


}