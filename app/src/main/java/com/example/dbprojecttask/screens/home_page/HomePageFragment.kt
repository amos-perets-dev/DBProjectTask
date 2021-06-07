package com.example.dbprojecttask.screens.home_page

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.dbprojecttask.R
import com.example.dbprojecttask.image_app.base.FragmentBase
import kotlinx.android.synthetic.main.fragment_home_page.*
import kotlinx.android.synthetic.main.fragment_home_page.view.*
import org.koin.android.ext.android.inject
import org.koin.android.viewmodel.ext.android.viewModel

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class HomePageFragment : FragmentBase<HomePageViewModel>() {

    private val imagesAdapter by inject<ImagesAdapter>()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val imagesItems = view.images_items
        imagesItems.adapter = imagesAdapter
        baseViewModel?.getImages()
        baseViewModel?.images?.observe(viewLifecycleOwner, Observer {
            Log.d("TEST_GAME", "it:$it")
            imagesAdapter.submitList(it)
            loader.visibility = View.INVISIBLE
        })
    }

    override fun getViewModel(): Lazy<HomePageViewModel> {
        return inject<HomePageViewModel>()
    }

    override fun getLayoutRes(): Int = R.layout.fragment_home_page
}