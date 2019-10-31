package com.abrahamlay.abrahamalodokter.ui.home

import android.content.Intent
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.abrahamlay.abrahamalodokter.ui.base.BaseListFragment
import com.abrahamlay.abrahamalodokter.ui.detail.DetailActivity
import com.abrahamlay.domain.common.ResultState
import kotlinx.android.synthetic.main.fragment_list.*
import org.koin.androidx.viewmodel.ext.android.viewModel

/**
 * Created by Abraham Lay on 2019-10-31.
 */

class HomeFragment : BaseListFragment<HomeViewModel>(), ItemClickListener {

    override val viewModel by viewModel<HomeViewModel>()


    override fun loadData() {
        viewModel.getList()
    }


    override fun onInitViews() {
        super.onInitViews()
    }

    override fun onInitObservers() {
        super.onInitObservers()
        viewModel.getListData.observe(this, Observer {
            onFetchedList(it)
        })
    }

    private fun onFetchedList(it: ResultState<ArrayList<Int>>?) {
        when (it) {
            is ResultState.Success -> {
                showList(it.data)
                println("HomeFragment ${it.data.size}")
            }
            is ResultState.Error -> {
                Toast.makeText(context, it.throwable.message, Toast.LENGTH_SHORT).show()
            }
            is ResultState.Loading -> {
                println("HomeFragment loading")
            }
        }
    }

    private fun showList(data: java.util.ArrayList<Int>) {
        rv_list?.adapter = HomeAdapter(context, data, this)
        rv_list?.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
    }

    override fun onItemClicked(obj: Any, position: Int) {
        val intent = Intent(context, DetailActivity::class.java)
        startActivity(intent)
    }
}