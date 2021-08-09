package kayroc.android.learn

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import kayroc.android.learn.http.HttpURLConnectionActivity

class MainActivity : AppCompatActivity() {

    private val mBtnHttpUrlConnection: Button by lazy { findViewById<Button>(R.id.btn_http_url_connection) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // HttpURLConnection 的使用
        mBtnHttpUrlConnection.setOnClickListener {
            startActivity(Intent(this, HttpURLConnectionActivity::class.java))
        }
    }
}