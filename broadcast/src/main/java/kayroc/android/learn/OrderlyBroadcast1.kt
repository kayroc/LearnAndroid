package kayroc.android.learn

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log

/**
 * @author kayroc
 */
class OrderlyBroadcast1 : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        Log.d("有序广播", "OrderlyBroadcast1 接收到了 优先级1")
    }
}