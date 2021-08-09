package kayroc.android.learn

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

/**
 * layout-land：横屏是会寻找这个目录下的资源
 * @author kayroc
 */
class MainActivity : AppCompatActivity() {

    private val firstFragment: FirstFragment
        get() {
            return supportFragmentManager.findFragmentById(R.id.fragment_fist) as FirstFragment
        }

    private val secondFragment: SecondFragment = SecondFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 静态创建 Fragment
        val firstFragment = supportFragmentManager.findFragmentById(R.id.fragment_fist)
        val mBtnLifecycle = firstFragment!!.view?.findViewById<Button>(R.id.btn_lifecycle)
        mBtnLifecycle?.setOnClickListener {
            replaceFragment(ThirdFragment(), true)
        }

        // 动态创建 Fragment
        replaceFragment(secondFragment, false)

    }

    private fun replaceFragment(fragment: Fragment, addToBackStack: Boolean) {
        val fragmentManager = supportFragmentManager
        val transaction = fragmentManager.beginTransaction()
        transaction.replace(R.id.fragment_container, fragment)
        // 添加进返回栈中
        if (addToBackStack) {
            transaction.addToBackStack(null)
        }
        transaction.commit()
    }

    fun setFirstFragmentValue(text: String) {
        firstFragment.refreshUI(text)
    }

    fun setSecondFragmentValue(text: String) {
        secondFragment.refreshUI(text)
    }

}