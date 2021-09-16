package kayroc.android.learn.ui.activity

import androidx.fragment.app.Fragment
import kayroc.android.learn.R
import kayroc.android.learn.base.TabPagerActivity
import kayroc.android.learn.ui.adapter.FragmentPagerAdapter
import kayroc.android.learn.ui.fragment.CustomViewFragment

/**
 * @author kayroc
 */
class CanvasActivity : TabPagerActivity() {

    override fun initPagerData(adapter: FragmentPagerAdapter<Fragment>) {
        adapter.addFragment(CustomViewFragment.newInstance(R.layout.view_canvas_draw_color), "drawColor()")
        adapter.addFragment(CustomViewFragment.newInstance(R.layout.view_canvas_draw_point), "drawPoint()")
        adapter.addFragment(CustomViewFragment.newInstance(R.layout.view_canvas_draw_line), "drawLine()")
        adapter.addFragment(CustomViewFragment.newInstance(R.layout.view_canvas_draw_rect), "drawRect()")
        adapter.addFragment(CustomViewFragment.newInstance(R.layout.view_canvas_draw_round_rect), "drawRoundRect()")
        adapter.addFragment(CustomViewFragment.newInstance(R.layout.view_canvas_draw_oval), "drawOval()")
        adapter.addFragment(CustomViewFragment.newInstance(R.layout.view_canvas_draw_circle), "drawCircle()")
        adapter.addFragment(CustomViewFragment.newInstance(R.layout.view_canvas_draw_arc), "drawArc()")
        adapter.addFragment(CustomViewFragment.newInstance(R.layout.view_canvas_draw_picture), "drawPicture()")
        adapter.addFragment(CustomViewFragment.newInstance(R.layout.view_canvas_draw_bitmap), "drawBitmap()")
        adapter.addFragment(CustomViewFragment.newInstance(R.layout.view_canvas_draw_text), "drawText()")
        adapter.addFragment(CustomViewFragment.newInstance(R.layout.view_canvas_clip_rect), "clipRect()")
        adapter.addFragment(CustomViewFragment.newInstance(R.layout.view_canvas_clip_path), "clipPath()")
        adapter.addFragment(CustomViewFragment.newInstance(R.layout.view_canvas_translate), "translate()")
        adapter.addFragment(CustomViewFragment.newInstance(R.layout.view_canvas_scale), "scale()")
        adapter.addFragment(CustomViewFragment.newInstance(R.layout.view_canvas_rotate), "rotate()")
        adapter.addFragment(CustomViewFragment.newInstance(R.layout.view_canvas_skew), "skew()")
        adapter.addFragment(CustomViewFragment.newInstance(R.layout.view_canvas_save_and_restore), "save()和restore()")
    }

}