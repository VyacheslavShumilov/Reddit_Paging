package com.vshum.reddit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.vshum.reddit.databinding.ActivityMainBinding
import com.vshum.reddit.ui.MainFragment

class MainActivity : AppCompatActivity() {

    private val binding: ActivityMainBinding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {
            val fragmentTransition = supportFragmentManager.beginTransaction()
            fragmentTransition.replace(R.id.container, MainFragment())
            fragmentTransition.commit()
        }
    }
}