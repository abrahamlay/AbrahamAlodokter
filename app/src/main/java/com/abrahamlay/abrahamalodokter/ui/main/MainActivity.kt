package com.abrahamlay.abrahamalodokter.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import com.abrahamlay.abrahamalodokter.R
import com.abrahamlay.abrahamalodokter.common.extension.replaceFragment
import com.abrahamlay.abrahamalodokter.ui.auth.AuthViewModel
import com.abrahamlay.abrahamalodokter.ui.base.BaseActivity
import com.abrahamlay.abrahamalodokter.ui.home.HomeFragment
import com.abrahamlay.abrahamalodokter.ui.home.HomeViewModel
import com.abrahamlay.abrahamalodokter.ui.profile.ProfileFragment
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : BaseActivity<HomeViewModel>() {

    override val resourceLayout: Int? = R.layout.activity_main
    override val viewModel by viewModel<HomeViewModel>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initNavigation()
    }

    private fun initNavigation() {
        bottom_navigation.setOnNavigationItemSelectedListener {
                item -> when(item.itemId){
            R.id.action_home->{
                replaceFragment(HomeFragment(),R.id.container )
                return@setOnNavigationItemSelectedListener true
            }
            R.id.action_profile->{
                replaceFragment(ProfileFragment(), R.id.container)
                return@setOnNavigationItemSelectedListener true
            }

            else->return@setOnNavigationItemSelectedListener true
        }
        }
        bottom_navigation.selectedItemId= R.id.action_home
    }
}
