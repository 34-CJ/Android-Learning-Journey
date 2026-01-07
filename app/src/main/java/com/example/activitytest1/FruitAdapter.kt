package com.example.activitytest1

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
class Fruit(val name: String, val imageId: Int)



    // 2. 编写适配器
    class FruitAdapter(private val fruitList: List<Fruit>) :
        RecyclerView.Adapter<FruitAdapter.ViewHolder>() {

        // ViewHolder 内部类，用来缓存控件引用，避免重复 findViewById
        inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
            val fruitImage: ImageView = view.findViewById(R.id.fruitImage)
            val fruitName: TextView = view.findViewById(R.id.fruitName)
        }

        // A. 负责“买杯子”：创建 ViewHolder 实例
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.fruit_item, parent, false)
            return ViewHolder(view)
        }

        // B. 负责“往杯里倒水”：绑定具体数据
        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            val fruit = fruitList[position]
            holder.fruitName.text = fruit.name
            holder.fruitImage.setImageResource(fruit.imageId)
        }

        // C. 告诉列表一共有多少行
        override fun getItemCount() = fruitList.size
    }
