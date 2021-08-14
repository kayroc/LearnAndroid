package kayroc.android.learn.view

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import kayroc.android.learn.R

/**
 * @author kayroc
 */
class ListViewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_view)

        val data = listOf("Android", "Ios", "Html", "Css", "JavaScript", "Python", "C", "C++",
            "Ruby", "Docker", "MySql", "Java", "Go", "Maven", "Vue.js", "Jquery", "Node.js", "Bootstrap",
            "Xml", "Json", "Svg", "Svn", "Git", "Kotlin").sorted()

        val mListView = findViewById<ListView>(R.id.list_view)
        val arrayAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, data)
        mListView.adapter = arrayAdapter
    }
}