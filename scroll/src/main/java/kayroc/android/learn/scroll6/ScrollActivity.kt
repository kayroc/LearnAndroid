package kayroc.android.learn.scroll6

import android.animation.ObjectAnimator
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kayroc.android.learn.R


/**
 * @author kayroc
 */
class ScrollActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scroll6)

        val mView = findViewById<View>(R.id.view)
        mView.setOnClickListener{
            // val ta = TranslateAnimation(0f, 200f, 0f, 300f)
            // ta.duration = 1000
            // ta.fillAfter = true
            // mView.startAnimation(ta)

            val objectAnimator: ObjectAnimator = ObjectAnimator.ofFloat(mView, "translationX", 300f)
            objectAnimator.setDuration(2000).start()

        }
    }
}