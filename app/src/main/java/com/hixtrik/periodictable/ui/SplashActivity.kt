package com.hixtrik.periodictable.ui

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.hixtrik.periodictable.R

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        val splash = findViewById<ImageView>(R.id.splash)
        val title = findViewById<TextView>(R.id.splashTitle)
        title.startAnimation(AnimationUtils.loadAnimation(this, R.anim.slide))
        Glide.with(this).asGif().load(R.drawable.splash).into(splash)
        Handler().postDelayed({
            val intent = Intent(this@SplashActivity, MainActivity::class.java)
            startActivity(intent)
        }, 4000)
    }
}