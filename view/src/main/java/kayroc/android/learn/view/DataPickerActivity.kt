package kayroc.android.learn.view

import android.os.Bundle
import android.widget.DatePicker
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kayroc.android.learn.R
import java.util.*


/**
 * DataPicker 日期选择器的使用
 * API文档：https://developer.android.google.cn/reference/android/widget/DatePicker
 * @author kayroc
 */
class DataPickerActivity : AppCompatActivity() {
    private val mDataPicker: DatePicker by lazy { findViewById<DatePicker>(R.id.dataPicker) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_data_picker)

        val calendar: Calendar = Calendar.getInstance()
        val year: Int = calendar.get(Calendar.YEAR)
        val monthOfYear: Int = calendar.get(Calendar.MONTH)
        val dayOfMonth: Int = calendar.get(Calendar.DAY_OF_MONTH)
        mDataPicker.init(year, monthOfYear, dayOfMonth) { view, year, monthOfYear, dayOfMonth ->
            Toast.makeText(this, "您选择的日期是：${year}年${monthOfYear + 1}月${dayOfMonth}日!", Toast.LENGTH_SHORT)
                .show()
        }
    }
}