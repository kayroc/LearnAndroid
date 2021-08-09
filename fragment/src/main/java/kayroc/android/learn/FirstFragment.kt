package kayroc.android.learn

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment

/**
 * @author kayroc
 */
class FirstFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_first, container, false)

        val mTvValue = view.findViewById<TextView>(R.id.tv_value)
        val mBtnPassValue = view.findViewById<Button>(R.id.btn_pass_value)

        mBtnPassValue.setOnClickListener {
            (activity as MainActivity).setSecondFragmentValue("Hi SecondFragment")
        }

        return view
    }

    fun refreshUI(text: String) {
        view!!.findViewById<TextView>(R.id.tv_value).text = text
    }
}