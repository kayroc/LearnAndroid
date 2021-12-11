package kayroc.android.learn.http

import android.os.Bundle
import android.os.Handler
import android.os.HandlerThread
import android.text.TextUtils
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import kayroc.android.learn.R
import kayroc.android.learn.utils.JsonUtils
import org.apache.http.HttpVersion
import org.apache.http.NameValuePair
import org.apache.http.client.HttpClient
import org.apache.http.client.entity.UrlEncodedFormEntity
import org.apache.http.client.methods.HttpGet
import org.apache.http.client.methods.HttpPost
import org.apache.http.client.params.HttpClientParams
import org.apache.http.conn.ClientConnectionManager
import org.apache.http.conn.params.ConnManagerParams
import org.apache.http.conn.params.ConnPerRouteBean
import org.apache.http.conn.scheme.PlainSocketFactory
import org.apache.http.conn.scheme.Scheme
import org.apache.http.conn.scheme.SchemeRegistry
import org.apache.http.conn.ssl.SSLSocketFactory
import org.apache.http.impl.client.DefaultHttpClient
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager
import org.apache.http.message.BasicNameValuePair
import org.apache.http.params.BasicHttpParams
import org.apache.http.params.HttpConnectionParams
import org.apache.http.params.HttpParams
import org.apache.http.params.HttpProtocolParams
import org.apache.http.protocol.HTTP
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStream
import java.io.InputStreamReader
import java.util.*

/**
 * 取消支持 Apache HTTP：
 * https://developer.android.google.cn/about/versions/marshmallow/android-6.0-changes#behavior-apache-http-client
 * Apache HTTP 客户端弃用：
 * https://developer.android.google.cn/about/versions/pie/android-9.0-changes-28#apache-p
 *
 * @author kayroc
 */
@Deprecated("Android 6.0 移除了 HttpClient，改用 HttpURLConnection")
class HttpClientActivity : AppCompatActivity() {

