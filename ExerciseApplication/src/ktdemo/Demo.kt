package ktdemo

import java.lang.System.out

/**
 * Created by zhangzhiquan on 2018/3/25.
 */

fun sum(a: Int, b: Int): Int {
    return a + b
}

fun printSum(a: Int, b: Int) {
    println("sum of $a and $b is ${a + b}")
}

fun parseInt(str: String): Int? {
    return str.toIntOrNull();
}

fun printProduce(arg1: String, arg2: String) {
    val x = parseInt(arg1)
    val y = parseInt(arg2)
    if (x != null && y != null) {
        println(x * y)
    }
}

fun printForTest(){
    println("begin for")
    var array = arrayListOf("a","b","c")
    array.add("d")
    for(i in 0..3){
        println("array $i is ${array[i]}")
    }
    println("end for")
}


fun printLongTest(arg1: Int?) {
    val b: Long? = arg1?.toLong() ?: 0
    println("b is $b")

}

class Person {
    var name :String? =null
    constructor( name:String){
        this.name = name
    }
    fun getname() = name
}


fun <T> ArrayList<T>.swap( a: Int, b: Int){
    val tmp = this[a]
    this[a] = this[b]
    this[b] = tmp
}

fun swapTest(){
    var list = arrayListOf(1,2,3,4,5)
    list.swap(1,2)
    print(list)
}

fun main(args: Array<String>) {
    print("sum of 3 and 5 is ")
    println(sum(3, 5))
    println("sum of 3 and 5 is ${sum(3, 5)}")
    printSum(1, 2)
    printProduce("3", "6")
    printLongTest(19)
    var person: Person = Person("zhjamgh")
    println("person name: ${person.getname()?.length}")
    printForTest()
    swapTest()
}
