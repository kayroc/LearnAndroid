package kayroc.android.learn

import android.graphics.drawable.Drawable
import android.os.Bundle
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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_vector)

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
    }
}