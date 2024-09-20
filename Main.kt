package com.dicoding.classAndCollection

import java.awt.Color

fun main() {
    var dtmhs = dataMahasiswa("Rangga", 2244190015)
    println(dtmhs)
    var mhs = mahasiswa("Rangga", 2244190015)
    println(mhs)

    //equals in data class
    val dtmhsw = dataMahasiswa("Rangga", 2244190015)
    val dtmhsw2 = dataMahasiswa("Rangga", 2244190015)
    val dtmhsw3 = dataMahasiswa("Rendy", 2319045512)
    //copy() in data class
    val dtmhsw4 = dtmhsw3.copy("Reza")

    //componentN() in data class
    val nama = dtmhsw.component1()
    val nimm = dtmhsw.component2()
    println("my name is $nama, and my student identity is $nimm")

    //single Line componentN
    val (name, nim) = dtmhsw3
    println("my name is $name, and my student identity is $nim")

    println(dtmhsw.equals(dtmhsw2))
    println(dtmhsw.equals(dtmhsw3))
    println(dtmhsw4)

    //manual equals
    val user = User("Rangga", 20)
    val user2 = User("Rangga", 20)
    val user3 = User("Rendy", 25)
    println(user.equals(user2))
    println(user.equals(user3))

    val dataUser = DataUser("nrohmen", 23)
    dataUser.intro()

    //nested class
    /*val room = house.room()*/

    //inner class
    val House = House()
    val Room = House.Room()
    Room.measureArea()

    //enum class
    val colorRed = Color.RED
    val colorGreen = Color.GREEN
    val colorBlue = Color.BLUE

    println(colorRed)

    val Color: Color = Color.BLUE
    println(Color)

    //sealed class
    val result: Result = Result.Error("Oops!")
    when (result) {
        //jika salah satu kondisi dihapus, kode akan error
        is Result.Success -> {
            println("Success: ${result.data}")
        }

        is Result.Error -> {
            println("Error: ${result.message}")
        }

        is Result.Loading -> {
            println("Loading...")
        }
    }

    //singleton
    CentralLibrary.borrowBookById(15)

    //companion
    //Library.Companion.borrowBookById(21)
    Library.borrowBookById(21)
    val libName = MyLibrary.LIBRARY_NAME
    println(libName)

    //anonymous class
    flyWithWings {
        println("The Bird flying")
    }

    //List
    println(numberList)

    //mutable list
    val anyList = mutableListOf('a', 3, "abc", true)
    anyList.removeAt(0) // menghapus item pada indeks ke-0
    anyList.add(0,'a')
    anyList.add('z')
    anyList[3] = false
    anyList.removeAt(4)
    println(anyList)

    //Set
    val intSet = setOf(1, 2, 4, 4, 3, 1)
    val numSet = setOf(7, 6, 8, 0, 9, 2)
    println(intSet)

    val union = intSet.union(numSet)
    println(union)

    val intersect = intSet.intersect(numSet)
    println(intersect)

    //Map
    val capital = mapOf(
        "Jakarta" to "Indonesia",
        "London" to "England",
        "New Delhi" to "India"
    )

    println(capital["Jakarta"])

    //filter
    val numList = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    val evenList = numList.filter{it % 2 == 0}
    val oddList = numList.filterNot{it % 2 == 0}
    println(evenList)
    println(oddList)

    //map()
    val multipliedBy5 = numList.map{it * 5}
    println(multipliedBy5)

    //count
    println(numList.count{it % 3 == 0})

    //find()
    val firstOddNumber = numList.find { it % 2 == 1 }
    println(firstOddNumber)

    //first or null
    val firstOrNullNumber = numList.firstOrNull { it % 2 == 3 }
    println(firstOrNullNumber)

    //first()
    val moreThan5 = numList.first { it > 5 }
    println(moreThan5)

    //fold
    val numbers = listOf(1, 2, 3)
    val fold = numbers.fold(10) { current, item ->
        println("current $current")
        println("item $item")
        println()
        item + current
    }

    println("Fold result: $fold")

    //foldRight
    val nums = listOf(1, 2, 3)
    val foldR = nums.foldRight(10) { item, current ->
        println("current $current")
        println("item $item")
        println()
        item + current
    }

    println("Fold result: $foldR")

    //drop()
    val numb = listOf(1, 2, 3, 4, 5, 6)
    val drop = numb.drop(3)
    val dropL = numb.dropLast(3)

    println(drop)
    println(dropL)

    //take()
    val take = numb.take(3)
    val takeL = numb.takeLast(3)
    println(take)
    println(takeL)

    //slice()
    val slice = numb.slice(2..5 step 2)
    println(slice)

    val index = listOf(2, 3, 5, 8)
    val total = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    val sliced = total.slice(index)

    println(sliced)

    //distinct
    val totall = listOf(1, 2, 1, 3, 4, 5, 2, 3, 4, 5)
    val distinct = totall.distinct()

    println(distinct)

    //distinctBy
    val text = listOf("A", "B", "CC", "DD", "EEE", "F", "GGGG")
    val distinctd = text.distinctBy {
        it.length
    }

    println(distinctd)

    //chuncked
    val word = "QWERTY"
    val chunked = word.chunked(3)
    val chunkedTransform = word.chunked(3) {
        it.toString().toLowerCase()
    }

    println(chunked)
    println(chunkedTransform)

    //sequence
    val list = (1..10000).toList()
    val number = list.asSequence().filter { it % 5 == 0 }.map { it * 2 }.first()
    println(number)

    val sequenceNumber = generateSequence(1) { it + 1 }
    sequenceNumber.take(5).forEach { print("$it ") }

}


