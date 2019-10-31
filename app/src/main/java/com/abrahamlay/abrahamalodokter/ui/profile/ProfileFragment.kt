package com.abrahamlay.abrahamalodokter.ui.profile


import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer

import com.abrahamlay.abrahamalodokter.R
import com.abrahamlay.abrahamalodokter.ui.base.BaseActivity
import com.abrahamlay.abrahamalodokter.ui.base.BaseFragment
import com.abrahamlay.abrahamalodokter.ui.util.Const
import com.abrahamlay.domain.common.ResultState
import com.abrahamlay.domain.entity.Entity
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.fragment_profile.*
import org.koin.androidx.viewmodel.ext.android.viewModel


/**
 * A simple [Fragment] subclass.
 * Use the [ProfileFragment.newInstance] factory method to
 * create an instance of this fragment.
 *
 */
class ProfileFragment : BaseFragment<ProfileViewModel>() {

    override val viewModel by viewModel<ProfileViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }


    private fun getProfile() {
        val parentActivity = activity as BaseActivity<*>
        val username = parentActivity.editor.getString(Const.PARAM_USERNAME)
        val password = parentActivity.editor.getString(Const.PARAM_PASSWORD)
        viewModel.getDetails(username!!, password!!)
    }

    override fun onInitViews() {
        super.onInitViews()
        getProfile()
    }

    override fun onInitObservers() {
        super.onInitObservers()
        viewModel.getDetailData.observe(this, Observer {
            when (it) {
                is ResultState.Success -> {
                    onProfileLoaded(it.data)
                    println("ProfileFragment ${it.data.userName}")
                }
                is ResultState.Error -> {
                    Toast.makeText(context, it.throwable.message, Toast.LENGTH_SHORT).show()
                }
                is ResultState.Loading -> {
                    println("ProfileFragment loading")
                }
            }
        })
    }

    private fun onProfileLoaded(user: Entity.User) {
        val uri = Uri.parse(user.picture)
        Glide.with(this).load(uri).into(iv_profile)

        tv_name.text = user.userName
        tv_gender.text = user.gender
        tv_phone.text = user.phone
    }

}
