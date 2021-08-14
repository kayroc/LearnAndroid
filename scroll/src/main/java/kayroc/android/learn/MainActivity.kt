package kayroc.android.learn

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import kayroc.android.learn.scroll1.ScrollActivity as Scroll1Activity
import kayroc.android.learn.scroll2.ScrollActivity as Scroll2Activity
import kayroc.android.learn.scroll3.ScrollActivity as Scroll3Activity
import kayroc.android.learn.scroll4.ScrollActivity as Scroll4Activity
import kayroc.android.learn.scroll5.ScrollActivity as Scroll5Activity
import kayroc.android.learn.scroll6.ScrollActivity as Scroll6Activity
import kayroc.android.learn.scroll7.ScrollActivity as Scroll7Activity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 滑动方式一：layout
        val mBtn1 = findViewById<Button>(R.id.btn1)
        mBtn1.setOnClickListener {
            startActivity(Intent(this, Scroll1Activity::class.java))
        }

        // 滑动方式二：offsetLeftAndRight() 和 offsetTopAndBottom()
        val mBtn2 = findViewById<Button>(R.id.btn2)
        mBtn2.setOnClickListener {
            startActivity(Intent(this, Scroll2Activity::class.java))
        }

        // 滑动方式三：LayoutParams
        val mBtn3 = findViewById<Button>(R.id.btn3)
        mBtn3.setOnClickListener {
            startActivity(Intent(this, Scroll3Activity::class.java))
        }

        // 滑动方式四：scrollTo与scrollBy
        val mBtn4 = findViewById<Button>(R.id.btn4)
        mBtn4.setOnClickListener {
            startActivity(Intent(this, Scroll4Activity::class.java))
        }

        // 滑动方式五：Scroller
        val mBtn5 = findViewById<Button>(R.id.btn5)
        mBtn5.setOnClickListener {
            startActivity(Intent(this, Scroll5Activity::class.java))
        }

        // 滑动方式六：属性动画
        val mBtn6 = findViewById<Button>(R.id.btn6)
        mBtn6.setOnClickListener {
            startActivity(Intent(this, Scroll6Activity::class.java))
        }

        // 滑动方式七：ViewDragHelper
        val mBtn7 = findViewById<Button>(R.id.btn7)
        mBtn7.setOnClickListener {
            startActivity(Intent(this, Scroll7Activity::class.java))
        }
    }
}