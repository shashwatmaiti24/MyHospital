package com.col740.myhospital

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.col740.myhospital.Expandablelistview
import kotlinx.android.synthetic.main.list_draweritem.view.*
import kotlinx.android.synthetic.main.list_item.view.*
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat.startActivity

class DrawerAdapter(val context: Context, val draweritems : List<DrawerItem>) : RecyclerView.Adapter<DrawerAdapter.MyViewHolder>() {
    inner class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        var currentitem : DrawerItem? = null
        var currentposition : Int = 0

        init {
            itemView.drawerbutton.setOnClickListener{
                if (currentitem!!.title=="Home"){
                    Toast.makeText(context, currentitem!!.title +" was Clicked", Toast.LENGTH_SHORT).show()
                    val intent = Intent(context, MainActivity::class.java)
                    startActivity(context, intent, null)
                }else if (currentitem!!.title=="Search by Category") {
                    Toast.makeText(context, currentitem!!.title + " was Clicked", Toast.LENGTH_SHORT).show()
                    val intent = Intent(context, Expandablelistview::class.java)
                    startActivity(context, intent, null)
                }
                else if (currentitem!!.title=="Your Account") {
                    Toast.makeText(context, currentitem!!.title + " was Clicked", Toast.LENGTH_SHORT).show()
                    val intent = Intent(context, YourAccount::class.java)
                    startActivity(context, intent, null)
                }
            }
        }
        fun setData(item: DrawerItem?, pos: Int){
            itemView.drawerbutton.text = item!!.title
            currentitem = item
            currentposition = pos
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.list_draweritem, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return draweritems.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val draweritem = draweritems[position]
        holder.setData(draweritem, position)
    }
}
