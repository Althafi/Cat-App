package com.example.catapi.utils

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.catapi.R
import com.example.catapi.domain.model.CatModel
import com.example.catapi.presentation.viewmodels.cat.CatActivity

class CatListAdapter (private val context: Context, var itemList:ArrayList<CatModel>): RecyclerView.Adapter<
        CatListAdapter.CatListViewHolder>(){
    inner class CatListViewHolder(view: View):RecyclerView.ViewHolder(view)
    {
        val catName :TextView = view.findViewById(R.id.txtCatName)
        val catImage :ImageView = view.findViewById(R.id.imgCatImage)
        val catCard :LinearLayout = view.findViewById(R.id.catsLinearLayout)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CatListViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recyclerview_grid,parent,false)
        return CatListViewHolder(view)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }
    @SuppressLint("NotifyDataSetChanged")
    fun setData(catList: ArrayList<CatModel>)
    {
        this.itemList.addAll(catList)
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: CatListViewHolder, position: Int) {
        val item = itemList[position]
        holder.catName.text = item.name
        val listImage = listOf<Int>(R.drawable.image1)
        Glide.with(context).load(item.imageUrl).placeholder(listImage[0]).into(holder.catImage)
        holder.catCard.setOnClickListener{
            val intent = Intent(context,CatActivity::class.java)
            intent.putExtra("id",item.id)
            context.startActivity(intent)
        }


    }

}