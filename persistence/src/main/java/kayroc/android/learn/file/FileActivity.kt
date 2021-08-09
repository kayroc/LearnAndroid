package kayroc.android.learn.file

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kayroc.android.learn.R
import java.io.*

/**
 * @author kayroc
 */
class FileActivity : AppCompatActivity() {

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_file)

        // 存储
        val mEtContent = findViewById<EditText>(R.id.et_content)
        val mBtnSave = findViewById<Button>(R.id.btn_save)
        mBtnSave.setOnClickListener {
            val data = mEtContent.text.toString()
            if (TextUtils.isEmpty(data)) {
                Toast.makeText(this, "请输入要存储的数据", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            save(data)
        }

        // 读取
        val mBtnRead = findViewById<Button>(R.id.btn_read)
        val mTvContent = findViewById<TextView>(R.id.tv_content)
        mBtnRead.setOnClickListener {
            mTvContent.text = "存储的内容是：${read()}"
        }
    }

    private fun save(inputText: String) {
        try {
            // 文件路径：data/data/<package name>/files/
            val output = openFileOutput("data", Context.MODE_PRIVATE)
            val writer = BufferedWriter(OutputStreamWriter(output))
            writer.use {
                it.write(inputText)
            }
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }

    private fun read(): String {
        val content = StringBuilder()
        try {
            val input = openFileInput("data")
            val reader = BufferedReader(InputStreamReader(input))
            reader.use {
                reader.forEachLine {
                    content.append(it)
                }
            }
        } catch (e: IOException) {
            e.printStackTrace()
        }
        return content.toString()
    }
}