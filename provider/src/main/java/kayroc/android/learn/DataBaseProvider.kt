package kayroc.android.learn

import android.content.ContentProvider
import android.content.ContentValues
import android.content.UriMatcher
import android.net.Uri

/**
 * <pre>
 * 外部应用程序调用示例代码：
 *
 * 添加数据：
 *      val uri = Uri.parse("content://kayroc.android.learn.provider/book")
 *      val values = contentValuesOf(
 *          "name" to "A Clash of Kings",
 *          "author" to "George Martin",
 *          "pages" to 1040,
 *          "price" to 22.85
 *      )
 *      val newUri = contentResolver.insert(uri, values)
 *      bookId = newUri?.pathSegments?.get(1)
 * 删除数据：
 *      bookId?.let {
 *          val uri = Uri.parse("content://kayroc.android.learn/book/$it")
 *          contentResolver.delete(uri, null, null)
 *      }
 * 修改数据：
 *      bookId?.let {
 *          val uri = Uri.parse("content://kayroc.android.learn/book/$it")
 *          val values = contentValuesOf(
 *              "name" to "A Storm of Swords",
 *              "pages" to 1216,
 *              "price" to 24.05
 *          )
 *          contentResolver.update(uri, values, null, null)
 *      }
 * 查询数据：
 *      val uri = Uri.parse("content://kayroc.android.learn/book")
 *          contentResolver.query(uri, null, null, null, null)?.apply {
 *          while (moveToNext()) {
 *              val name = getString(getColumnIndex("name"))
 *              val author = getString(getColumnIndex("author"))
 *              val pages = getInt(getColumnIndex("pages"))
 *              val price = getDouble(getColumnIndex("price"))
 *              Log.d("MainActivity", "book name is $name")
 *              Log.d("MainActivity", "book author is $author")
 *              Log.d("MainActivity", "book pages is $pages")
 *              Log.d("MainActivity", "book price is $price")
 *          }
 *          close()
 *      }
 * </pre>
 */
class DataBaseProvider : ContentProvider() {

    private val bookDir = 0
    private val bookItem = 1
    private val categoryDir = 2
    private val categoryItem = 3
    private val authority = "kayroc.android.learn.provider"
    private var dbHelper: MyDatabaseHelper? = null

    // uri匹配器，用来匹配uri，其实就是判断uri末尾携带的路径是什么
    private val uriMatcher by lazy {
        // 添加匹配规则 *:表示匹配任意长度的任意字符。 #:表示匹配任意长度的数字。
        val matcher = UriMatcher(UriMatcher.NO_MATCH)
        // content://kayroc.android.learn.provider/book
        matcher.addURI(authority, "book", bookDir)
        // content://kayroc.android.learn.provider/book/#
        matcher.addURI(authority, "book/#", bookItem)
        // content://kayroc.android.learn.provider/category
        matcher.addURI(authority, "category", categoryDir)
        // content://kayroc.android.learn.provider/category/#
        matcher.addURI(authority, "category/#", categoryItem)
        matcher
    }

    override fun onCreate() = context?.let {
        dbHelper = MyDatabaseHelper(it, "BookStore.db", 2)
        true
    } ?: false

    /**
     * @param uri Uri 指定查询某个应用程序下的某一张表
     * @param projection Array<String>? 指定查询的列名
     * @param selection String? 指定where的约束条件
     * @param selectionArgs Array<String>? 为where中的占位符提供具体的值
     * @param sortOrder String? 指定查询结果的排序方式
     */
    override fun query(
        uri: Uri,
        projection: Array<String>?,
        selection: String?,
        selectionArgs: Array<String>?,
        sortOrder: String?
    ) = dbHelper?.let {
        // 查询数据
        val db = it.readableDatabase
        val cursor = when (uriMatcher.match(uri)) {
            bookDir -> db.query("Book", projection, selection, selectionArgs, null, null, sortOrder)
            bookItem -> {
                val bookId = uri.pathSegments[1]
                db.query("Book", projection, "id = ?", arrayOf(bookId), null, null, sortOrder)
            }
            categoryDir -> db.query("Category", projection, selection, selectionArgs, null, null, sortOrder)
            categoryItem -> {
                val categoryId = uri.pathSegments[1]
                db.query("Category", projection, "id = ?", arrayOf(categoryId), null, null, sortOrder)
            }
            else -> null
        }
        cursor
    }

    override fun insert(uri: Uri, values: ContentValues?) = dbHelper?.let {
        // 添加数据
        val db = it.writableDatabase
        val uriReturn = when (uriMatcher.match(uri)) {
            bookDir, bookItem -> {
                val newBookId = db.insert("Book", null, values)
                Uri.parse("content://$authority/book/$newBookId")
            }
            categoryDir, categoryItem -> {
                val newCategoryId = db.insert("Category", null, values)
                Uri.parse("content://$authority/category/$newCategoryId")
            }
            else -> null
        }
        uriReturn
    }

    override fun update(uri: Uri, values: ContentValues?, selection: String?, selectionArgs: Array<String>?) =
        dbHelper?.let {
            // 更新数据
            val db = it.writableDatabase
            val updatedRows = when (uriMatcher.match(uri)) {
                bookDir -> db.update("Book", values, selection, selectionArgs)
                bookItem -> {
                    val bookId = uri.pathSegments[1]
                    db.update("Book", values, "id = ?", arrayOf(bookId))
                }
                categoryDir -> db.update("Category", values, selection, selectionArgs)
                categoryItem -> {
                    val categoryId = uri.pathSegments[1]
                    db.update("Category", values, "id = ?", arrayOf(categoryId))
                }
                else -> 0
            }
            updatedRows
        } ?: 0

    override fun delete(uri: Uri, selection: String?, selectionArgs: Array<String>?) = dbHelper?.let {
        // 删除数据
        val db = it.writableDatabase
        val deletedRows = when (uriMatcher.match(uri)) {
            bookDir -> db.delete("Book", selection, selectionArgs)
            bookItem -> {
                val bookId = uri.pathSegments[1]
                db.delete("Book", "id = ?", arrayOf(bookId))
            }
            categoryDir -> db.delete("Category", selection, selectionArgs)
            categoryItem -> {
                val categoryId = uri.pathSegments[1]
                db.delete("Category", "id = ?", arrayOf(categoryId))
            }
            else -> 0
        }
        deletedRows
    } ?: 0

    /**
     * URI所对应的MIME字符串主要由3部分组成，Android对这3个部分做了如下格式规定：
     * 1. 必须以vnd开头
     * 2. 如果内容URI以 路径 结尾，则后接 android.cursor.dir/
     *    如果内容URI以 id 结尾，则后接 android.cursor.item/
     * 3. 最后接上vnd.<authority>.<path>
     *
     * authority：是用于对不同的应用程序做区分的，一般为了避免冲突，会采用应用包名的方式进行命名
     * path：则是用于对同一应用程序中不同的表做区分的
     */
    override fun getType(uri: Uri) = when (uriMatcher.match(uri)) {
        bookDir -> "vnd.android.cursor.dir/vnd.kayroc.android.learn.provider.book"
        bookItem -> "vnd.android.cursor.item/vnd.kayroc.android.learn.provider.book"
        categoryDir -> "vnd.android.cursor.dir/vnd.kayroc.android.learn.provider.category"
        categoryItem -> "vnd.android.cursor.item/vnd.kayroc.android.learn.provider.category"
        else -> null
    }
}