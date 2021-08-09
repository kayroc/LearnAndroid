package kayroc.android.learn

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button

class SecondActivity : BaseActivity() {

    companion object {
        fun actionStart(context: Context, data: String) {
            val intent = Intent(context, SecondActivity::class.java)
            intent.putExtra("extra_data", data)
            context.startActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        // 接收上个页面传递的值
        val extraData = intent.getStringExtra("extra_data")
        Log.d("Intent 传值", "extra data is $extraData")

        // Intent 回传数据
        val mBtnIntentPassValue = findViewById<Button>(R.id.btn_Intent_pass_value)
        mBtnIntentPassValue.setOnClickListener {
            val intent = Intent()
            intent.putExtra("data_return", "Hello FirstActivity")
            // 向上一个Activity返回数据
            setResult(RESULT_OK, intent)
            finish()
        }
    }

    // 重写返回键，防止回传失败
    override fun onBackPressed() {
        val intent = Intent()
        intent.putExtra("data_return", "Hello FirstActivity")
        // 向上一个Activity返回数据
        setResult(RESULT_OK, intent)
        finish()
    }
}