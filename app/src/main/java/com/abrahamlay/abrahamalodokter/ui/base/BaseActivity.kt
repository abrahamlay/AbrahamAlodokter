package com.abrahamlay.abrahamalodokter.ui.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.lifecycle.ViewModel
import androidx.navigation.fragment.NavHostFragment
import com.abrahamlay.abrahamalodokter.AndroidApplication
import com.abrahamlay.abrahamalodokter.ui.util.UtilSharedPreference


/**
 * Created by Abraham on 05/09/2018.
 */
abstract class BaseActivity<VM : ViewModel> : AppCompatActivity() {
    var editor: UtilSharedPreference = AndroidApplication.getInstance().editor

    private inline fun FragmentManager.inTransaction(func: FragmentTransaction.() -> FragmentTransaction) {
        beginTransaction().func().commit()
    }

    fun AppCompatActivity.replaceFragment(fragment: Fragment, frameId: Int) {
        supportFragmentManager.inTransaction { replace(frameId, fragment) }
    }

    abstract val resourceLayout: Int?
    abstract val viewModel: VM

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        resourceLayout?.let(this::setContentView)
        onInitViews()
        onInitObservers()
    }


    protected open fun onInitViews() = Unit

    protected open fun onInitObservers() = Unit

}