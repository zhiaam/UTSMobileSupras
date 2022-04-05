/*
* Copyright (C) 2021 The Android Open Source Project.
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
*     http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/
package com.example.supras.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.supras.R
import com.example.supras.const.Layout
import com.example.supras.data.DataSource


class ItemAdapter(
    private val context: Context?,
    private val layout: Int
): RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {

    private val data = DataSource.suprass
    class ItemViewHolder(view: View?): RecyclerView.ViewHolder(view!!) {
        val imageView : ImageView = view!!.findViewById(R.id.item_image)
        val nama : TextView = view!!.findViewById(R.id.nama)
        val tahun : TextView = view!!.findViewById(R.id.tahun)
        val harga : TextView = view!!.findViewById(R.id.harga)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val adapterLayout = when(layout){
            Layout.VERTICAL -> {
                LayoutInflater.from(parent.context)
                    .inflate(R.layout.vertical_horizontal_list_item, parent, false)
            }

            Layout.HORIZONTAL -> {
                LayoutInflater.from(parent.context)
                    .inflate(R.layout.vertical_horizontal_list_item, parent, false)
            }

            else -> {
                LayoutInflater.from(parent.context)
                    .inflate(R.layout.grid_list_item, parent, false)
            }
        }
        return ItemViewHolder(adapterLayout)
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val resources = context?.resources

        val item = data[position]
        holder.imageView.setImageResource(item.imageResourceId)
        holder.nama.text = item.nama
        holder.tahun.text = resources?.getString(R.string.tahun , item.tahun)
        holder.harga.text = resources?.getString(R.string.harga , item.harga)
    }
}
