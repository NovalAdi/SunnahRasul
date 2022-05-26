package com.vall.sunnahrasul

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.tabs.TabLayoutMediator
import com.vall.sunnahrasul.adapter.TabAdapter
import com.vall.sunnahrasul.databinding.ActivityPuasaSholatBinding

class PuasaSholatActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPuasaSholatBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPuasaSholatBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adapters = TabAdapter(supportFragmentManager, lifecycle)

        binding.imageView.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }

        binding.viewPager2.adapter = adapters
        TabLayoutMediator(binding.tabLayout, binding.viewPager2) {tab, position ->
            when (position) {
                0 -> {
                    tab.text = "Puasa"
                }
                1 -> {
                    tab.text = "Sholat"
                }
            }
        }.attach()
    }
}