package kayroc.android.learn.service

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.app.Service
import android.content.Context
import android.content.Intent
import android.graphics.BitmapFactory
import android.os.Binder
import android.os.Build
import android.os.IBinder
import android.util.Log
import androidx.core.app.NotificationCompat
import kayroc.android.learn.MainActivity
import kayroc.android.learn.R
import kotlin.concurrent.thread

/**
 * <pre>
 *     Service 的正常情况下的生命周期：
 *     1. startService：onCreate-->onStartCommand-->onDestroy
 *          每启动一次，onStartCommand执行一次
 *     2. bindService：onCreate-->onBind-->onUnbind-->onDestroy
 * </pre>
 * @author kayroc
 */
class MyService : Service() {
    private val mBinder = DownloadBinder()

    class DownloadBinder : Binder() {

        // 开始下载
        fun startDownload() {
            Log.d("MyService", "startDownload executed")
        }

        // 获取下载进度
        fun getProgress(): Int {
            Log.d("MyService", "getProgress executed")
            return 0
        }

    }
    override fun onBind(intent: Intent?): IBinder? {
        return mBinder
    }

    // Service创建的时候执行
    override fun onCreate() {
        super.onCreate()
        Log.d("MyService", "onCreate executed")
        val manager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel("my_service", "前台Service通知", NotificationManager.IMPORTANCE_DEFAULT)
            manager.createNotificationChannel(channel)
        }
        val intent = Intent(this, MainActivity::class.java)
        val pi = PendingIntent.getActivity(this, 0, intent, 0)
        val notification = NotificationCompat.Builder(this, "my_service")
            .setContentTitle("This is content title")
            .setContentText("This is content text")
            .setSmallIcon(R.drawable.small_icon)
            .setLargeIcon(BitmapFactory.decodeResource(resources, R.drawable.large_icon))
            .setContentIntent(pi)
            .build()
        // 让MyService变成一个前 台Service，并在系统状态栏显示出来
        startForeground(1, notification)
    }

    // 每次Service启动的时候执行
    override fun onStartCommand(intent: Intent, flags: Int, startId: Int): Int {
        Log.d("MyService", "onStartCommand executed")
        thread {
            // 处理具体的逻辑

            // 自我停止运行
            stopSelf()
        }
        return super.onStartCommand(intent, flags, startId)
    }

    // 在Service销毁的时候执行
    override fun onDestroy() {
        super.onDestroy()
        Log.d("MyService", "onDestroy executed")
    }
}