package kayroc.android.learn

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.Toast

class FirstActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first)

        // Log 的使用
        val mBtnUseLog = findViewById<Button>(R.id.btn_use_log)
        mBtnUseLog.setOnClickListener {
            Log.v("Log日志的使用", "Verbose：打印最为琐碎的、意义最小的日志信息。级别最低")
            Log.d("Log日志的使用", "Debug：打印调试信息")
            Log.i("Log日志的使用", "Info：打印比较重要的数据")
            Log.w("Log日志的使用", "Info：打印警告信息")
            Log.e("Log日志的使用", "Error：打印错误信息。级别相对较高")
        }

        // Toast 的使用
        val mBtnUseToast = findViewById<Button>(R.id.btn_use_toast)
        mBtnUseToast.setOnClickListener {
            Toast.makeText(this, "Toast 的使用", Toast.LENGTH_SHORT).show()
        }

        // 销毁一个Activity
        val mBtnFinish = findViewById<Button>(R.id.btn_finish)
        mBtnFinish.setOnClickListener {
            finish()
        }

        // 显式 Intent
        val mBtnVisibleIntent = findViewById<Button>(R.id.btn_visible_intent)
        mBtnVisibleIntent.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
        }

        // 显式 Intent 打开浏览器
        val mBtnVisibleIntentOpenBrowser = findViewById<Button>(R.id.btn_visible_intent_open_browser)
        mBtnVisibleIntentOpenBrowser.setOnClickListener {
            val intent = Intent()
            // com.android.chrome/com.google.android.apps.chrome.Main(API 30)
            intent.setClassName("com.android.chrome", "com.google.android.apps.chrome.Main")
            intent.data = Uri.parse("https://www.baidu.com")
            startActivity(intent)
        }

        // 显式 Intent 打开拨号
        val mBtnVisibleIntentDial = findViewById<Button>(R.id.btn_visible_intent_dial)
        mBtnVisibleIntentDial.setOnClickListener {
            val intent = Intent()
            // cmp=com.android.dialer/.main.impl.MainActivity(API 30)
            intent.setClassName("com.android.dialer", "com.android.dialer.main.impl.MainActivity")
            intent.data = Uri.parse("tel:10086")
            startActivity(intent)
        }

        // 隐式 Intent
        val mBtnInvisibleIntent = findViewById<Button>(R.id.btn_invisible_intent)
        mBtnInvisibleIntent.setOnClickListener {
            val intent = Intent().apply {
                // 每个 Intent 只能有一个 action
                action = "kayroc.android.learn.ACTION_TEST"
                // 可以有多个category
                addCategory("kayroc.android.learn.CATEGORY_TEST")
            }
            startActivity(intent)
        }

        // 隐式 Intent 打开浏览器访问百度
        val mBtnInvisibleIntentOpenBrowser = findViewById<Button>(R.id.btn_invisible_intent_open_browser)
        mBtnInvisibleIntentOpenBrowser.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse("https://www.baidu.com")
            startActivity(intent)
        }

        // 隐式 Intent 拨号
        val mBtnInvisibleIntentDial = findViewById<Button>(R.id.btn_invisible_intent_dial)
        mBtnInvisibleIntentDial.setOnClickListener {
            val intent = Intent(Intent.ACTION_DIAL)
            intent.data = Uri.parse("tel:10086")
            startActivity(intent)
        }

        // Intent 传值
        val mBtnIntentPassValue = findViewById<Button>(R.id.btn_Intent_pass_value)
        mBtnIntentPassValue.setOnClickListener {
            val data = "Hello SecondActivity"
            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtra("extra_data", data)

            // 使用 startActivity 开启页面，只会传值
            // startActivity(intent)

            // 使用 startActivityForResult 开启页面，会传值，并接收返回数据
            startActivityForResult(intent, 1)
        }

        // Activity 的生命周期
        val mBtnLifecycle = findViewById<Button>(R.id.btn_lifecycle)
        mBtnLifecycle.setOnClickListener {
            startActivity(Intent(this, LifecycleActivity::class.java))
        }

        // Activity 被回收了怎么办？
        val mBtnActivitySaveData = findViewById<Button>(R.id.btn_activity_save_data)
        mBtnActivitySaveData.setOnClickListener {
            startActivity(Intent(this, NormalActivity::class.java))
        }

        // Activity 的启动模式
        val mBtnLaunchMode = findViewById<Button>(R.id.btn_launch_mode)
        mBtnActivitySaveData.setOnClickListener {
            startActivity(Intent(this, LaunchModeActivity::class.java))
        }

        // 随时随地退出程序
        val mBtnExitApp = findViewById<Button>(R.id.btn_exit_app)
        mBtnExitApp.setOnClickListener {
            ActivityCollector.finishAll()
            // 杀掉当前进程的代码, 以保证程序完全退出
            android.os.Process.killProcess(android.os.Process.myPid())
        }

        // 启动 Activity 的最佳写法
        val mBtnStartActivity = findViewById<Button>(R.id.btn_start_activity)
        mBtnStartActivity.setOnClickListener {
            SecondActivity.actionStart(this, "Hello SecondActivity")
        }
    }

    // 创建菜单选项
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        // 加载菜单布局
        menuInflater.inflate(R.menu.menu_first_activity, menu)
        // 返回值 true：允许创建的菜单显示出来 false：创建的菜单将无法显示
        return super.onCreateOptionsMenu(menu)
    }

    // 菜单选项点击事件
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.menu_add -> Log.d("菜单的使用", "添加")
            R.id.menu_remove -> Log.d("菜单的使用", "删除")
        }
        return super.onOptionsItemSelected(item)
    }

    // 接收回传数据
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when (requestCode) {
            1 -> if (resultCode == RESULT_OK) {
                val returnedData = data?.getStringExtra("data_return")
                Log.d("Intent 传值", "returned data is $returnedData")
            }
        }
    }
}