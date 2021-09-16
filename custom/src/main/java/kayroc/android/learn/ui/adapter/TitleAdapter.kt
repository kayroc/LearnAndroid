package kayroc.android.learn.ui.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kayroc.android.learn.R
import kayroc.android.learn.entity.MenuEntity


/**
 * @author kayroc
 */
class TitleAdapter(private val mData: ArrayList<MenuEntity>) :
    RecyclerView.Adapter<TitleAdapter.ViewHolder>() {
    private var mListener: OnItemClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_main, parent, false)
        return ViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return mData.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = mData[position]
        holder.title.text = item.title
        Log.d("h", item.title)
        holder.itemView.setOnClickListener {
            mListener?.onItemClick(it, position)
        }
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title: TextView = itemView.findViewById(R.id.title)
    }

    fun setOnItemClickListener(listener: OnItemClickListener?) {
        this.mListener = listener
    }

    interface OnItemClickListener {
        fun onItemClick(view: View, position: Int)
    }

    fun getItem(position: Int): MenuEntity {
        return mData[position]
    }
}