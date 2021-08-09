package kayroc.android.learn.service

import android.app.IntentService
import android.content.Intent
import android.util.Log

// 为了可以简单地创建一个异步的、会自动停止的Service，Android专门提供了一个 IntentService类
class MyIntentService : IntentService("MyIntentService") {

    // 处理一些耗时的逻辑，而不用担心ANR，在子线程中执行
    override fun onHandleIntent(intent: Intent?) {
        // 打印当前线程的id
        Log.d("MyIntentService", "Thread id is ${Thread.currentThread().name}")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("MyIntentService", "onDestroy executed")
    }

}