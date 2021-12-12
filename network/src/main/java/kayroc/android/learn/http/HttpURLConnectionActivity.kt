package kayroc.android.learn.http

import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import kayroc.android.learn.R
import kayroc.android.learn.utils.IOUtils.inputStream2String
import kayroc.android.learn.utils.JsonUtils.formatDataFromJson
import java.io.IOException
import java.net.HttpURLConnection
import java.net.URL
import java.net.URLEncoder

/**
 * 官方 API：https://developer.android.com/reference/java/net/HttpURLConnection
 *
 * @author kayroc
 */
class HttpURLConnectionActivity : AppCompatActivity() {

    private val mBtnGet: Button by lazy { findViewById<Button>(R.id.btn_get) }
    private val mBtnPost: Button by lazy { findViewById<Button>(R.id.btn_post) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_http_urlconnection)

        mBtnGet.setOnClickListener { doGetRequest() }

        mBtnPost.setOnClickListener { doPostRequest() }
    }

    private fun doPostRequest() {
        Thread {
            try {
                // 创建 URL 对象
                val url = URL("https://postman-echo.com/post")
                // 调用 URL 对象的 openConnection 方法获取 HttpURLConnection 实例
                val httpURLConnection = url.openConnection() as HttpURLConnection
                // 设置请求方法（这里是 POST 请求）
                httpURLConnection.requestMethod = "POST"
                // 设置连接超时时间
                httpURLConnection.connectTimeout = 15000
                // 设置读取超时时间
                httpURLConnection.readTimeout = 15000
                // 设置允许输入输出
                httpURLConnection.doInput = true
                httpURLConnection.doOutput = true
                // 设置请求参数
                val outputStream = httpURLConnection.outputStream
                val params = "username=" + URLEncoder.encode("kayroc", "UTF-8") +
                    "&password=" + URLEncoder.encode("123456", "UTF-8")
                outputStream.write(params.toByteArray())
                outputStream.flush()
                outputStream.close()

                // 连接
                httpURLConnection.connect()
                // 检查是否请求成功，状态码 200 表示成功
                if (httpURLConnection.responseCode == 200) {
                    // 调用 HttpURLConnection 对象的 getInputStream 方法获取响应数据的输入流
                    val inputStream = httpURLConnection.inputStream
                    // 将输入流转换成字符串
                    val data = inputStream2String(inputStream)
                    Log.i("HttpURLConnection", "Post 请求：" + formatDataFromJson(data))
                }
            } catch (e: IOException) {
                e.printStackTrace()
            }
        }.start()
    }

    private fun doGetRequest() {
        Thread {
            try {
                // 创建 URL 对象
                val url = URL("http://api.k780.com/?app=weather.today&weaId=1&appkey=10003&sign=b59bc3ef6191eb9f747dd4e83c99f2a4&format=json")
                // 调用 URL 对象的 openConnection 方法获取 HttpURLConnection 实例
                val httpURLConnection = url.openConnection() as HttpURLConnection
                // 设置请求方法（这里是 GET 请求）
                httpURLConnection.requestMethod = "GET"
                // 设置连接超时时间
                httpURLConnection.connectTimeout = 15000
                // 设置读取超时时间
                httpURLConnection.readTimeout = 15000
                // 连接
                httpURLConnection.connect()
                // 检查是否请求成功，状态码 200 表示成功
                if (httpURLConnection.responseCode == 200) {
                    // 调用 HttpURLConnection 对象的 getInputStream 方法获取响应数据的输入流
                    val inputStream = httpURLConnection.inputStream
                    // 将输入流转换成字符串
                    val data = inputStream2String(inputStream)
                    Log.i("HttpURLConnection", "Get 请求：\n$data")
                }
            } catch (e: IOException) {
                e.printStackTrace()
            }
        }.start()
    }
}