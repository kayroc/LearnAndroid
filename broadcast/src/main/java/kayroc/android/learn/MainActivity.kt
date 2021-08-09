package kayroc.android.learn

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 动态注册 - 监听系统时间变化的广播
        val mBtnTimeChange = findViewById<Button>(R.id.btn_time_change)
        mBtnTimeChange.setOnClickListener {
            startActivity(Intent(this, TimeChangeActivity::class.java))
        }

        // 静态注册 - 监听系统时间变化的广播
        // 在Android 8.0系统之后，所有隐式广播都不允许使用静态注册的方式来接收了
        // 隐式广播指的是那些没有具体指定发送给哪个应用程序的广播，大多数系统广播属于隐式广播
        // 但是少数特殊的系统广播目前仍然允许使用静态注册的方式来接收,特殊的系统广播列表详见:
        // https://developer.android.google.cn/guide/components/broadcast-exceptions.html

        // 自定义发送标准广播
        val mBtnStandardBroadcast = findViewById<Button>(R.id.btn_standard_broadcast)
        mBtnStandardBroadcast.setOnClickListener {
            val intent = Intent("kayroc.android.learn.STANDARD_BROADCAST")
            intent.setPackage(packageName)
            sendBroadcast(intent)
        }

        // 自定义发送有序广播
        val mBtnOrderlyBroadcast = findViewById<Button>(R.id.btn_orderly_broadcast)
        mBtnOrderlyBroadcast.setOnClickListener {
            val intent = Intent("kayroc.android.learn.ORDERLY_BROADCAST")
            intent.setPackage(packageName)
            sendOrderedBroadcast(intent, null)
        }

    }
}