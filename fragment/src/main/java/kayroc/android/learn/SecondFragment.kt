package kayroc.android.learn

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment

/**
 * <pre>
 * Fragment 生命周期：
 *      onAttach -- Fragment 第一次和它的 Activity 建立关联，此方法在 onCreate 之前调用
 *      onCreate -- Fragment 创建时调用，在 onAttach 方法之后，在 onCreateView 之前
 *      onCreateView -- 此方法是实例化 Fragment 的用户界面的。返回的 View 就是 Fragment 的显示内容
 *      onActivityCreated -- Fragment 的 Activity 创建了，并且 Fragment 的显示内容实例化完毕
 *      onStart -- 当 Fragment 可见时调用，与 Activity 的 onStart 绑定
 *      onResume -- 当 Fragment 对用户可见并且处于 Running 状态
 *      onPause -- 当 Fragment 不再处于 resume 状态
 *      onStop -- 当 Fragment 不再处于 started 状态
 *      onDestroyView -- 当 onCreateView 创建的试图与 fragment 解除关联时调用，下次 Fragment 要显示，需要重新创建 view
 *      onDestroy -- 当 fragment 不再有用时调用
 *      onDetach -- 当 Fragment 不再和它的 Activity 关联
 * </pre>
 * @author kayroc
 */
class SecondFragment : Fragment() {

    companion object {
        const val TAG = "Fragment 生命周期"
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.d(TAG, "onAttach")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "onCreate")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d(TAG, "onCreateView")
        val view = inflater.inflate(R.layout.fragment_second, container, false)

        val mTvNumber = view.findViewById<TextView>(R.id.tv_value)
        val mBtnPassValue = view.findViewById<Button>(R.id.btn_pass_value)

        mBtnPassValue.setOnClickListener {
            (activity as MainActivity).setFirstFragmentValue("Hi FirstFragment")
        }

        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        Log.d(TAG, "onActivityCreated")
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.d(TAG, "onDestroyView")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy")
    }

    override fun onDetach() {
        super.onDetach()
        Log.d(TAG, "onDetach")
    }

    fun refreshUI(text: String) {
        view!!.findViewById<TextView>(R.id.tv_value).text = text
    }
}