package kayroc.android.learn.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kayroc.android.learn.R

/**
 * @author kayroc
 */
class RecyclerViewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view)

        val data = listOf("Android", "Ios", "Html", "Css", "JavaScript", "Python", "C", "C++",
            "Ruby", "Docker", "MySql", "Java", "Go", "Maven", "Vue.js", "Jquery", "Node.js", "Bootstrap",
            "Xml", "Json", "Svg", "Svn", "Git", "Kotlin").sorted()

        val mRecyclerView = findViewById<RecyclerView>(R.id.recycler_view)
        mRecyclerView.layoutManager = LinearLayoutManager(this)
        val developAdapter = DevelopAdapter(data)
        mRecyclerView.adapter = developAdapter
    }

    class DevelopAdapter(private val list : List<String>) :
        RecyclerView.Adapter<DevelopAdapter.ViewHolder>() {

        inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
            val name: TextView = view.findViewById(android.R.id.text1)
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val view = LayoutInflater.from(parent.context)
                .inflate(android.R.layout.simple_list_item_1, parent, false)
            return ViewHolder(view)
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            holder.name.text = list[position]
        }

        override fun getItemCount(): Int = list.size

    }
}