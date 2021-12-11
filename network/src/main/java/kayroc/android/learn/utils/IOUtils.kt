package kayroc.android.learn.utils

import android.text.TextUtils
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStream
import java.io.InputStreamReader

/**
 * @author kayroc
 */
object IOUtils {

    /**
     * 将输入流转换成字符串
     *
     * @param inputStream httpResponse 响应数据的输入流
     * @return
     */
    @JvmStatic
    fun inputStream2String(inputStream: InputStream): String {
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
}