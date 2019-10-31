package com.abrahamlay.abrahamalodokter.ui.widget

import android.content.Context

import android.util.AttributeSet
import android.view.View
import android.view.animation.DecelerateInterpolator
import android.widget.Scroller
import androidx.viewpager.widget.ViewPager


class SliderView : ViewPager {

    val DEFAULT_SCROLL_DURATION = 200
    val SLIDE_MODE_SCROLL_DURATION = 1000

     constructor(ctx: Context) : super(ctx) init {
         init()
     }

     constructor(ctx: Context, attrs: AttributeSet) : super(ctx, attrs) init {
         init()
     }


    private fun init() {
        setDurationScroll(DEFAULT_SCROLL_DURATION)
        this.setOnTouchListener(View.OnTouchListener { v, event -> true })
    }

    fun setDurationScroll(millis: Int) {
        try {
            val viewpager = ViewPager::class.java
            val scroller = viewpager.getDeclaredField("mScroller")
            scroller.isAccessible = true
            scroller.set(this, OwnScroller(getContext(), millis))
        } catch (e: Exception) {
            e.printStackTrace()
        }

    }

     class OwnScroller(context: Context, durationScroll: Int) : Scroller(context, DecelerateInterpolator()) {

        private var durationScrollMillis = 1

        init {
            this.durationScrollMillis = durationScroll
        }

        override fun startScroll(startX: Int, startY: Int, dx: Int, dy: Int, duration: Int) {
            super.startScroll(startX, startY, dx, dy, durationScrollMillis)
        }
    }
 }