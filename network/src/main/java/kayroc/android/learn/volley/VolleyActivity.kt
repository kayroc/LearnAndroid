package kayroc.android.learn.volley

import android.graphics.Bitmap
import android.os.Bundle
import android.util.Log
import android.util.LruCache
import android.view.View
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.AuthFailureError
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.*
import kayroc.android.learn.R
import kayroc.android.learn.utils.JsonUtils.formatDataFromJson


/**
 * 官方文档：https://developer.android.google.cn/training/volley/index.html
 * Google Source：https://android.googlesource.com/platform/frameworks/volley/
 * Github：https://github.com/google/volley
 * Volley源码解析：https://www.cnblogs.com/carlo/atticles/4972808.html
 *
 * 功　　能：基于HttpUrlConnection，封装了URL图片加载框架，支持图片加载，Activity和生命周期可以联动；
 * 性　　能：可扩展性好，可支持HttpClient、HttpUrlConnection和Okhttp;
 * 应用场景：适合轻量级网络交互，网络请求频繁，传输数据量小，不适合大数据的网络操作（比如下载视频、音频），所以不适合用来上传文件；
 * 使　　用：封装性好，简单易用；
 * 备　　注：Volley的Request和Response都是把数据方法放到byte[]数组里，不支持输入输出流
 *         把数据放到数组中，如果大文件多了，数组就会非常大且多消耗内存
 *         所以不如直接返回Stream那样具备可操作性,比如下载一个大文件，不可能把每个文件都缓存到内存之后再写到文件里
 *
 * @author kayroc
 */
class VolleyActivity : AppCompatActivity() {
    private val mBtnGet: Button by lazy { findViewById<Button>(R.id.btn_get) }
    private val mBtnPost: Button by lazy { findViewById<Button>(R.id.btn_post) }
    private val mBtnNetworkImage: Button by lazy { findViewById<Button>(R.id.btn_network_image) }
    private val mBtnImage: Button by lazy { findViewById<Button>(R.id.btn_image) }
    private val mIvImage: ImageView by lazy { findViewById<ImageView>(R.id.iv_image) }
    private val mIvNetworkImage: NetworkImageView by lazy { findViewById<NetworkImageView>(R.id.iv_network_image) }

    private lateinit var mRequestQueue: RequestQueue

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_volley)

        mRequestQueue = Volley.newRequestQueue(this)

        // 发送 Get 请求
        mBtnGet.setOnClickListener { doGetRequest() }

        // 发送 Post 请求
        mBtnPost.setOnClickListener { doPostRequest() }

        // NetworkImageView 加载图片
        mBtnNetworkImage.setOnClickListener {
            mIvImage.visibility = View.GONE
            mIvNetworkImage.visibility = View.VISIBLE
            doNetworkImageViewRequest()
        }

        // 内置 ImageLoader 加载图片
        mBtnImage.setOnClickListener {
            mIvImage.visibility = View.VISIBLE
            mIvNetworkImage.visibility = View.GONE
            doImageLoaderRequest()
        }
    }

    override fun onStop() {
        super.onStop()
        // 取消请求队列
        mRequestQueue.cancelAll("getRequest")
        mRequestQueue.cancelAll("postRequest")
    }

    private fun doImageLoaderRequest() {
        // 定义请求的url地址
        val url = "https://gitee.com/kayroc/CloudSpace/raw/pictures/20211212113228.png"
        // 创建缓存的对象，设置当前的缓存大小 1M
        val lruCache = LruCache<String, Bitmap>(1024 * 1024)
        // 创建图片缓存对象
        val imageCache: ImageLoader.ImageCache = object : ImageLoader.ImageCache {
            override fun getBitmap(url: String): Bitmap? {
                // 取得图片
                return lruCache[url]
            }

            override fun putBitmap(url: String, bitmap: Bitmap) {
                // 直接存放图片
                lruCache.put(url, bitmap)
            }
        }
        // 创建ImageLoader对象(参数1:请求队列，参数2:请求的图片缓存)
        val imageLoader = ImageLoader(mRequestQueue, imageCache)
        // 通过ImageLoader对象去得到ImageListener对象(内置imageListener)
        val imageListener = ImageLoader.getImageListener(mIvImage, R.mipmap.ic_launcher, R.mipmap.ic_launcher)
        // 通过ImageLoader对象去得到ImageListener对象(自定义imageListener)
        // val imageListener: ImageListener = object : ImageListener {
        //     override fun onResponse(response: ImageContainer, isImmediate: Boolean) {
        //         val bitmap = response.bitmap
        //         mIvImage.setImageBitmap(bitmap)
        //     }
        //
        //     override fun onErrorResponse(error: VolleyError) {}
        // }
        // 设置当前的Loader(参数1:请求的地址url,参数2:ImageLoader的监听ImageListener)
        imageLoader[url, imageListener]
    }

    private fun doNetworkImageViewRequest() {
        // 定义请求的url地址
        val url = "https://gitee.com/kayroc/CloudSpace/raw/pictures/20211212113446.png"
        // 创建缓存的对象，设置当前的缓存大小 1M
        val lruCache = LruCache<String, Bitmap>(1024 * 1024)
        // 创建图片缓存对象
        val imageCache: ImageLoader.ImageCache = object : ImageLoader.ImageCache {
            override fun getBitmap(url: String): Bitmap? {
                // 得到缓存
                return lruCache[url]
            }

            override fun putBitmap(url: String, bitmap: Bitmap) {
                // 放入到缓存
                lruCache.put(url, bitmap)
            }
        }
        // 创建ImageLoader对象
        val imageLoader = ImageLoader(mRequestQueue, imageCache)
        // 为NetworkImageView加载ImageUrl
        mIvNetworkImage.setImageUrl(url, imageLoader)
    }

    private fun doPostRequest() {
        // 定义请求的url地址
        val url = "https://postman-echo.com/post"
        // 定义请求(string请求)
        val stringRequest: StringRequest = object : StringRequest(
            Method.POST,
            url,
            Response.Listener { response -> // 如果请求失败，在控制台打印数据
                Log.i("Volley", "Post 请求成功：\n${formatDataFromJson(response!!)}")
            },
            Response.ErrorListener { error -> // 如果请求失败，在控制台打印失败信息
                Log.i("Volley", "Post 请求失败：\n$error")
            }) {
            // 重新方法，定义请求参数
            @Throws(AuthFailureError::class)
            override fun getParams(): Map<String, String>? {
                // 创建 HashMap 集合的对象
                val map = HashMap<String, String>()
                // 添加请求的数据
                map["username"] = "kayroc"
                map["password"] = "123456"
                // 返回当前的map集合
                return map
            }
        }
        // 设置当前的请求标志，标志是后面用于取消请求队列的
        stringRequest.tag = "postRequest"
        // 添加请求到请求队列中
        mRequestQueue.add(stringRequest)
    }

    private fun doGetRequest() {
        // 定义请求的url地址
        val url = "https://postman-echo.com/get?name=kayroc&password=123456"
        // 定义请求(json请求)
        val jsonObjectRequest = JsonObjectRequest(
            Request.Method.GET,
            url,
            null,
            { response -> // 如果请求成功，在控制台打印数据
                Log.i("Volley", "Get 请求成功：\n${formatDataFromJson(response.toString())}")
            }) { error -> // 如果请求失败，在控制台打印失败信息
            Log.i("Volley", "Get 请求失败：\n ${error.message}", error)
        }
        // 设置当前的请求标志，标志是后面用于取消请求队列的
        jsonObjectRequest.tag = "getRequest"
        // 添加请求到请求队列中
        mRequestQueue.add(jsonObjectRequest)
    }
}