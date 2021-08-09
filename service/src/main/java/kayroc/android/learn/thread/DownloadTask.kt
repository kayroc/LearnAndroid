package kayroc.android.learn.thread

import android.os.AsyncTask

/**
 * Params：在执行AsyncTask时需要传入的参数，可用于在后台任务中使用
 * Progress：在后台任务执行时，如果需要在界面上显示当前的进度，则使用这里指定的泛型作为进度单位
 * Result：当任务执行完毕后，如果需要对结果进行返回，则使用这里指定的泛型作为返回值类型
 *
 * @author kayroc
 */
class DownloadTask : AsyncTask<Unit, Int, Boolean>() {

    // 后台任务开始执行之前调用,用于进行一些界面上的初始化操作
    override fun onPreExecute() {
        super.onPreExecute()
    }

    // 在子线程中运行,在这里去处理所有的耗时任务
    override fun doInBackground(vararg params: Unit?): Boolean {
        // 更新进度
        // publishProgress()
        return true
    }

    // 在后台任务中调用了publishProgress(Progress...)方法后
    // onProgressUpdate(Progress...) 方法就会很快被调用
    // 该方法中携带的参数就是在后台任务中传递过来的。在这个方法中可以对UI进行操作，
    override fun onProgressUpdate(vararg values: Int?) {
        super.onProgressUpdate(*values)
    }

    // 当后台任务执行完毕并通过return语句进行返回时，这个方法就很快会被调用
    // 返回的数据会作为参数传递到此方法中，可以利用返回的数据进行一些UI操作
    override fun onPostExecute(result: Boolean?) {
        super.onPostExecute(result)
    }
}