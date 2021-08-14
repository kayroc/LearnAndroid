package kayroc.android.learn

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import kayroc.android.learn.view.ListViewActivity
import kayroc.android.learn.view.RecyclerViewActivity
import kayroc.android.learn.view.ViewActivity
import kayroc.android.learn.viewgroup.LayoutActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // View
        val mBtnView = findViewById<Button>(R.id.btn_view)
        mBtnView.setOnClickListener {
            startActivity(Intent(this, ViewActivity::class.java))
        }

        // Layout
        val mBtnLayout = findViewById<Button>(R.id.btn_layout)
        mBtnLayout.setOnClickListener {
            startActivity(Intent(this, LayoutActivity::class.java))
        }

        // ListView
        val mBtnListView = findViewById<Button>(R.id.btn_list_view)
        mBtnListView.setOnClickListener {
            startActivity(Intent(this, ListViewActivity::class.java))
        }

        // RecyclerView
        val mBtnRecyclerView = findViewById<Button>(R.id.btn_recycler_view)
        mBtnRecyclerView.setOnClickListener {
            startActivity(Intent(this, RecyclerViewActivity::class.java))
        }
    }
}