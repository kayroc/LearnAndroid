package kayroc.android.learn.sql

import android.annotation.SuppressLint
import android.content.ContentValues
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import kayroc.android.learn.R

/**
 * @author kayroc
 */
class SQLiteActivity : AppCompatActivity() {

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sql)

        // 文件路径：/data/data/<package name>/databases/
        val dbHelper = MyDatabaseHelper(this, "BookStore.db", 3)

        // 创建数据库
        val mBtnCreate = findViewById<Button>(R.id.btn_create)
        mBtnCreate.setOnClickListener {
            /*
             * getWritableDatabase 和 getReadableDatabase 的区别：
             * 相同点：
             *      1. 创建或打开一个现有的数据库
             *          如果数据库已存在则直接打开，否则要创建一个新的数据库
             *      2. 返回一个可对数据库进行读写操作的对象
             * 不同点：
             *      当数据库不可写入的时候(如磁盘空间已满)
             *      getWritableDatabase：会出现异常
             *      getReadableDatabase：将以只读的方式打开数据库
             */
            dbHelper.writableDatabase
        }

        // 增
        val mBtnAdd = findViewById<Button>(R.id.btn_add)
        mBtnAdd.setOnClickListener {
            // 使用 Android 提供的 API
            val db = dbHelper.writableDatabase
            val values1 = ContentValues().apply {
                // 开始组装第一条数据
                put("name", "语文")
                put("author", "kayroc")
                put("pages", 100)
                put("price", 1.1)
            }
            db.insert("Book", null, values1) // 插入第一条数据
            val values2 = ContentValues().apply {
                // 开始组装第二条数据
                put("name", "数学")
                put("author", "kayroc")
                put("pages", 200)
                put("price", 2.2)
            }
            db.insert("Book", null, values2) // 插入第二条数据

            // 使用 sql 语句
            db.execSQL(
                "insert into Book (name, author, pages, price) values(?, ?, ?, ?)",
                arrayOf("英语", "kayroc", "1", "1.1")
            )
            db.execSQL(
                "insert into Book (name, author, pages, price) values(?, ?, ?, ?)",
                arrayOf("历史", "kayroc", "99999", "99999")
            )
        }

        // 删
        val mBtnDelete = findViewById<Button>(R.id.btn_delete)
        mBtnDelete.setOnClickListener {
            // 使用 Android 提供的 API
            val db = dbHelper.writableDatabase
            db.delete("Book", "pages = ?", arrayOf("1"))

            // 使用 sql 语句
            db.execSQL("delete from Book where pages > ?", arrayOf("500"))
        }

        // 改
        val mBtnUpdate = findViewById<Button>(R.id.btn_update)
        mBtnUpdate.setOnClickListener {
            // 使用 Android 提供的 API
            val db = dbHelper.writableDatabase
            val values = ContentValues()
            values.put("price", 10.99)
            db.update("Book", values, "name = ?", arrayOf("The Da Vinci Code"))
            // 使用 sql 语句
            db.execSQL("update Book set price = ? where name = ?", arrayOf("10.99", "The Da Vinci Code"))
        }

        // 查
        val mBtnQuery = findViewById<Button>(R.id.btn_query)
        mBtnQuery.setOnClickListener {
            val db = dbHelper.writableDatabase
            /*
             query 方法参数：
                参数1：指定查询的表名
                参数2：指定查询的列名
                参数3：指定where的约束条件
                参数4：为where中的占位符提供具体的值
                参数5：指定需要group by的列
                参数6：对group by后的结果进一步约束
                参数7：指定查询结果的排序方式
             */
            // 使用 Android 提供的 API
            val cursor = db.query("Book", null, null, null, null, null, null)
            // // 使用 sql 语句
            // val cursor = db.rawQuery("select * from Book", null)
            if (cursor.moveToFirst()) {
                do {
                    // 遍历Cursor对象，取出数据并打印
                    val name = cursor.getString(cursor.getColumnIndex("name"))
                    val author = cursor.getString(cursor.getColumnIndex("author"))
                    val pages = cursor.getInt(cursor.getColumnIndex("pages"))
                    val price = cursor.getDouble(cursor.getColumnIndex("price"))
                    Log.d("Sqlite 数据库", "book name is $name")
                    Log.d("Sqlite 数据库", "book author is $author")
                    Log.d("Sqlite 数据库", "book pages is $pages")
                    Log.d("Sqlite 数据库", "book price is $price")
                } while (cursor.moveToNext())
            }
            cursor.close()
        }

        // 最佳实践 - 使用事务
        // 事务的特性可以保证让一系列的操作要么全部完成，要么一个都不会完成
        val mBtnTransaction = findViewById<Button>(R.id.btn_transaction)
        mBtnTransaction.setOnClickListener {
            val db = dbHelper.writableDatabase
            db.beginTransaction() // 开启事务
            try {
                db.delete("Book", null, null)
                // if (true) {
                //     // 在这里手动抛出一个异常，让事务失败
                //     throw NullPointerException()
                // }
                // 使用自定义简化 ContentValues
                val values = cvOf("name" to "Game of Thrones", "author" to "George Martin", "pages" to 720, "price" to 20.85)
                // Google ktx 提供的简化
                // val contentValuesOf = contentValuesOf("name" to "Game of Thrones", "author" to "George Martin", "pages" to 720, "price" to 20.85)
                db.insert("Book", null, values)
                db.setTransactionSuccessful() // 事务已经执行成功
            } catch (e: Exception) {
                e.printStackTrace()
            } finally {
                db.endTransaction() // 结束事务
            }
        }
    }

}