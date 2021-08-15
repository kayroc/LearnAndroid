package kayroc.android.learn.view

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import kayroc.android.learn.R

/**
 * View 相关
 *
 * @author kayroc
 */
class ViewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view)

        // button 的使用
        val mBtnUseBtn = findViewById<Button>(R.id.btn_use_btn)
        mBtnUseBtn.setOnClickListener {
            startActivity(Intent(this, ButtonActivity::class.java))
        }

        // ImageButton 的使用
        val mBtnUseImageBtn = findViewById<Button>(R.id.btn_use_image_btn)
        mBtnUseImageBtn.setOnClickListener {
            startActivity(Intent(this, ImageButtonActivity::class.java))
        }

        // TextView 的使用
        val mBtnUseTextView = findViewById<Button>(R.id.btn_use_text_view)
        mBtnUseTextView.setOnClickListener {
            startActivity(Intent(this, TextViewActivity::class.java))
        }

        // EditText 的使用
        val mBtnUseEditText = findViewById<Button>(R.id.btn_use_edit_text)
        mBtnUseEditText.setOnClickListener {
            startActivity(Intent(this, EditTextActivity::class.java))
        }

        // ImageView 的使用
        val mBtnUseImageView = findViewById<Button>(R.id.btn_use_image_view)
        mBtnUseImageView.setOnClickListener {
            startActivity(Intent(this, ImageViewActivity::class.java))
        }

        // CheckBox 的使用
        val mBtnUseCheckBox = findViewById<Button>(R.id.btn_use_check_box)
        mBtnUseCheckBox.setOnClickListener {
            startActivity(Intent(this, CheckBoxActivity::class.java))
        }

        // RadioGroup & RadioButton 的使用
        val mBtnUseRadio = findViewById<Button>(R.id.btn_use_radio)
        mBtnUseRadio.setOnClickListener {
            startActivity(Intent(this, RadioActivity::class.java))
        }

        // Spinner 的使用
        val mBtnUseSpinner = findViewById<Button>(R.id.btn_use_spinner)
        mBtnUseSpinner.setOnClickListener {
            startActivity(Intent(this, SpinnerActivity::class.java))
        }

        // AutoCompleteTextView 的使用
        val mBtnUseAutoCompleteTextView = findViewById<Button>(R.id.btn_use_auto_complete_text_view)
        mBtnUseAutoCompleteTextView.setOnClickListener {
            startActivity(Intent(this, AutoCompleteTextViewActivity::class.java))
        }

        // DataPicker 的使用
        val mBtnUseDataPicker = findViewById<Button>(R.id.btn_use_data_picker)
        mBtnUseDataPicker.setOnClickListener {
            startActivity(Intent(this, DataPickerActivity::class.java))
        }

        // TimePicker 的使用
        val mBtnUseTimePicker = findViewById<Button>(R.id.btn_use_time_picker)
        mBtnUseTimePicker.setOnClickListener {
            startActivity(Intent(this, TimePickerActivity::class.java))
        }

        // ProgressBar 的使用
        val mBtnUseProgressBar = findViewById<Button>(R.id.btn_use_progress_bar)
        mBtnUseProgressBar.setOnClickListener {
            startActivity(Intent(this, ProgressBarActivity::class.java))
        }

        // RatingBar 的使用
        val mBtnUseRatingBar = findViewById<Button>(R.id.btn_use_rating_bar)
        mBtnUseRatingBar.setOnClickListener {
            startActivity(Intent(this, RatingBarActivity::class.java))
        }

        // SeekBar 的使用
        val mBtnUseSeekBar = findViewById<Button>(R.id.btn_use_seek_bar)
        mBtnUseSeekBar.setOnClickListener {
            startActivity(Intent(this, SeekBarActivity::class.java))
        }

        // ToggleButton 的使用
        val mBtnUseToggleButton = findViewById<Button>(R.id.btn_use_toggle_button)
        mBtnUseToggleButton.setOnClickListener {
            startActivity(Intent(this, ToggleButtonActivity::class.java))
        }

        // Switch 的使用
        val mBtnUseSwitch = findViewById<Button>(R.id.btn_use_switch)
        mBtnUseSwitch.setOnClickListener {
            startActivity(Intent(this, SwitchActivity::class.java))
        }

        // ListView 的使用
        val mBtnUseListView = findViewById<Button>(R.id.btn_use_list_view)
        mBtnUseListView.setOnClickListener {
            startActivity(Intent(this, ListViewActivity::class.java))
        }

        // GridView 的使用
        val mBtnUseGridView = findViewById<Button>(R.id.btn_use_grid_view)
        mBtnUseGridView.setOnClickListener {
            startActivity(Intent(this, GridViewActivity::class.java))
        }
    }
}