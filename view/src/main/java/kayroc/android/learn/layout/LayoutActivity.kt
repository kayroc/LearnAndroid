package kayroc.android.learn.layout

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import kayroc.android.learn.R

/**
 * ViewGroup 相关
 * @author kayroc
 */
class LayoutActivity : AppCompatActivity() {
    private val mBtnUseLinearLayout: Button by lazy { findViewById<Button>(R.id.btn_use_linear_layout) }
    private val mBtnUseRelativeLayout: Button by lazy { findViewById<Button>(R.id.btn_use_relative_layout) }
    private val mBtnUseFrameLayout: Button by lazy { findViewById<Button>(R.id.btn_use_frame_layout) }
    private val mBtnUseConstraintLayout: Button by lazy { findViewById<Button>(R.id.btn_use_constraint_layout) }
    private val mBtnUseScrollView: Button by lazy { findViewById<Button>(R.id.btn_use_scroll_view) }
    private val mBtnUseHorizontalScrollView: Button by lazy { findViewById<Button>(R.id.btn_use_horizontal_scroll_view) }
    private val mBtnUseRecyclerView: Button by lazy { findViewById<Button>(R.id.btn_use_recycler_view) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_layout)

        // LinearLayout 的使用
        mBtnUseLinearLayout.setOnClickListener {
            startActivity(Intent(this, LinearLayoutActivity::class.java))
        }

        // RelativeLayout 的使用
        mBtnUseRelativeLayout.setOnClickListener {
            startActivity(Intent(this, RelativeLayoutActivity::class.java))
        }

        // FrameLayout 的使用
        mBtnUseFrameLayout.setOnClickListener {
            startActivity(Intent(this, FrameLayoutActivity::class.java))
        }

        // ConstraintLayout 的使用
        mBtnUseConstraintLayout.setOnClickListener {
            startActivity(Intent(this, ConstraintLayoutActivity::class.java))
        }

        // ScrollView 的使用
        mBtnUseScrollView.setOnClickListener {
            startActivity(Intent(this, ScrollViewActivity::class.java))
        }

        // HorizontalScrollView 的使用
        mBtnUseHorizontalScrollView.setOnClickListener {
            startActivity(Intent(this, HorizontalScrollViewActivity::class.java))
        }

        // RecyclerView 的使用
        mBtnUseRecyclerView.setOnClickListener {
            startActivity(Intent(this, RecyclerViewActivity::class.java))
        }
    }
}