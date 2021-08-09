package kayroc.android.learn

import android.content.Intent
import android.os.Bundle
import android.widget.Button

/**
 * <pre>
 * Activity 的启动模式：
 *      standard：标准的启动模式
 *          特点：1.Activity的默认启动模式
 *               2.每启动一个Activity就会在栈顶创建一个新的实例。例如：闹钟程序
 *          缺点：当Activity已经位于栈顶时，而再次启动Activity时还需要在创建一个新的实例，不能直接复用。
 *      singleTop：单一顶部模式
 *          特点：该模式会判断要启动的Activity实例是否位于栈顶，如果位于栈顶直接复用，否则创建新的实例。 例如：浏览器的书签
 *          缺点：如果Activity并未处于栈顶位置，则可能还会创建多个实例。
 *          应用场景：浏览器的书签
 *      singleTask：单一任务栈
 *          特点：使Activity在整个应用程序中只有一个实例。每次启动Activity时系统首先检查栈中是否存在当前Activity实例，
 *               如果存在则直接复用，并把当前Activity之上所有实例全部出栈。
 *          应用场景：浏览器主界面
 *      singleInstance：单一实例．
 *          特点：该模式的Activity会启动一个新的任务栈来管理Activity实例，并且该实例在整个系统中只有一个
 *               无论从那个任务栈中启动该Activity，都会是该Activity所在的任务栈转移到前台，从而使Activity显示。主要作用是为了在不同程序中共享一个Activity实例。
 *          应用场景：通话界面
 * </pre>
 * @author kayroc
 */
class LaunchModeActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_launch_mode)

        // 重新打开此页面
        val mBtnReopen = findViewById<Button>(R.id.btn_reopen)
        mBtnReopen.setOnClickListener {
            startActivity(Intent(this, LaunchModeActivity::class.java))
        }
    }
}