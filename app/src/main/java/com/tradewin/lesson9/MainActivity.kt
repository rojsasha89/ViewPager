package com.tradewin.lesson9

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val pager = findViewById<ViewPager2>(R.id.pager)

        val list = arrayListOf<String>()
        val list1 = arrayListOf<Int>()
        list.add("page 1")
        list.add("page 2")
        list.add("page 3")
        list1.add(R.drawable.ic_baseline_ac_unit_24)
        list1.add(R.drawable.ic_baseline_animation_24)
        list1.add(R.drawable.ic_baseline_bathtub_24)
        pager.adapter = TitlePagerAdapter(list, list1)



    }
}