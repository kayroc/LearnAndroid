package kayroc.android.learn.notification

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.graphics.BitmapFactory
import android.os.Build
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationCompat
import kayroc.android.learn.R

/**
 * @author kayroc
 */
class NotificationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notification)

        val manager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        // SDK 版本 >=  Android 8.0
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            // 通知不显示
            val noneChannel = NotificationChannel("none", "None", NotificationManager.IMPORTANCE_NONE)
            manager.createNotificationChannel(noneChannel)
            // 通知静音，状态栏没有小图标，显示一行
            val minChannel = NotificationChannel("min", "Min", NotificationManager.IMPORTANCE_MIN)
            manager.createNotificationChannel(minChannel)
            // 通知静音，状态栏显示小图标，能看到标题，内容
            val lowChannel = NotificationChannel("low", "Low", NotificationManager.IMPORTANCE_LOW)
            manager.createNotificationChannel(lowChannel)
            // 通知有声音，状态栏显示小图标，能看到标题，内容
            val defaultChannel = NotificationChannel("default", "Default", NotificationManager.IMPORTANCE_DEFAULT)
            manager.createNotificationChannel(defaultChannel)
            // 通知有声音，状态栏显示小图标，顶部弹窗显示，用户能立刻看到
            val highChannel = NotificationChannel("high", "High", NotificationManager.IMPORTANCE_HIGH)
            manager.createNotificationChannel(highChannel)
        }

        // 发送 IMPORTANCE_NONE 通知
        val mBtnSendNoticeNone = findViewById<Button>(R.id.btn_send_notice_none)
        mBtnSendNoticeNone.setOnClickListener {
            val intent = Intent(this, JumpActivity::class.java)
            /*
                参数1：上下文
                参数2：一般用不到，传 0 即可
                参数3：intent 对象，通过这个对象构建 PendIntent 的意图
                参数4：PendingIntent的行为 FLAG_ONE_SHOT｜FLAG_NO_CREATE｜FLAG_CANCEL_CURRENT｜FLAG_UPDATE_CURRENT
            */
            val pendingIntent = PendingIntent.getActivity(this, 0, intent, 0)
            val notification = NotificationCompat.Builder(this, "none")
                .setContentTitle("IMPORTANCE_NONE")
                .setContentText("Learn how to build notifications, send and sync data, and use voice actions. Get the official Android IDE and developer tools to build apps for Android.")
                // 设置长文本
                // .setStyle(NotificationCompat.BigTextStyle().bigText("Learn how to build notifications, send and sync data, and use voice actions. Get the official Android IDE and developer tools to build apps for Android."))
                // 设置显示大图片
                // .setStyle(NotificationCompat.BigPictureStyle().bigPicture(BitmapFactory.decodeResource(resources, R.drawable.big_image)))
                .setSmallIcon(R.drawable.small_icon)
                .setLargeIcon(BitmapFactory.decodeResource(resources, R.drawable.large_icon))
                .setContentIntent(pendingIntent)
                .setAutoCancel(true)
                .build()
            manager.notify(1, notification)
        }

        // 发送 IMPORTANCE_MIN 通知
        val mBtnSendNoticeMin = findViewById<Button>(R.id.btn_send_notice_min)
        mBtnSendNoticeMin.setOnClickListener {
            val intent = Intent(this, JumpActivity::class.java)
            /*
                参数1：上下文
                参数2：一般用不到，传 0 即可
                参数3：intent 对象，通过这个对象构建 PendIntent 的意图
                参数4：PendingIntent的行为 FLAG_ONE_SHOT｜FLAG_NO_CREATE｜FLAG_CANCEL_CURRENT｜FLAG_UPDATE_CURRENT
            */
            val pendingIntent = PendingIntent.getActivity(this, 0, intent, 0)
            val notification = NotificationCompat.Builder(this, "min")
                .setContentTitle("IMPORTANCE_MIN")
                .setContentText("Learn how to build notifications, send and sync data, and use voice actions. Get the official Android IDE and developer tools to build apps for Android.")
                // 设置长文本
                // .setStyle(NotificationCompat.BigTextStyle().bigText("Learn how to build notifications, send and sync data, and use voice actions. Get the official Android IDE and developer tools to build apps for Android."))
                // 设置显示大图片
                // .setStyle(NotificationCompat.BigPictureStyle().bigPicture(BitmapFactory.decodeResource(resources, R.drawable.big_image)))
                .setSmallIcon(R.drawable.small_icon)
                .setLargeIcon(BitmapFactory.decodeResource(resources, R.drawable.large_icon))
                .setContentIntent(pendingIntent)
                .setAutoCancel(true)
                .build()
            manager.notify(2, notification)
        }

        // 发送 IMPORTANCE_LOW 通知
        val mBtnSendNoticeLow = findViewById<Button>(R.id.btn_send_notice_low)
        mBtnSendNoticeLow.setOnClickListener {
            val intent = Intent(this, JumpActivity::class.java)
            /*
                参数1：上下文
                参数2：一般用不到，传 0 即可
                参数3：intent 对象，通过这个对象构建 PendIntent 的意图
                参数4：PendingIntent的行为 FLAG_ONE_SHOT｜FLAG_NO_CREATE｜FLAG_CANCEL_CURRENT｜FLAG_UPDATE_CURRENT
            */
            val pendingIntent = PendingIntent.getActivity(this, 0, intent, 0)
            val notification = NotificationCompat.Builder(this, "low")
                .setContentTitle("IMPORTANCE_LOW")
                .setContentText("Learn how to build notifications, send and sync data, and use voice actions. Get the official Android IDE and developer tools to build apps for Android.")
                // 设置长文本
                // .setStyle(NotificationCompat.BigTextStyle().bigText("Learn how to build notifications, send and sync data, and use voice actions. Get the official Android IDE and developer tools to build apps for Android."))
                // 设置显示大图片
                // .setStyle(NotificationCompat.BigPictureStyle().bigPicture(BitmapFactory.decodeResource(resources, R.drawable.big_image)))
                .setSmallIcon(R.drawable.small_icon)
                .setLargeIcon(BitmapFactory.decodeResource(resources, R.drawable.large_icon))
                .setContentIntent(pendingIntent)
                .setAutoCancel(true)
                .build()
            manager.notify(3, notification)
        }

        // 发送 IMPORTANCE_DEFAULT 通知
        val mBtnSendNoticeDefault = findViewById<Button>(R.id.btn_send_notice_default)
        mBtnSendNoticeDefault.setOnClickListener {
            val intent = Intent(this, JumpActivity::class.java)
            /*
                参数1：上下文
                参数2：一般用不到，传 0 即可
                参数3：intent 对象，通过这个对象构建 PendIntent 的意图
                参数4：PendingIntent的行为 FLAG_ONE_SHOT｜FLAG_NO_CREATE｜FLAG_CANCEL_CURRENT｜FLAG_UPDATE_CURRENT
            */
            val pendingIntent = PendingIntent.getActivity(this, 0, intent, 0)
            val notification = NotificationCompat.Builder(this, "default")
                .setContentTitle("IMPORTANCE_DEFAULT")
                .setContentText("Learn how to build notifications, send and sync data, and use voice actions. Get the official Android IDE and developer tools to build apps for Android.")
                // 设置长文本
                // .setStyle(NotificationCompat.BigTextStyle().bigText("Learn how to build notifications, send and sync data, and use voice actions. Get the official Android IDE and developer tools to build apps for Android."))
                // 设置显示大图片
                // .setStyle(NotificationCompat.BigPictureStyle().bigPicture(BitmapFactory.decodeResource(resources, R.drawable.big_image)))
                .setSmallIcon(R.drawable.small_icon)
                .setLargeIcon(BitmapFactory.decodeResource(resources, R.drawable.large_icon))
                .setContentIntent(pendingIntent)
                .setAutoCancel(true)
                .build()
            manager.notify(4, notification)
        }

        // 发送 IMPORTANCE_HIGH 通知
        val mBtnSendNoticeHigh = findViewById<Button>(R.id.btn_send_notice_high)
        mBtnSendNoticeHigh.setOnClickListener {
            val intent = Intent(this, JumpActivity::class.java)
            /*
                参数1：上下文
                参数2：一般用不到，传 0 即可
                参数3：intent 对象，通过这个对象构建 PendIntent 的意图
                参数4：PendingIntent的行为 FLAG_ONE_SHOT｜FLAG_NO_CREATE｜FLAG_CANCEL_CURRENT｜FLAG_UPDATE_CURRENT
            */
            val pendingIntent = PendingIntent.getActivity(this, 0, intent, 0)
            val notification = NotificationCompat.Builder(this, "high")
                .setContentTitle("IMPORTANCE_HIGH")
                .setContentText("Learn how to build notifications, send and sync data, and use voice actions. Get the official Android IDE and developer tools to build apps for Android.")
                // 设置长文本
                // .setStyle(NotificationCompat.BigTextStyle().bigText("Learn how to build notifications, send and sync data, and use voice actions. Get the official Android IDE and developer tools to build apps for Android."))
                // 设置显示大图片
                // .setStyle(NotificationCompat.BigPictureStyle().bigPicture(BitmapFactory.decodeResource(resources, R.drawable.big_image)))
                .setSmallIcon(R.drawable.small_icon)
                .setLargeIcon(BitmapFactory.decodeResource(resources, R.drawable.large_icon))
                .setContentIntent(pendingIntent)
                .setAutoCancel(true)
                .build()
            manager.notify(5, notification)
        }

    }
}