package kayroc.android.learn

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import kayroc.android.learn.file.FileActivity
import kayroc.android.learn.sp.SharedPreferencesActivity
import kayroc.android.learn.sql.SQLiteActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 文件存储
        val mBtnFile = findViewById<Button>(R.id.btn_file)
        mBtnFile.setOnClickListener {
            startActivity(Intent(this, FileActivity::class.java))
        }

        // SharePreferences 存储
        val mBtnSp = findViewById<Button>(R.id.btn_sp)
        mBtnSp.setOnClickListener {
            startActivity(Intent(this, SharedPreferencesActivity::class.java))
        }

        // SQLite 存储
        val mBtnSQL = findViewById<Button>(R.id.btn_sql)
        mBtnSQL.setOnClickListener {
            startActivity(Intent(this, SQLiteActivity::class.java))
        }
    }
}