package kayroc.android.learn

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import android.os.Bundle
import android.os.IBinder
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import kayroc.android.learn.service.MyIntentService
import kayroc.android.learn.service.MyService

class MainActivity : AppCompatActivity() {

    private val mBtnStart: Button by lazy { findViewById<Button>(R.id.btn_start) }
    private val mBtnStop: Button by lazy { findViewById<Button>(R.id.btn_stop) }
    private val mBtnBind: Button by lazy { findViewById<Button>(R.id.btn_bind) }
    private val mBtnUnbind: Button by lazy { findViewById<Button>(R.id.btn_unbind) }
    private val mBtnStartIntentService: Button by lazy { findViewById<Button>(R.id.btn_start_intent_service) }

    private lateinit var downloadBinder: MyService.DownloadBinder
    private val connection = object : ServiceConnection {

        // 当Activity与Service成功绑定的时候执行
        override fun onServiceConnected(name: ComponentName, service: IBinder) {
            downloadBinder = service as MyService.DownloadBinder
            downloadBinder.startDownload()
            downloadBinder.getProgress()
        }

        // 当Service的创建进程崩溃或者被杀掉的时候执行
        override fun onServiceDisconnected(name: ComponentName) {
            Log.d("MyService", "onServiceDisconnected")
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 启动服务
        mBtnStart.setOnClickListener {
            val intent = Intent(this, MyService::class.java)
            startService(intent)
        }

        // 停止服务
        mBtnStop.setOnClickListener {
            val intent = Intent(this, MyService::class.java)
            stopService(intent)
        }

        // 绑定服务
        mBtnBind.setOnClickListener {
            val intent = Intent(this, MyService::class.java)
            bindService(intent, connection, Context.BIND_AUTO_CREATE)
        }

        // 解绑服务
        mBtnUnbind.setOnClickListener {
            unbindService(connection)
        }

        // 启动 IntentService
        mBtnStartIntentService.setOnClickListener {
            // 打印主线程的id
            Log.d("MainActivity", "Thread id is ${Thread.currentThread().name}")
            val intent = Intent(this, MyIntentService::class.java)
            startService(intent)
        }
    }
}