package kayroc.android.learn.base

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import kayroc.android.learn.R
import kayroc.android.learn.ui.adapter.FragmentPagerAdapter


/**
 * @author kayroc
 */
abstract class TabPagerActivity : BaseActivity() {
    private val mTabLayout: TabLayout by lazy { findViewById<TabLayout>(R.id.tabLayout) }
    private val mViewPager: ViewPager by lazy { findViewById<ViewPager>(R.id.viewPager) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tab_pager)

        val pagerAdapter = FragmentPagerAdapter<Fragment>(this)
        initPagerData(pagerAdapter)
        mViewPager.adapter = pagerAdapter
        mTabLayout.setupWithViewPager(mViewPager)
    }

    /**
     * 使用 adapter.addFragment 添加数据
     * @param adapter PagerAdapter
     */
    abstract fun initPagerData(adapter: FragmentPagerAdapter<Fragment>)
}