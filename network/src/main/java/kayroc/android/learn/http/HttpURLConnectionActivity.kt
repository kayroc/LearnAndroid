package kayroc.android.learn.http

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kayroc.android.learn.R
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL
import kotlin.concurrent.thread

class HttpURLConnectionActivity : AppCompatActivity() {

    private val mBtnRequest: Button by lazy { findViewById<Button>(R.id.btn_request) }
    private val mTvResponse: TextView by lazy { findViewById<TextView>(R.id.tv_response) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_http_urlconnection)

        mBtnRequest.setOnClickListener {
            // 发送请求
            sendRequestWithHttpURLConnection()
        }
    }

    private fun sendRequestWithHttpURLConnection() {
        // 开启线程来发起网络请求
        thread {
            var connection: HttpURLConnection? = null
            try {
                val response = StringBuilder()
                val url = URL("https://www.baidu.com")
                connection = url.openConnection() as HttpURLConnection
                connection.connectTimeout = 8000
                connection.readTimeout = 8000

                // 提交数据时设置
                // connection.requestMethod = "POST"
                // val output = DataOutputStream(connection.outputStream)
                // output.writeBytes("username=admin&password=123456")

                val input = connection.inputStream
                // 下面对获取到的输入流进行读取
                val reader = BufferedReader(InputStreamReader(input))
                reader.use {
                    reader.forEachLine {
                        response.append(it)
                    }
                }
                showResponse(response.toString())
            } catch (e: Exception) {
                e.printStackTrace()
            } finally {
                connection?.disconnect()
            }
        }
    }

    private fun showResponse(response: String) {
        runOnUiThread {
            // 在这里进行UI操作，将结果显示到界面上
            mTvResponse.text = response
        }
    }
}