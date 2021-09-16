package kayroc.android.learn

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import kayroc.android.learn.entity.MenuEntity
import kayroc.android.learn.ui.activity.CanvasActivity
import kayroc.android.learn.ui.adapter.TitleAdapter

class MainActivity : AppCompatActivity() {

    private val mRecyclerView: RecyclerView by lazy { findViewById<RecyclerView>(R.id.recycler_view) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val data = arrayListOf(
            MenuEntity("Canvas 的使用", CanvasActivity::class.java)
        )

        val titleAdapter = TitleAdapter(data)
        titleAdapter.setOnItemClickListener(object : TitleAdapter.OnItemClickListener {
            override fun onItemClick(view: View, position: Int) {
                val item = titleAdapter.getItem(position)
                startActivity(Intent(this@MainActivity, item.goClass))
            }
        })
        mRecyclerView.adapter = titleAdapter
    }

}