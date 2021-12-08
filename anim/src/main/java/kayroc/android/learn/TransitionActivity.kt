package kayroc.android.learn

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

/**
 * @author kayroc
 */
class TransitionActivity : AppCompatActivity() {

    private val mBtnOverrideStart: Button by lazy { findViewById<Button>(R.id.btn_override_start) }
    private val mBtnOverrideEnd: Button by lazy { findViewById<Button>(R.id.btn_override_end) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_transition)

        // overridePendingTransition 起动
        mBtnOverrideStart.setOnClickListener {
            startActivity(Intent(this, TransitionActivity::class.java))
            overridePendingTransition(R.anim.activity_right_in, R.anim.activity_right_out)
        }

        // overridePendingTransition 销毁
        mBtnOverrideEnd.setOnClickListener {
            finish()
            overridePendingTransition(R.anim.activity_left_in, R.anim.activity_left_out)
        }
    }
}