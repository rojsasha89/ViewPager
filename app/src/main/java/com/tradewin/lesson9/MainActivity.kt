package com.tradewin.lesson9

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.core.view.isInvisible
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {

    private lateinit var bntNext: Button
    private lateinit var bntPrev: Button
    private lateinit var pager: ViewPager2
    private lateinit var pins: TabLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()
        initListeners()
        initViewPager()
    }

    private fun initViews() {
        pager = findViewById(R.id.pager)
        bntNext = findViewById(R.id.btnNext)
        bntPrev = findViewById(R.id.btnPrev)
        pins = findViewById(R.id.pins)
    }

    private fun initListeners() {
        bntNext.setOnClickListener { pager.currentItem += 1 }
        bntPrev.setOnClickListener { pager.currentItem -= 1 }
        pager.onPageChange { changePageOnViewPager(it) }
    }

    private fun initViewPager() {
        pager.adapter = TitlePagerAdapter(getAdapterData())
        TabLayoutMediator(pins, pager) { _, _ -> }.attach()
    }

    private fun changePageOnViewPager(position: Int) {
        when {
            position == 0 -> {
                bntPrev.isInvisible = true
            }
            position + 1 == pager.adapter?.itemCount -> {
                bntNext.isInvisible = true
            }
            else -> {
                bntNext.isInvisible = false
                bntPrev.isInvisible = false
            }
        }
    }

    private fun getAdapterData(): ArrayList<OnBoardModel> {
        val dataList = arrayListOf<OnBoardModel>()
        dataList.add(
            OnBoardModel(
                "page 1",
                R.drawable.ic_baseline_ac_unit_24,
                R.color.teal_200
            )
        )
        dataList.add(
            OnBoardModel(
                "page 2",
                R.drawable.ic_baseline_animation_24,
                R.color.teal_700
            )
        )

        dataList.add(
            OnBoardModel(
                "page 3",
                R.drawable.ic_baseline_bathtub_24,
                R.color.purple_200
            )
        )

        return dataList
    }
}