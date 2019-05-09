package com.github.coolice.lottieissue.view

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.FrameLayout
import com.airbnb.lottie.LottieAnimationView
import com.github.coolice.lottieissue.R

class LottieView : FrameLayout {
    private lateinit var lottieAnimationView: LottieAnimationView
    private var lottiViewListener: LottiViewListener? = null

    interface LottiViewListener {
        fun onAnimationEnd()
    }

    internal inner class LottieAnimatorListener : AnimatorListenerAdapter() {

        override fun onAnimationEnd(animator: Animator) {
            super.onAnimationEnd(animator)
            if (this@LottieView.lottiViewListener != null) {
                this@LottieView.lottiViewListener!!.onAnimationEnd()
            }
        }
    }


    constructor(context: Context) : super(context) {
        init(context)
    }

    constructor(context: Context, attributeSet: AttributeSet) : super(context, attributeSet) {
        init(context)
    }

    constructor(context: Context, attributeSet: AttributeSet, i: Int) : super(context, attributeSet, i) {
        init(context)
    }

    private fun init(context: Context) {
        View.inflate(context, R.layout.ui_lottieview, this)
        lottieAnimationView = findViewById(R.id.internal_lottie_view)
        val lottieAnimationView = this.lottieAnimationView
        lottieAnimationView.addAnimatorListener(LottieAnimatorListener())
    }

    fun start(enable: Boolean) {
        visibility = View.VISIBLE
        try {
            lottieAnimationView.visibility = View.VISIBLE
            lottieAnimationView.isEnabled = enable
            lottieAnimationView.progress = 0.0f
            lottieAnimationView.playAnimation()
        } catch (e: Exception) {
            visibility = View.GONE
            e.printStackTrace()
        }

    }

    fun setListener(lottieViewLListener: LottiViewListener) {
        lottiViewListener = lottieViewLListener
    }

    fun setLottiePath(lottiePath: String) {
        try {
            lottieAnimationView.setAnimation(lottiePath)
        } catch (e: Exception) {
            e.printStackTrace()
        }

    }

    fun setLottieRawRes(rawRes: Int) {
        try {
            lottieAnimationView.setAnimation(rawRes)
        } catch (e: Exception) {
            e.printStackTrace()
        }

    }

    fun setLottieImageFolder(path: String) {
        try {
            lottieAnimationView.imageAssetsFolder = path
        } catch (e: Exception) {
            e.printStackTrace()
        }

    }

    fun setProgress(progress: Float) {
        visibility = View.VISIBLE
        try {
            lottieAnimationView.visibility = View.VISIBLE
            lottieAnimationView.progress = progress
        } catch (e: Exception) {
            visibility = View.GONE
            e.printStackTrace()
        }

    }
}
