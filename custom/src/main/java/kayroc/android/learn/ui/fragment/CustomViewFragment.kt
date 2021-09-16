package kayroc.android.learn.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewStub
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import kayroc.android.learn.R

/**
 * @author kayroc
 */
class CustomViewFragment : Fragment() {

    private var layoutRes: Int = 0

    companion object {
        fun newInstance(@LayoutRes layoutRes: Int): CustomViewFragment{
            val args = Bundle()
            args.putInt("layoutRes", layoutRes);
            val fragment = CustomViewFragment()
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val args = arguments
        if (args != null) {
            layoutRes = args.getInt("layoutRes")
        }

        val view = inflater.inflate(R.layout.fragment_custom_view, container, false)

        val customViewStub = view.findViewById<ViewStub>(R.id.custom_view_stub)
        customViewStub.layoutResource = layoutRes
        customViewStub.inflate()

        return view
    }

}