    private val mBtnGet: Button by lazy { findViewById<Button>(R.id.btn_get) }
    private val mBtnPost: Button by lazy { findViewById<Button>(R.id.btn_post) }
    private var mHttpClientThread: HandlerThread = HandlerThread("HttpClientThread").apply {
        start()
    }
    private var mHandler: Handler = Handler(mHttpClientThread.looper)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_http_client)

        mBtnGet.setOnClickListener {
            mHandler.post { useHttpClientPost() }
        }
        mBtnPost.setOnClickListener {
            mHandler.post { useHttpClientGet() }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        mHttpClientThread.quit()
    }

    private fun useHttpClientPost() {
        //1. 创建 HttpClient 对象（DefaultHttpClient 为 HttpClient 的实现类）
        // HttpClient httpClient = new DefaultHttpClient();
        val httpClient = createHttpClient()
        //2. 创建请求对象（这里是 POST 请求），参数为请求地址（这里用的是 postman 提供的测试地址）
        val httpPost = HttpPost("https://postman-echo.com/post")
        try {
            //3. 调用 HttpPost 对象的 setEntity 方法设置需要的参数
            val postParams: MutableList<NameValuePair> = ArrayList()
            postParams.add(BasicNameValuePair("username", "kayroc"))
            postParams.add(BasicNameValuePair("password", "123456"))
            httpPost.entity = UrlEncodedFormEntity(postParams)

            //4.调用 HttpClient 对象的 execute 方法发送请求，返回 HttpResponse
            val httpResponse = httpClient.execute(httpPost)
            //5. 检查是否请求成功，状态码 200 表示成功
            if (httpResponse.statusLine.statusCode == 200) {
                //6. 调用 HttpEntity 对象的 getContent 方法获取响应数据的输入流
                val inputStream = httpResponse.entity.content
                //7. 将输入流转换成字符串
                val data = inputStream2String(inputStream)
                Log.i("HttpClient", "Post 请求结果:\n${JsonUtils.formatDataFromJson(data)}")
            }
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }

    private fun useHttpClientGet() {
        val url = "http://api.k780.com/?app=weather.today&weaId=1&appkey=10003&sign=b59bc3ef6191eb9f747dd4e83c99f2a4&format=json"
        //1. 创建 HttpClient 对象（DefaultHttpClient 为 HttpClient 的实现类）
        // HttpClient httpClient = new DefaultHttpClient();
        val httpClient = createHttpClient()
        //2. 创建请求对象（这里是 GET 请求），参数为请求地址
        val httpGet = HttpGet(url)
        try {
            //3.调用 HttpClient 对象的 execute 方法发送请求，返回 HttpResponse
            val httpResponse = httpClient.execute(httpGet)
            //4. 检查是否请求成功，状态码 200 表示成功
            if (httpResponse.statusLine.statusCode == 200) {
                //5. 调用 HttpEntity 对象的 getContent 方法获取响应数据的输入流
                val inputStream = httpResponse.entity.content
                //6. 将输入流转换成字符串
                val data = inputStream2String(inputStream)
                Log.i("HttpClient", "Get 请求结果:\n ${JsonUtils.formatDataFromJson(data)}")
            }
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }

    /**
     * 将输入流转换成字符串
     *
     * @param inputStream httpResponse 响应数据的输入流
     * @return
     */
    private fun inputStream2String(inputStream: InputStream): String {
        var data = ""
        var bufferedReader: BufferedReader? = null
        try {
            val inputStreamReader = InputStreamReader(inputStream)
            bufferedReader = BufferedReader(inputStreamReader)
            val stringBuilder = StringBuilder()
            var line: String? = null
            while (bufferedReader.readLine().also { line = it } != null) {
                stringBuilder.append(line).append("\n")
            }
            data = stringBuilder.toString()
            if (!TextUtils.isEmpty(data)) {
                //去除最后一个多余的换行符
                data = data.substring(0, data.length - 1)
            }
        } catch (e: IOException) {
            e.printStackTrace()
        } finally {
            try {
                bufferedReader?.close()
            } catch (e: IOException) {
                e.printStackTrace()
            }
        }
        return data
    }

    private fun createHttpClient(): HttpClient {
        val httpParams: HttpParams = BasicHttpParams()
        // 设置超时
        ConnManagerParams.setTimeout(httpParams, (5 * 1000).toLong())
        HttpConnectionParams.setConnectionTimeout(httpParams, 5 * 1000)
        HttpConnectionParams.setSoTimeout(httpParams, 5 * 1000)
        // 多线程最大连接数
        ConnManagerParams.setMaxConnectionsPerRoute(httpParams, ConnPerRouteBean(5))
        // 多线程总连接数
        ConnManagerParams.setMaxTotalConnections(httpParams, 10)
        // 设置异常处理机制
        HttpProtocolParams.setUseExpectContinue(httpParams, true)
        // 设置是否检查旧连接
        HttpConnectionParams.setStaleCheckingEnabled(httpParams, false)
        // 设置版本
        HttpProtocolParams.setVersion(httpParams, HttpVersion.HTTP_1_1)
        // 设置编码
        HttpProtocolParams.setContentCharset(httpParams, HTTP.UTF_8)
        // 设置重定向
        HttpClientParams.setRedirecting(httpParams, false)
        // 设置userAgent
        val userAgent = "Mozilla/5.0 (Windows; U; Windows NT 5.1; zh-CN; rv:1.9.2) Gecko/20100115 Firefox/3.6"
        HttpProtocolParams.setUserAgent(httpParams, userAgent)
        // 设置是否延迟发送
        HttpConnectionParams.setTcpNoDelay(httpParams, true)
        // 支持http与https
        val schemeRegistry = SchemeRegistry()
        schemeRegistry.register(Scheme("http", PlainSocketFactory.getSocketFactory(), 80))
        schemeRegistry.register(Scheme("https", SSLSocketFactory.getSocketFactory(), 443))
        //ThreadSafeClientConnManager线程安全管理类
        val manager: ClientConnectionManager = ThreadSafeClientConnManager(httpParams, schemeRegistry)
        // return new DefaultHttpClient(httpParams);
        return DefaultHttpClient(manager, httpParams)
    }
}