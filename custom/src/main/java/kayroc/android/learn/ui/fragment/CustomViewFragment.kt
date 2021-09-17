package kayroc.android.learn.ui.fragment

import android.os.Bundle
import android.view.View
import android.view.ViewStub
import androidx.annotation.LayoutRes
import kayroc.android.learn.R
import kayroc.android.learn.base.BaseFragment

/**
 * @author kayroc
 */
class CustomViewFragment : BaseFragment() {

    companion object {
        fun newInstance(@LayoutRes layoutRes: Int): CustomViewFragment {
            val args = Bundle()
            args.putInt("layoutRes", layoutRes)
            val fragment = CustomViewFragment()
            fragment.arguments = args
            return fragment
        }
    }

    override fun getLayoutId(): Int {
        return R.layout.fragment_custom_view
    }

    override fun initView(view: View, savedInstanceState: Bundle?) {
        val customViewStub = view.findViewById<ViewStub>(R.id.custom_view_stub)
        customViewStub?.layoutResource = if (arguments == null) 0 else arguments!!.getInt("layoutRes")
        customViewStub?.inflate()
    }

}