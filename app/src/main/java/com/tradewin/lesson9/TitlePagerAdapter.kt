package com.tradewin.lesson9

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView

class TitlePagerAdapter(private val dataList: ArrayList<OnBoardModel>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {


//    override fun onBindViewHolder(holder: TitleViewHolder, position: Int) {
//        holder.bind(list[position], list1[position], position)
//    }


    //    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TitleViewHolder {
//        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_onboard, parent, false)
//        return TitleViewHolder(view)
//    }
////
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            TYPE_SECOND_LAYOUT -> {
                val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_onboard_second, parent, false)
                TitleSecondViewHolder(view)
            }
            else -> {
                val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_onboard, parent, false)
                TitleViewHolder(view)
            }
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (getItemViewType(position)) {
            TYPE_SECOND_LAYOUT -> (holder as TitleSecondViewHolder).bind(
                dataList[position]
            )
            TYPE_FIRST_LAYOUT -> (holder as TitleViewHolder).bind(
                dataList[position]
            )
        }
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun getItemViewType(position: Int): Int {
        return when (position) {
            0, 1 -> TYPE_SECOND_LAYOUT
            else -> TYPE_FIRST_LAYOUT
        }
    }

    companion object {
        private const val TYPE_FIRST_LAYOUT = 100
        private const val TYPE_SECOND_LAYOUT = 101
    }
}


class TitleViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {

    private val tvTitle = view.findViewById<TextView>(R.id.tvTitle)
    private val imgTitle = view.findViewById<ImageView>(R.id.imgTitle)
    private val parentConstraint = view.findViewById<ConstraintLayout>(R.id.parentConstraint)

    fun bind(onBoardModel: OnBoardModel) {
        tvTitle.text = onBoardModel.title
        imgTitle.setImageResource(onBoardModel.image)
        parentConstraint.setBackgroundColor(
            itemView.context.resources.getColor(onBoardModel.backgroundColor)
        )

//        if (position == 1) {
//            val params = imgTitle.layoutParams
//            params.width = 10000
//            params.height = 1000
//            imgTitle.layoutParams = params
//        }
    }
}

class TitleSecondViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {

    private val tvTitle = view.findViewById<TextView>(R.id.tvTitle)
    private val imgTitle = view.findViewById<ImageView>(R.id.imgTitle)
    private val parentConstraint = view.findViewById<ConstraintLayout>(R.id.parentConstraint)

    fun bind(onBoardModel: OnBoardModel) {
        tvTitle.text = onBoardModel.title
        imgTitle.setImageResource(onBoardModel.image)
        parentConstraint.setBackgroundColor(
            itemView.context.resources.getColor(onBoardModel.backgroundColor)
        )

//        if (position == 1) {
//            val params = imgTitle.layoutParams
//            params.width = 10000c
//            params.height = 1000
//            imgTitle.layoutParams = params
//        }
    }
}