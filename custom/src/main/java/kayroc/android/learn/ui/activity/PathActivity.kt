package kayroc.android.learn.ui.activity

import androidx.fragment.app.Fragment
import kayroc.android.learn.R
import kayroc.android.learn.base.TabPagerActivity
import kayroc.android.learn.ui.adapter.FragmentPagerAdapter
import kayroc.android.learn.ui.fragment.CustomViewFragment

/**
 * Path 的使用
 * @author kayroc
 */
class PathActivity : TabPagerActivity() {

    override fun initPagerData(adapter: FragmentPagerAdapter<Fragment>) {
        adapter.addFragment(CustomViewFragment.newInstance(R.layout.view_path_xxx_to), "xxxTo")
        adapter.addFragment(CustomViewFragment.newInstance(R.layout.view_path_r_xxx_to), "rXxxTo")
        adapter.addFragment(CustomViewFragment.newInstance(R.layout.view_path_add_xxx), "addXxx")
        adapter.addFragment(CustomViewFragment.newInstance(R.layout.view_path_set_last_point), "setLastPoint()")
        adapter.addFragment(CustomViewFragment.newInstance(R.layout.view_path_set_fill_type), "FillType 填充")
        adapter.addFragment(CustomViewFragment.newInstance(R.layout.view_path_op), "op 布尔操作")
        adapter.addFragment(CustomViewFragment.newInstance(R.layout.view_path_compute_bounds), "computeBounds 计算边界")
        adapter.addFragment(CustomViewFragment.newInstance(R.layout.view_path_offset), "offset 偏移")
    }

}