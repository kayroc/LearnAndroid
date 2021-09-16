package kayroc.android.learn.ui.adapter

import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.viewpager.widget.ViewPager
import java.util.*

/**
 * @author kayroc
 */
class FragmentPagerAdapter<F : Fragment>(manager: FragmentManager) :
    androidx.fragment.app.FragmentPagerAdapter(manager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
    /** Fragment 集合 */
    private val mFragmentList: MutableList<F> = ArrayList()

    /** Fragment 标题  */
    private val mTitleList: MutableList<CharSequence?> = ArrayList()

    /** 当前显示的Fragment  */
    private var mShowFragment: F? = null

    /** 当前 ViewPager  */
    private var mViewPager: ViewPager? = null

    /** 设置成懒加载模式  */
    private var mLazyMode = true

    constructor(activity: FragmentActivity) : this(activity.supportFragmentManager) {}
    constructor(fragment: Fragment) : this(fragment.childFragmentManager) {}

    override fun getItem(position: Int): Fragment {
        return mFragmentList[position]
    }

    override fun getItemId(position: Int): Long {
        return getItem(position).hashCode().toLong()
    }

    override fun getCount(): Int {
        return mFragmentList.size
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return mTitleList[position]
    }

    @Suppress("UNCHECKED_CAST")
    override fun setPrimaryItem(container: ViewGroup, position: Int, `object`: Any) {
        super.setPrimaryItem(container, position, `object`)
        if (getShowFragment() !== `object`) {
            // 记录当前的Fragment对象
            mShowFragment = `object` as F
        }
    }

    /**
     * 添加 Fragment
     */
    @JvmOverloads
    fun addFragment(fragment: F, title: CharSequence? = null) {
        mFragmentList.add(fragment)
        mTitleList.add(title)
        if (mViewPager != null) {
            notifyDataSetChanged()
            if (mLazyMode) {
                mViewPager!!.offscreenPageLimit = count
            } else {
                mViewPager!!.offscreenPageLimit = 1
            }
        }
    }

    /**
     * 获取当前的Fragment
     */
    private fun getShowFragment(): F? {
        return mShowFragment
    }

    /**
     * 获取某个 Fragment 的索引（没有就返回 -1）
     */
    private fun getFragmentIndex(clazz: Class<out Fragment?>?): Int {
        if (clazz != null) {
            for (i in mFragmentList.indices) {
                if (clazz.name == mFragmentList[i].javaClass.name) {
                    return i
                }
            }
        }
        return -1
    }

    override fun startUpdate(container: ViewGroup) {
        super.startUpdate(container)
        if (container is ViewPager) {
            // 记录绑定 ViewPager
            mViewPager = container
            refreshLazyMode()
        }
    }

    /**
     * 设置懒加载模式
     */
    fun setLazyMode(lazy: Boolean) {
        mLazyMode = lazy
        refreshLazyMode()
    }

    /**
     * 刷新加载模式
     */
    private fun refreshLazyMode() {
        if (mViewPager == null) {
            return
        }
        if (mLazyMode) {
            // 设置成懒加载模式（也就是不限制 Fragment 展示的数量）
            mViewPager!!.offscreenPageLimit = count
        } else {
            mViewPager!!.offscreenPageLimit = 1
        }
    }
}