package kayroc.android.learn.retrofit

import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import kayroc.android.learn.R
import kayroc.android.learn.utils.JsonUtils.formatDataFromJson
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.IOException


/**
 * @author kayroc
 */
class RetrofitActivity : AppCompatActivity() {
    private val mBtnGet: Button by lazy { findViewById<Button>(R.id.btn_get) }
    private val mBtnPost: Button by lazy { findViewById<Button>(R.id.btn_post) }

    private val BASE_URL = "https://postman-echo.com"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_retrofit)

        mBtnGet.setOnClickListener { doGetRequest() }

        mBtnPost.setOnClickListener { doPostRequest() }
    }

    private fun doPostRequest() {
        // 创建Retrofit对象
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        // 创建网络请求接口的实例
        val api = retrofit.create(Api::class.java)
        // 对放松请求进行封装（设置需要翻译的内容）
        val call = api.post("kayroc", "123456")
        // 发送网络请求（异步）
        call.enqueue(object : Callback<ResponseBody?> {
            //请求成功时回调
            override fun onResponse(call: Call<ResponseBody?>, response: Response<ResponseBody?>) {
                val body = response.body()
                if (body != null) {
                    try {
                        val string = body.string()
                        Log.i("Retrofit", "post 请求成功：\n${Thread.currentThread().name}")
                        Log.i("Retrofit", "post 请求成功：\n${formatDataFromJson(string)}")
                    } catch (e: IOException) {
                        e.printStackTrace()
                    }
                }
            }

            //请求失败时回调
            override fun onFailure(call: Call<ResponseBody?>, throwable: Throwable) {
                Log.i("Retrofit", "post 异步请求失败：\n${Thread.currentThread().name}")
                Log.i("Retrofit", "post 异步请求失败：\n${throwable.message}")
            }
        })

        // // 发送网络请求（同步）
        // // 注意：在子线程中执行，否则会报错 android.os.NetworkOnMainThreadException
        // Thread {
        //     try {
        //         val response = call.execute()
        //         val body = response.body()
        //         if (body != null) {
        //             try {
        //                 val string = body.string()
        //                 Log.i("Retrofit", "post 请求成功：\n${Thread.currentThread().name}")
        //                 Log.i("Retrofit", "post 请求成功：\n${formatDataFromJson(string)}")
        //             } catch (e: IOException) {
        //                 e.printStackTrace()
        //             }
        //         }
        //     } catch (e: IOException) {
        //         e.printStackTrace()
        //         Log.i("Retrofit", "post 异步请求失败：${Thread.currentThread().name}")
        //         Log.i("Retrofit", "post 异步请求失败：${e.message}")
        //     }
        // }.start()
    }

    private fun doGetRequest() {
        // 创建Retrofit对象
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL) // 设置网络请求URL
            .addConverterFactory(GsonConverterFactory.create()) // 设置使用Gson解析(记得加入依赖)
            .build()
        // 创建网络接口的实例
        val api = retrofit.create(Api::class.java)
        // 对发送请求进行封装
        val call = api["1234567"]
        // 发送网络请求（异步）
        call.enqueue(object : Callback<ResponseBody?> {
            // 请求成功执行时回调
            override fun onResponse(call: Call<ResponseBody?>, response: Response<ResponseBody?>) {
                val body = response.body()
                if (body != null) {
                    try {
                        val string = body.string()
                        Log.i("Retrofit", "get 请求成功：\n${Thread.currentThread().name}")
                        Log.i("Retrofit", "get 请求成功：\n${formatDataFromJson(string)}")
                    } catch (e: IOException) {
                        e.printStackTrace()
                    }
                }
            }

            // 请求失败执行时回调
            override fun onFailure(call: Call<ResponseBody?>, throwable: Throwable) {
                Log.i("Retrofit", "get 请求失败：\n${Thread.currentThread().name}")
                Log.i("Retrofit", "get 请求失败：\n${throwable.message}")
            }
        })


        // // 发送网络请求（同步）
        // // 注意：在子线程中执行，否则会报错 android.os.NetworkOnMainThreadException
        // Thread {
        //     try {
        //         val response = call.execute()
        //         val body = response.body()
        //         if (body != null) {
        //             try {
        //                 val string = body.string()
        //                 Log.i("Retrofit", "get 请求成功：\n${Thread.currentThread().name}")
        //                 Log.i("Retrofit", "get 请求成功：\n${formatDataFromJson(string)}")
        //             } catch (e: IOException) {
        //                 e.printStackTrace()
        //             }
        //         }
        //     } catch (e: IOException) {
        //         e.printStackTrace()
        //         Log.i("Retrofit", "get 请求失败：\n${Thread.currentThread().name}")
        //         Log.i("Retrofit", "get 请求失败：\n${e.message}")
        //     }
        // }.start()
    }
}