//Data Class
data class dataMahasiswa(var name: String, var nim: Long)

class mahasiswa(var name: String, var nim: Long){
    override fun toString(): String{
        return ("$name $nim")
    }
}

class User(val name : String, val age : Int){

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as User

        if (name != other.name) return false
        if (age != other.age) return false

        return true
    }

    override fun hashCode(): Int {
        var result = name.hashCode()
        result = 31 * result + age
        return result
    }
}

data class DataUser(val name : String, val age : Int){
    fun intro(){
        println("My name is $name, I am $age years old")
    }
}

//nested class
class house{
    class room{

    }
}

//inner class
class House{
    //Outer class Prop
    val buildingArea = 100
    val totalRooms = 4
    inner class Room{
        val totalRooms = 5
        fun measureArea(){
            println(buildingArea/this@House.totalRooms)
        }
    }
}

//enum class
enum class color(val value: Int){
    RED(0xff0000),
    GREEN(0x00ff00),
    BLUE(0x0000ff)
}

enum class Color{
    RED,GREEN,BLUE
}

//sealed class
sealed class Result {
    sealed class Success(val data: Any) : Result()
    data class Error(val message: String) : Result()
    object Loading : Result()
}

//Singleton Obj
object CentralLibrary {
    fun borrowBookById(id: Int) {
        println("Book with ID-$id has been borrowed")
    }
}

//Companion Obj
class Library {
    companion object{
        fun borrowBookById(id: Int) {
            println("Book with $id has been borrowed")
        }
    }
}

class MyLibrary {
    // Const 'val' are only allowed on top level, in named objects, or in companion objects
    // const val LIBRARY_NAME = "Dicoding Library"

    fun totalBook() {
        print("Total book in $LIBRARY_NAME is unlimited")
    }

    companion object{
        const val LIBRARY_NAME = "Dicoding Library"
    }
}

//anonymous class
fun interface IFly {
    fun fly()
}

fun flyWithWings(bird: IFly) {
    bird.fly()
}

/*
class Bird : IFly {
    override fun fly() {
        println("The Bird flying")
    }
}*/

//Collection
//list
val numberList: List<Int> = listOf(1, 2, 3)