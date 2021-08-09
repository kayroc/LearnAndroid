package kayroc.android.learn

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 运行时权限
        val mBtnRuntimePermission = findViewById<Button>(R.id.btn_runtime_permission)
        mBtnRuntimePermission.setOnClickListener {
            startActivity(Intent(this, PermissionActivity::class.java))
        }

        // 读取联系人 - 访问其它程序中的数据
        val mBtnContacts = findViewById<Button>(R.id.btn_contacts)
        mBtnContacts.setOnClickListener {
            startActivity(Intent(this, ContactsActivity::class.java))
        }
    }
}