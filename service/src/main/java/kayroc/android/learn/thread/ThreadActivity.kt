package kayroc.android.learn.thread

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.os.Message
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import kotlin.concurrent.thread

/**
 * @author kayroc
 */
class ThreadActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        javaThread()
        androidThread()
    }

    /*
     * 异步消息处理的整个流程梳理：
     * 首先需要在主线程当中创建一个Handler对象，并重写 handleMessage()方法
     * 然后当子线程中需要进行UI操作时，就创建一个Message对象，并通过Handler将这条消息发送出去
     * 之后这条消息会被添加到MessageQueue的队列中等待被处理，而Looper则会一直尝试从MessageQueue中取出待处理消息
     * 最后分发回Handler的 handleMessage()方法中
     * 由于Handler的构造函数中我们传入了 Looper.getMainLooper()
     * 所以此时handleMessage()方法中的代码也会在主线程中运行，于是我们在这里就可以安心地进行UI操作了
     */
    private val mHandler = object : Handler(Looper.getMainLooper()) {
        override fun handleMessage(msg: Message) {
            // 在这里可以进行UI操作
            when (msg.what) {
                1 -> Log.d("", "更新UI")
            }
        }
    }

    private fun androidThread() {
        // Handler
        val msg = Message()
        msg.what = 1
        mHandler.sendMessage(msg)

        // AsyncTask
        DownloadTask().execute()
    }

    private fun javaThread() {
        // 方式一：继承 Thread 类
        class MyThread : Thread() {
            override fun run() {
                // 编写具体的逻辑 }
            }
        }
        MyThread().start()

        // 方式二：实现 Runnable 接口
        class MyRunnable : Runnable {
            override fun run() {
                // 编写具体的逻辑 }
            }
        }
        Thread(MyRunnable()).start()

        // 使用 Lambda 方式
        Thread {
            // 编写具体的逻辑
        }.start()

        // kotlin 简化写法，不需要 start()
        thread {

        }
    }
}