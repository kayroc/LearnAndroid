package kayroc.android.learn

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log

/**
 * @author kayroc
 */
class OrderlyBroadcast2 : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        Log.d("有序广播", "OrderlyBroadcast2 接收到了 优先级2")
        // 拦截广播，后面的BroadcastReceiver将不会再接收
        abortBroadcast()
        Log.d("有序广播", "OrderlyBroadcast2 拦截广播")
    }
}