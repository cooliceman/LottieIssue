package com.github.coolice.lottieissue

import android.os.Bundle
import android.os.Handler
import android.support.v7.app.AppCompatActivity
import com.github.coolice.lottieissue.view.LottieView

class LottieActivity : AppCompatActivity() {
    internal lateinit var lottieView1: LottieView
    internal lateinit var lottieView2: LottieView
    internal lateinit var lottieView3: LottieView
    internal lateinit var lottieView4: LottieView
    internal var handler = Handler()
    internal var playRunnable: Runnable = object : Runnable {
        override fun run() {
            playAnimation(lottieView1, "lottiefiles/angel.zip")
            playAnimation(lottieView2, "lottiefiles/camptravel.zip")
            playAnimation(lottieView3, "lottiefiles/geometry.zip")
            playAnimation(lottieView4, "lottiefiles/sky.zip")
            handler.postDelayed(this, 5000)
        }

    }

    internal var playRunnable2: Runnable = object : Runnable {
        override fun run() {
            playAnimation(lottieView1, "lottiefiles/angel.json", "lottiefiles/images")
            playAnimation(lottieView2, "lottiefiles/camptravel.json", "lottiefiles/images")
            playAnimation(lottieView3, "lottiefiles/geometry.json", "lottiefiles/images")
            playAnimation(lottieView4, "lottiefiles/sky.json", "lottiefiles/images")
            handler.postDelayed(this, 5000)
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lottie)
        lottieView1 = findViewById(R.id.lottieView)
        lottieView2 = findViewById(R.id.lottieView2)
        lottieView3 = findViewById(R.id.lottieView3)
        lottieView4 = findViewById(R.id.lottieView4)
        handler.postDelayed(playRunnable, 3000)
    }

    private fun playAnimation(lottieView: LottieView, asset: String) {
        lottieView.setLottiePath(asset)
        lottieView.start(false)
    }

    private fun playAnimation(lottieView: LottieView, asset: String, imageFolder: String) {
        lottieView.setLottieImageFolder(imageFolder)
        lottieView.setLottiePath(asset)
        lottieView.start(false)
    }
}
