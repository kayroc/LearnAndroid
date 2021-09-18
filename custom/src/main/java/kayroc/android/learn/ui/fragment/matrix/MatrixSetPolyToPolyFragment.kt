package kayroc.android.learn.ui.fragment.matrix

import android.os.Bundle
import android.widget.RadioGroup
import kayroc.android.learn.R
import kayroc.android.learn.base.BaseFragment
import kayroc.android.learn.ui.view.matrix.MatrixSetPolyToPolyView


/**
 *
 * @author kayroc
 */
class MatrixSetPolyToPolyFragment : BaseFragment() {

    override fun getLayoutId(): Int {
        return R.layout.fragment_matrix_set_poly_to_poly
    }

    override fun initView(savedInstanceState: Bundle?) {
        val poly = findViewById<MatrixSetPolyToPolyView>(R.id.poly)

        val ratioGroup = findViewById<RadioGroup>(R.id.group)

        ratioGroup!!.setOnCheckedChangeListener { group, _ ->
            when (group.checkedRadioButtonId) {
                R.id.point0 -> poly?.setTestPoint(0)
                R.id.point1 -> poly?.setTestPoint(1)
                R.id.point2 -> poly?.setTestPoint(2)
                R.id.point3 -> poly?.setTestPoint(3)
                R.id.point4 -> poly?.setTestPoint(4)
            }
        }
    }
}