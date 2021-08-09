package kayroc.android.learn.sql

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log

class MyDatabaseHelper(private val context: Context, name: String, version: Int) :
    // arg0:打开数据库的上下文
    // arg1:数据库文件的名字
    // arg2:游标工厂(Cursor就是ResultSet)
    // arg3:数据库版本，从1开始，传入更大的数字就会触发数据库的升级
    SQLiteOpenHelper(context, name, null, version) {

    private val createBook = "create table Book (" +
        " id integer primary key autoincrement," +
        "author text," +
        "price real," +
        "pages integer," +
        "name text," +
        "category_id integer)"

    private val createCategory = "create table Category (" +
        "id integer primary key autoincrement," +
        "category_name text," +
        "category_code integer)"

    // 创建数据库
    override fun onCreate(db: SQLiteDatabase) {
        Log.d("Sqlite 数据库", "创建成功")
        db.execSQL(createBook)
        db.execSQL(createCategory)
    }

    // 升级数据库
    // 最佳实践：
    // 1. onCreate()：增加新版本功能
    // 2. onUpgrade()：增加新版本逻辑判断
    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        if (oldVersion <= 1) {
            db.execSQL(createCategory)
        }
        if (oldVersion <= 2) {
            db.execSQL("alter table Book add column category_id integer")
        }
    }

}