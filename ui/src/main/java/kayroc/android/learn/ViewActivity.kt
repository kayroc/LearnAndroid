package kayroc.android.learn

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

/**
 * 常用控件
 * @author kayroc
 */
class ViewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view)

        val mBtnAlertDialog = findViewById<Button>(R.id.btn_alert_dialog)
        mBtnAlertDialog.setOnClickListener {
            AlertDialog.Builder(this).apply {
                setTitle("This is Dialog")
                setMessage("Something important.")
                setCancelable(false)
                setPositiveButton("OK") { dialog, which ->
                }
                setNegativeButton("Cancel") { dialog, which ->
                }
                show()
            }
        }
    }
}