package kayroc.android.learn

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity

/**
 * @author kayroc
 */
class TimeChangeActivity : AppCompatActivity() {

    lateinit var timeChangeReceiver: TimeChangeReceiver

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_time_change)

        val intentFilter = IntentFilter()
        intentFilter.addAction("android.intent.action.TIME_TICK")
        timeChangeReceiver = TimeChangeReceiver()
        registerReceiver(timeChangeReceiver, intentFilter)
    }

    override fun onDestroy() {
        super.onDestroy()
        unregisterReceiver(timeChangeReceiver)
    }

    /**
     * 监听系统时间变化
     */
    inner class TimeChangeReceiver : BroadcastReceiver() {

        // 系统每隔 一分钟就会发出一条android.intent.action.TIME_TICK的广播
        override fun onReceive(context: Context, intent: Intent) {
            Log.d("监听系统时间变化", "时间改变了")
        }

    }
}