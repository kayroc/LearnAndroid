package kayroc.android.learn.service

import android.content.Context
import android.content.Intent

// 泛型实化
// 1. 必须是内敛函数，使用 inline 修饰函数
// 2. 声明泛型的地方必须加上 reified 关键字表示泛型要进行实化
inline fun <reified T> getGenericType() = T::class.java

fun main() {
    val result1 = getGenericType<String>()
    val result2 = getGenericType<Int>()
    println("result1 is $result1")
    println("result2 is $result2")
}

inline fun <reified T> startActivity(context: Context) {
    val intent = Intent(context, T::class.java)
    context.startActivity(intent)
}

inline fun <reified T> startActivity(context: Context, block: Intent.() -> Unit) {
    val intent = Intent(context, T::class.java)
    block(intent)
    context.startActivity(intent)
}