package kayroc.android.learn

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button

/**
 * <pre>
 * Activity 的生命周期
 * 1. 每个Activity在其生命周期中最多可能会有4种状态：
 *      运行状态：当 Activity 位于栈顶时(系统最不愿意回收)
 *      暂停状态：当 Activity 不再处于栈顶位置，但仍然可见时(系统也不愿意回收，影响用户体验)
 *      停止状态：当 Activity 不再处于栈顶位置，并且完全不可见时(系统会为其保存相应的状态和成员变量，但是当其他地方需要内存时，有可能会被系统回收)
 *      销毁状态：当 Activity 从返回栈中移除后就变成了销毁状态。系统会最倾向于回收处于这种状态的活动，从而保证手机的内存充足
 * 2. Activity 的生命周期：
 *      void onCreate() —— Activity 已经被创建完毕1.
 *      void onStart() —— Activity 已经显示在屏幕，但没有得到焦点
 *      void onResume() —— Activity 得到焦点，可以与用户交互
 *      void onPause() —— Activity 失去焦点，无法再与用户交互，但依然可见
 *      void onStop() —— Activity 不可见，进入后台
 *      void onDestroy() —— Activity 被销毁
 *      void onRestart() —— Activity 从不可见变成可见时会执行此方法
 *    完整生命周期：onCreate --> onStart --> onResume --> onPause --> onStop --> onDestroy
 *    可视生命周期：onStart --> onResume --> onPause --> onStop
 *    前台生命周期：onResume --> onPause
 * 3. 横竖屏切换的生命周期：销毁当前的activity，然后重新初始化activity
 *    解决横竖屏重走生命周期的方法：
 *      清单文件中配置：
 *          方式一：android:screenOrientation="portrait"
 *              固定activity的显示模式，这样就不会重走一次生命周期
 *              可选值：portrait(竖屏) | landspace(横屏)
 *          方式二：android:configChanges="keyboardHidden|screenSize|orientation"
 *              这样的话就算横竖屏切换了，不会影响activity，也就不会重走一次生命周期
 * </pre>
 *
 * @author kayroc
 */
class LifecycleActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lifecycle)
        Log.d("Activity 生命周期", "onCreate")

        // 开启一个普通的Activity
        val mBtnOpenNormal = findViewById<Button>(R.id.btn_open_normal)
        mBtnOpenNormal.setOnClickListener {
            startActivity(Intent(this, NormalActivity::class.java))
        }

        // 开启一个Dialog的Activity
        val mBtnOpenDialog = findViewById<Button>(R.id.btn_open_dialog)
        mBtnOpenDialog.setOnClickListener {
            startActivity(Intent(this, DialogActivity::class.java))
        }

    }

    override fun onStart() {
        super.onStart()
        Log.d("Activity 生命周期", "onCreate")
    }

    override fun onResume() {
        super.onResume()
        Log.d("Activity 生命周期", "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d("Activity 生命周期", "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d("Activity 生命周期", "onStop")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d("Activity 生命周期", "onRestart")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("Activity 生命周期", "onDestroy")
    }
}