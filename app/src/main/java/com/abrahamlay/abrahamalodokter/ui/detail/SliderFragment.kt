package com.abrahamlay.abrahamalodokter.ui.detail

import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.abrahamlay.abrahamalodokter.R
import com.abrahamlay.abrahamalodokter.ui.base.BaseFragment
import com.abrahamlay.abrahamalodokter.ui.home.HomeViewModel
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.fragment_item_slider.*
import org.koin.androidx.viewmodel.ext.android.viewModel


class SliderFragment : BaseFragment<HomeViewModel>() {
    override val viewModel by viewModel<HomeViewModel>()

    private var imageUrls: String? = null

    companion object {
        private const val ARG_PARAM1 = "params"
        fun newInstance(params: String): SliderFragment {
            val fragment = SliderFragment()
            val args = Bundle()
            args.putString(ARG_PARAM1, params)
            fragment.arguments = args
            return fragment
        }
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_item_slider, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        imageUrls = arguments.let { it?.getString(ARG_PARAM1) }
        val uri = Uri.parse(imageUrls)
        Glide.with(activity!!).load(uri).into(iv_detail_team)
    }
}