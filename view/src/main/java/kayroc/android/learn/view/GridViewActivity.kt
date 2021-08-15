package kayroc.android.learn.view

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.GridView
import androidx.appcompat.app.AppCompatActivity
import kayroc.android.learn.R

/**
 * GridView 网格视图的使用
 * API文档：https://developer.android.google.cn/reference/android/widget/GridView
 * @author kayroc
 */
class GridViewActivity : AppCompatActivity() {
    private val mGridView: GridView by lazy { findViewById<GridView>(R.id.gridView) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_grid_view)

        val data = listOf("Android", "Ios", "Html", "Css", "JavaScript", "Python", "C", "C++",
            "Ruby", "Docker", "MySql", "Java", "Go", "Maven", "Vue.js", "Jquery", "Node.js", "Bootstrap",
            "Xml", "Json", "Svg", "Svn", "Git", "Kotlin", "Php").sorted()

        val arrayAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, data)
        mGridView.adapter = arrayAdapter
    }
}