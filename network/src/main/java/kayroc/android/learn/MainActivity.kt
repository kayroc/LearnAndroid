package kayroc.android.learn

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import kayroc.android.learn.http.HttpClientActivity
import kayroc.android.learn.http.HttpURLConnectionActivity
import kayroc.android.learn.okhttp.OkHttpActivity
import kayroc.android.learn.volley.VolleyActivity

class MainActivity : AppCompatActivity() {

    private val mBtnHttpClient: Button by lazy { findViewById<Button>(R.id.btn_http_client) }
    private val mBtnHttpUrlConnection: Button by lazy { findViewById<Button>(R.id.btn_http_url_connection) }
    private val mBtnVolley: Button by lazy { findViewById<Button>(R.id.btn_volley) }
    private val mBtnOkHttp: Button by lazy { findViewById<Button>(R.id.btn_okhttp) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // HttpClient 的使用
        mBtnHttpClient.setOnClickListener {
            startActivity(Intent(this, HttpClientActivity::class.java))
        }

        // HttpURLConnection 的使用
        mBtnHttpUrlConnection.setOnClickListener {
            startActivity(Intent(this, HttpURLConnectionActivity::class.java))
        }

        // Volley 的使用
        mBtnVolley.setOnClickListener {
            startActivity(Intent(this, VolleyActivity::class.java))
        }

        // OkHttp 的使用
        mBtnOkHttp.setOnClickListener {
            startActivity(Intent(this, OkHttpActivity::class.java))
        }
    }
}