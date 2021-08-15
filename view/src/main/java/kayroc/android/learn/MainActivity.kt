package kayroc.android.learn

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import kayroc.android.learn.layout.LayoutActivity
import kayroc.android.learn.view.ViewActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // View
        val mBtnView = findViewById<Button>(R.id.btn_view)
        mBtnView.setOnClickListener {
            startActivity(Intent(this, ViewActivity::class.java))
        }

        // ViewGroup
        val mBtnViewGroup = findViewById<Button>(R.id.btn_view_group)
        mBtnViewGroup.setOnClickListener {
            startActivity(Intent(this, LayoutActivity::class.java))
        }
    }
}