package kayroc.android.learn

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log

/**
 * @author kayroc
 */
class StandardBroadcast2 : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        Log.d("标准广播", "StandardBroadcast2 接收到了")
    }
}