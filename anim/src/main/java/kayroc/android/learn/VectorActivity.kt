package kayroc.android.learn

import android.graphics.drawable.AnimatedVectorDrawable
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.vectordrawable.graphics.drawable.Animatable2Compat
import androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat

/**
 * avd_endless_pin_jump 资源来源：https://gist.github.com/nickbutcher/b1806905c6bc0ef29f545fd580935bd3
 *
 * @author kayroc
 */
class VectorActivity : AppCompatActivity() {
    private val mIvLocation: ImageView by lazy { findViewById<ImageView>(R.id.iv_location) }
    private val mView: View by lazy { findViewById<View>(R.id.view) }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_vector)

        // 图钉跳跃效果
        val avd = AnimatedVectorDrawableCompat.create(this, R.drawable.avd_endless_pin_jump)
        mIvLocation.apply {
            setImageDrawable(avd)
        }
        avd?.registerAnimationCallback(object : Animatable2Compat.AnimationCallback() {
            override fun onAnimationEnd(drawable: Drawable?) {
                mIvLocation.post { avd.start() }
            }
        })
        avd?.start()

        mView.setOnClickListener {
            (mView.background as AnimatedVectorDrawable).start()
        }
    }
}