package kayroc.android.learn

import android.os.Bundle
import android.util.Log

/**
 * @author kayroc
 */
class NormalActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_normal)

        if (savedInstanceState != null) {
            val tempData = savedInstanceState.getString("data_key")
            Log.d("Activity 被回收了怎么办？", "取出销毁前保存的数据：$tempData")
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        val tempData = "在销毁前保存了大量数据"
        outState.putString("data_key", tempData)
        Log.d("Activity 被回收了怎么办？", "在销毁前保存了大量数据：$tempData")
    }
}