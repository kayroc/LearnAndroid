package kayroc.android.learn.retrofit

import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.*

/**
 * @author kayroc
 */
interface Api {
    /**
     * get请求
     *
     * 注解里传入 网络请求 的部分URL地址
     * Retrofit把网络请求的URL分成了两部分：一部分放在Retrofit对象里，另一部分放在网络请求接口里
     * 如果接口里的url是一个完整的网址，那么放在Retrofit对象里的URL可以忽略
     *
     * @return call对象
     */
    // @GET("/get?name=kayroc&password=123456")
    // Call<ResponseBody> get();
    @GET("/get?name=kayroc")
    operator fun get(@Query("password") password: String): Call<ResponseBody>

    /**
     * 采用 @Post 表示 Post 方法进行请求（传入部分url地址）
     * 采用 @FormUrlEncoded注解的原因:API规定采用请求格式x-www-form-urlencoded,即表单形式
     * 需要配合 @Field 向服务器提交需要的字段
     */
    @POST("/post")
    @FormUrlEncoded
    fun post(
        @Field("name") name: String,
        @Field("password") password: String
    ): Call<ResponseBody>
}