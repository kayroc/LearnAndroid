package kayroc.android.learn.ui.activity

import androidx.fragment.app.Fragment
import kayroc.android.learn.R
import kayroc.android.learn.base.TabPagerActivity
import kayroc.android.learn.ui.adapter.FragmentPagerAdapter
import kayroc.android.learn.ui.fragment.CustomViewFragment

/**
 * Paint 的使用
 * @author kayroc
 */
class PaintActivity : TabPagerActivity() {

    override fun initPagerData(adapter: FragmentPagerAdapter<Fragment>) {
        adapter.addFragment(CustomViewFragment.newInstance(R.layout.view_paint_basic), "基础")
        adapter.addFragment(CustomViewFragment.newInstance(R.layout.view_paint_set_antialias), "setAntiAlias (抗锯齿)")
        adapter.addFragment(CustomViewFragment.newInstance(R.layout.view_paint_set_style), "setStyle (填充模式)")
        adapter.addFragment(CustomViewFragment.newInstance(R.layout.view_paint_set_stroke_width), "setStrokeWidth (线条宽度)")
        adapter.addFragment(CustomViewFragment.newInstance(R.layout.view_paint_set_stroke_cap), "setStrokeCap (线条线帽)")
        adapter.addFragment(CustomViewFragment.newInstance(R.layout.view_paint_set_stroke_join), "setStrokeJoin (拐角类型)")
        adapter.addFragment(CustomViewFragment.newInstance(R.layout.view_paint_set_stroke_miter), "setStrokeMiter (斜接限制)")
        adapter.addFragment(CustomViewFragment.newInstance(R.layout.view_paint_set_dither), "setDither (图像抖动优化)")
        adapter.addFragment(CustomViewFragment.newInstance(R.layout.view_paint_set_filter_bitmap), "setFilterBitmap (双线性过滤优化)")
        adapter.addFragment(CustomViewFragment.newInstance(R.layout.view_paint_path_effect), "PathEffect (图形轮廓)")
        adapter.addFragment(CustomViewFragment.newInstance(R.layout.view_paint_set_shadow_layout), "setShadowLayer (阴影效果)")
        adapter.addFragment(CustomViewFragment.newInstance(R.layout.view_paint_set_mask_filter), "setMaskFilter (遮罩效果)")
        adapter.addFragment(CustomViewFragment.newInstance(R.layout.view_paint_get_fill_path), "getFillPath (实际Path)")
        adapter.addFragment(CustomViewFragment.newInstance(R.layout.view_paint_get_text_path), "getTextPath (实际Path)")
        adapter.addFragment(CustomViewFragment.newInstance(R.layout.view_paint_shader_linear_gradient), "setShader(LinearGradient) (着色器)")
        adapter.addFragment(CustomViewFragment.newInstance(R.layout.view_paint_shader_radial_gradient), "setShader(RadialGradient) (着色器)")
        adapter.addFragment(CustomViewFragment.newInstance(R.layout.view_paint_shader_sweep_gradient), "setShader(SweepGradient) (着色器)")
        adapter.addFragment(CustomViewFragment.newInstance(R.layout.view_paint_shader_bitmap), "setShader(BitmapShader) (着色器)")
        adapter.addFragment(CustomViewFragment.newInstance(R.layout.view_paint_shader_compose), "setShader(ComposeShader) (着色器)")
        adapter.addFragment(CustomViewFragment.newInstance(R.layout.view_paint_set_color_filter), "setColorFilter() (颜色过滤)")
        adapter.addFragment(CustomViewFragment.newInstance(R.layout.view_paint_set_x_fermode), "setXfermode() (Transfer mode)")
        adapter.addFragment(CustomViewFragment.newInstance(R.layout.view_paint_set_text_size), "setTextSize() (文字大小)")
        adapter.addFragment(CustomViewFragment.newInstance(R.layout.view_paint_set_typeface), "setTypeface() (文字字体)")
        adapter.addFragment(CustomViewFragment.newInstance(R.layout.view_paint_set_fake_bold_text), "setFakeBoldText() (文字伪粗体)")
        adapter.addFragment(CustomViewFragment.newInstance(R.layout.view_paint_set_strike_thru_text), "setStrikeThruText() (文字删除线)")
        adapter.addFragment(CustomViewFragment.newInstance(R.layout.view_paint_set_underline_text), "setUnderlineText() (文字下划线)")
        adapter.addFragment(CustomViewFragment.newInstance(R.layout.view_paint_set_text_skew_x), "setTextSkewX() (文字倾斜)")
        adapter.addFragment(CustomViewFragment.newInstance(R.layout.view_paint_set_text_scale_x), "setTextScaleX() (文字横向缩放)")
        adapter.addFragment(CustomViewFragment.newInstance(R.layout.view_paint_set_letter_spacing), "setLetterSpacing() (文字间距)")
        adapter.addFragment(CustomViewFragment.newInstance(R.layout.view_paint_set_text_align), "setTextAlign() (文字对齐方式)")
        adapter.addFragment(CustomViewFragment.newInstance(R.layout.view_paint_set_text_align), "setTextAlign() (文字对齐方式)")
    }

}