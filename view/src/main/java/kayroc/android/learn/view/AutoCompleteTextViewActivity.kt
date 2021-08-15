package kayroc.android.learn.view

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import androidx.appcompat.app.AppCompatActivity
import kayroc.android.learn.R


/**
 * AutoCompleteTextView 自动完成文本框视图的使用
 * API文档：https://developer.android.google.cn/reference/android/widget/AutoCompleteTextView
 * @author kayroc
 */
class AutoCompleteTextViewActivity : AppCompatActivity() {
    private val mAutoCompleteTextView: AutoCompleteTextView by lazy { findViewById<AutoCompleteTextView>(R.id.autoCompleteTextView) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auto_complete_text_view)

        val data = listOf("Android", "Ios", "Html", "Css", "JavaScript", "Python", "C", "C++",
            "Ruby", "Docker", "MySql", "Java", "Go", "Maven", "Vue.js", "Jquery", "Node.js", "Bootstrap",
            "Xml", "Json", "Svg", "Svn", "Git", "Kotlin", "Php").sorted()

        val arrayAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, data)
        mAutoCompleteTextView.setAdapter(arrayAdapter)
    }
}