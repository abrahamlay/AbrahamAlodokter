package com.abrahamlay.abrahamalodokter.ui.detail


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.abrahamlay.abrahamalodokter.BuildConfig
import com.abrahamlay.abrahamalodokter.R
import com.abrahamlay.abrahamalodokter.ui.widget.SliderIndicator
import kotlinx.android.synthetic.main.activity_detail.*
import java.util.*

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        setupSlider()
    }

    private lateinit var mAdapter: SliderPagerAdapter

    private lateinit var mIndicator: SliderIndicator

    private fun setupSlider() {
        slider_view.setDurationScroll(800)
        val fragments = ArrayList<Fragment>()
        fragments.add(SliderFragment.newInstance("android.resource://${BuildConfig.APPLICATION_ID}/" + R.drawable.img_arsenal))
        fragments.add(SliderFragment.newInstance("android.resource://${BuildConfig.APPLICATION_ID}/" + R.drawable.img_acm))
        fragments.add(SliderFragment.newInstance("android.resource://${BuildConfig.APPLICATION_ID}/" + R.drawable.img_bayern.toString()))
        fragments.add(SliderFragment.newInstance("android.resource://${BuildConfig.APPLICATION_ID}/" + R.drawable.img_chelsea.toString()))

        mAdapter = SliderPagerAdapter(supportFragmentManager, fragments)
        slider_view.adapter = mAdapter
        mIndicator =
            SliderIndicator(this, pages_container, slider_view, R.drawable.indicator_circle)
        mIndicator.setPageCount(fragments.size)
        mIndicator.show()
    }
}
