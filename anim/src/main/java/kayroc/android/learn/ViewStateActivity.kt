package kayroc.android.learn

import android.animation.AnimatorInflater
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity


/**
 * @author kayroc
 */
class ViewStateActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_state)

        // 通过代码设置 stateListAnimator
        val stateListAnimator = AnimatorInflater.loadStateListAnimator(this, R.animator.view_state_translation_z)
        findViewById<View>(R.id.view2).stateListAnimator = stateListAnimator

    }
}