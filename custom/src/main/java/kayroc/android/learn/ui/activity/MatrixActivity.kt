package kayroc.android.learn.ui.activity

import androidx.fragment.app.Fragment
import kayroc.android.learn.R
import kayroc.android.learn.base.TabPagerActivity
import kayroc.android.learn.ui.adapter.FragmentPagerAdapter
import kayroc.android.learn.ui.fragment.CustomViewFragment
import kayroc.android.learn.ui.fragment.matrix.MatrixSetPolyToPolyFragment

/**
 * Matrix 的使用
 * @author kayroc
 */
class MatrixActivity : TabPagerActivity() {

    override fun initPagerData(adapter: FragmentPagerAdapter<Fragment>) {
        adapter.addFragment(CustomViewFragment.newInstance(R.layout.view_matrix_basic), "基础")
        adapter.addFragment(MatrixSetPolyToPolyFragment(), "setPolyToPoly()")
        adapter.addFragment(CustomViewFragment.newInstance(R.layout.view_matrix_set_rect_to_rect), "SetRectToRect()")
    }

}