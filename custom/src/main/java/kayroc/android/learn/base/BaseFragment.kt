package kayroc.android.learn.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.IdRes
import androidx.fragment.app.Fragment

/**
 * @author kayroc
 */
abstract class BaseFragment : Fragment() {

    private var hasInitData = false
    private var hasInitView = false

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(getLayoutId(), container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if(!hasInitView){
            hasInitView = true
            initView(savedInstanceState)

        }
    }

    override fun onResume() {
        super.onResume()
        if(!hasInitData){
            hasInitData = true
            initData()
        }
    }

    protected abstract fun getLayoutId(): Int
    protected abstract fun initView(savedInstanceState: Bundle?)
    open fun initData(){}

    fun <T : View?> findViewById(@IdRes id: Int): T? {
        return view?.findViewById<T>(id)
    }
}