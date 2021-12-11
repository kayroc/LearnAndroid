package kayroc.android.learn.utils

import org.json.JSONArray
import org.json.JSONObject

/**
 * @author kayroc
 */
object JsonUtils {
    /**
     * json 数据格式化输出
     *
     * @param response
     *
     * @return
     */
    @JvmStatic
    fun formatDataFromJson(response: String): String {
        try {
            if (response.startsWith("{")) {
                val jsonObject = JSONObject(response)
                return jsonObject.toString(4)
            } else if (response.startsWith("[")) {
                val jsonArray = JSONArray(response)
                return jsonArray.toString(4)
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return response
    }

}