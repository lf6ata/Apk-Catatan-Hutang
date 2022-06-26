package com.example.apk_catatan_hutang.Activity

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.apk_catatan_hutang.Model.RespondRead
import com.example.apk_catatan_hutang.R

class Main_Adapter(
    val result: ArrayList<RespondRead.Data>,
    val listener: OnAdapterListener

):RecyclerView.Adapter<Main_Adapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.main_adapter, parent, false)
    )

    override fun getItemCount():Int {
        return result.size
        //return body.size
    }

    override fun onBindViewHolder(holder: Main_Adapter.ViewHolder, position: Int) {
        val data = result[position]

        holder.view.findViewById<TextView>(R.id.tv_NmNgutang).text = data.nm_penghutang
        holder.view.findViewById<TextView>(R.id.tv_catatan).text = data.catatan
        holder.view.findViewById<TextView>(R.id.tv_JmlhHutang).text = data.jumlah

        holder.view.findViewById<ImageView>(R.id.btn_edit).setOnClickListener{
            listener.onUpdate(data)
        }

        holder.view.findViewById<ImageView>(R.id.btn_delete).setOnClickListener{
            listener.onDelete(data)
        }
    }
    class ViewHolder(val view: View): RecyclerView.ViewHolder(view)

    public fun setData(data: List<RespondRead.Data>){
        result.clear()
        result.addAll(data)
        notifyDataSetChanged()
    }

    interface OnAdapterListener{
        fun onUpdate(hasil: RespondRead.Data)
        fun onDelete(hasil: RespondRead.Data)
    }
}