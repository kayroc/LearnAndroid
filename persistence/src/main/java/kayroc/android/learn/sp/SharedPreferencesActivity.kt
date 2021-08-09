package kayroc.android.learn.sp

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.edit
import kayroc.android.learn.R

/**
 * @author kayroc
 */
class SharedPreferencesActivity : AppCompatActivity() {

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sp)

        // 存储
        val mBtnSave = findViewById<Button>(R.id.btn_save)
        mBtnSave.setOnClickListener {
            // 文件路径：/data/data/<package name>/shared_prefs/
            val editor = getSharedPreferences("data", Context.MODE_PRIVATE).edit()
            editor.putString("name", "Tom")
            editor.putInt("age", 28)
            editor.putBoolean("married", false)
            editor.apply()

            // 自定义简化 SharedPreferences
            getSharedPreferences("data", Context.MODE_PRIVATE).open {
                putString("name", "Tom")
                putInt("age", 28)
                putBoolean("married", false)
            }

            // Google ktx 提供的简化
            getSharedPreferences("data", Context.MODE_PRIVATE).edit {
                putString("name", "Tom")
                putInt("age", 28)
                putBoolean("married", false)
            }
        }

        // 读取
        val mBtnRead = findViewById<Button>(R.id.btn_read)
        mBtnRead.setOnClickListener {
            val prefs = getSharedPreferences("data", Context.MODE_PRIVATE)
            val name = prefs.getString("name", "")
            val age = prefs.getInt("age", 0)
            val married = prefs.getBoolean("married", false)
            Log.d("sp 存储", "name is $name")
            Log.d("sp 存储", "age is $age")
            Log.d("sp 存储", "married is $married")
        }
    }

}