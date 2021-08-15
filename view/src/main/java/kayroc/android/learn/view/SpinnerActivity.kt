package kayroc.android.learn.view

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity
import kayroc.android.learn.R

/**
 * Spinner 下拉列表的使用
 * 官方文档：https://developer.android.google.cn/guide/topics/ui/controls/spinner?hl=zh-cn
 * API文档：https://developer.android.google.cn/reference/android/widget/Spinner
 * @author kayroc
 */
class SpinnerActivity : AppCompatActivity() {

    private val mSpinner: Spinner by lazy { findViewById<Spinner>(R.id.spinner) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_spinner)

        val data = listOf("Android", "Ios", "Html", "Css", "JavaScript", "Python", "C", "C++",
            "Ruby", "Docker", "MySql", "Java", "Go", "Maven", "Vue.js", "Jquery", "Node.js", "Bootstrap",
            "Xml", "Json", "Svg", "Svn", "Git", "Kotlin", "Php").sorted()

        val arrayAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, data)
        mSpinner.adapter = arrayAdapter
    }
}