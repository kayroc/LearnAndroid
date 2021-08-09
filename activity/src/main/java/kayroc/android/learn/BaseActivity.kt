package kayroc.android.learn

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity

/**
 * 创建BaseActivity,知晓当前是在哪个Activity
 * @author kayroc
 */
open class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // kotlin 中，javaClass 表示获取当前实例的Class对象，相当于在Java中调用 getClass()方法
        // Kotlin 中，BaseActivity::class.java表示获取BaseActivity类的 Class对象，相当于在Java中调用BaseActivity.class
        Log.d("BaseActivity", javaClass.simpleName)
        ActivityCollector.addActivity(this)
    }

    override fun onDestroy() {
        super.onDestroy()
        ActivityCollector.removeActivity(this)
    }
}