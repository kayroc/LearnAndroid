package kayroc.android.learn.view

import android.os.Bundle
import android.widget.TimePicker
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kayroc.android.learn.R

/**
 * TimePicker 时间选择器的使用
 * API文档：https://developer.android.google.cn/reference/android/widget/TimePicker
 * @author kayroc
 */
class TimePickerActivity : AppCompatActivity() {
    private val mTimePicker: TimePicker by lazy { findViewById<TimePicker>(R.id.timePicker) }
    private val mTimePicker2: TimePicker by lazy { findViewById<TimePicker>(R.id.timePicker2) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_time_picker)

        mTimePicker2.setIs24HourView(false)
        mTimePicker.setOnTimeChangedListener { view, hourOfDay, minute ->
            Toast.makeText(this, "您选择的时间是：${hourOfDay}时${minute}分!",Toast.LENGTH_SHORT).show()
        }
    }
}