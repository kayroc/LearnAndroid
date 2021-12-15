package kayroc.android.learn.okhttp

import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import kayroc.android.learn.R
import kayroc.android.learn.utils.JsonUtils.formatDataFromJson
import okhttp3.*
import java.io.IOException
import java.util.concurrent.TimeUnit

/**
 * 官方文档：https://square.github.io/okhttp/
 * Github：https://github.com/square/okhttp
 * Android OkHttp完全解析：https://blog.csdn.net/lmj623565791/article/details/47911083
 * OkHttp使用教程：http://www.jcodecraeer.com/a/anzhuokaifa/androidkaifa/2015/0106/2275.html
 *
 *
 * 功　　能：高性能Http请求库，可把它理解成是一个封装之后的类似HttpUrlConnection的一个东西，属于同级并不是基于二者，支持SPDY，共享同一个Scoket来处理同一个服务器的所有请求，支持同步异步，无缝的支持GZIP来减少数据流量；
 * 性　　能：基于NIO和Okio，所以性能比较好，请求处理速度快（IO:阻塞式；NIO:非阻塞式；Okio是Square公司基于IO和NIO做的一个更简单、高效处理数据流的一个库）;
 * 应用场景：重量级网络交互场景，网络请求频繁、传输数据量大（当然更推荐Retrofit，反正Retrofit是基于Okhttp的）；
 * 使　　用：API调用简单方便，使用时需要进行多一层封装；
 *
 * @author kayroc
 */
class OkHttpActivity : AppCompatActivity() {
    private val mBtnGet: Button by lazy { findViewById<Button>(R.id.btn_get) }
    private val mBtnPost: Button by lazy { findViewById<Button>(R.id.btn_post) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_okhttp)

        // 发送get请求
        mBtnGet.setOnClickListener { doGetRequest() }

        // 发送post请求
        mBtnPost.setOnClickListener { doPostRequest() }
    }

    private fun doPostRequest() {
        val url = "https://postman-echo.com/post"
        // 创建OkHttpClient对象
        val client: OkHttpClient = OkHttpClient.Builder()
            .connectTimeout(10, TimeUnit.SECONDS)
            .writeTimeout(10, TimeUnit.SECONDS)
            .readTimeout(1, TimeUnit.SECONDS)
            .build()
        // 通过FormEncodingBuilder构建请求体，add方法添加对应的参数键值对
        // RequestBody requestBody = new FormEncodingBuilder()
        // okhttp3 中已找不到 FormEncodingBuilder，使用FormBody代替了
        val requestBody: FormBody = FormBody.Builder()
            .add("platform", "android")
            .add("SDK", "30")
            .build()
        // 通过Request.Builder去构建Request请求对象
        val request: Request = Request.Builder()
            .url(url)
            .post(requestBody)
            .build()
        // 通过Request对象和OkHttpClient去得到一个Call对象
        val call = client.newCall(request)

        // 同步执行网络请求
        // try {
        //     call.execute()
        // } catch (e: IOException) {
        //     e.printStackTrace()
        // }

        // 调用Call对象的异步方法去执行请求。调用call对象的enqueue方法
        call.enqueue(object : Callback {
            @Throws(IOException::class)
            override fun onResponse(call: Call, response: Response) {
                val responseBody = response.body
                if (responseBody != null) {
                    val str = responseBody.string()
                    Log.i("OkHttp", "post 请求成功：\n${Thread.currentThread().name}")
                    Log.i("OkHttp", "post 请求成功：\n${formatDataFromJson(str)}")
                }
            }

            override fun onFailure(call: Call, e: IOException) {
                Log.i("OkHttp", "post 请求失败：\n${Thread.currentThread().name}")
                Log.i("OkHttp", "post 请求失败：\n${e.message}")
            }
        })
    }

    /**
     * 使用步骤：
     * 1. 创建 OkHttpClient 对象
     * 2. 构造一个 Request 对象，传入相应的 url 和参数
     * 3. 通过 Request 对象和 OkHttpClient 去得到一个 Call 对象
     * 4. 通过 Call 对象的异步方法去执行请求
     * 5. 在 Call 对象对应方法的 CallBack 回调中去处理请求结果
     */
    private fun doGetRequest() {
        val url = "https://postman-echo.com/get?name=kayroc&password=123456"
        // 创建OkHttpClient对象
        val client = OkHttpClient()
        // 构造一个Request对象，传入相应的url和参数
        val request: Request = Request.Builder().url(url).build()
        // 通过Request对象和OkHttpClient去得到一个Call对象
        val call = client.newCall(request)

        // 同步执行网络请求
        // try {
        //     call.execute()
        // } catch (e: IOException) {
        //     e.printStackTrace()
        // }

        // 调用Call对象的异步方法去执行请求。调用call对象的enqueue方法
        call.enqueue(object : Callback {
            @Throws(IOException::class)
            override fun onResponse(call: Call, response: Response) {
                // 在Call对象对应方法的CallBack回调中去处理请求结果
                val body = response.body
                if (body != null) {
                    val str = body.string()
                    Log.i("OkHttp", "get 请求成功：\n${Thread.currentThread().name}")
                    Log.i("OkHttp", "get 请求成功：\n${formatDataFromJson(str)}")
                }
            }

            override fun onFailure(call: Call, e: IOException) {
                Log.i("OkHttp", "get 请求失败：\n${Thread.currentThread().name}")
                Log.i("OkHttp", "get 请求失败：\n${e.message}")
            }
        })
    }
}