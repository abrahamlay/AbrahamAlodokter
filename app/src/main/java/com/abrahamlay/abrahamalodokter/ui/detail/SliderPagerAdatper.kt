package com.abrahamlay.abrahamalodokter.ui.detail


import android.util.Log
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import java.util.ArrayList

class SliderPagerAdapter(fm: FragmentManager, frags: List<Fragment>) : FragmentStatePagerAdapter(fm) {

    internal var mFrags: List<Fragment> = ArrayList()

    init {
        mFrags = frags
    }

    override fun getItem(position: Int): Fragment {
        val index = position % mFrags.size
        Log.d(TAG, "position: $position")
        Log.d(TAG, "index: $index")
        return SliderFragment.newInstance(mFrags[index].arguments!!.getString("params")!!)
    }

    override fun getCount(): Int {
        return Integer.MAX_VALUE
    }

    companion object {

        private val TAG = "SliderPagerAdapter"
    }

}