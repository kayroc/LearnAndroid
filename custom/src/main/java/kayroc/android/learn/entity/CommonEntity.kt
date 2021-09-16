package kayroc.android.learn.entity

import androidx.fragment.app.Fragment


/**
 * @author kayroc
 */


class MenuEntity(var title: String, var goClass: Class<*>)

class PagerEntity(var fragment: Fragment, var title: String)