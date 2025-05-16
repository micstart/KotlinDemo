import java.util.Locale.getDefault

/**
 * 类声明由类名、类头（指定其类型参数、主构造函数等）以及由花括号包围的类体构成。
 * 类头与类体都是可选的；如果一个类没有类体，可以省略花括号。
 * 如果一个非抽象类没有声明任何（主或次）构造函数，它会有一个生成的不带参数的可见性是public主构造函数
 * 如果你不希望你的类有一个公有构造函数，你需要声明一个带有非默认可见性的空的主构造函数
 */
class Empty1
class Empty2 private constructor()

/**
 * 类名后为主构造函数及参数
 */
class Person1 constructor(firstName: String)

/**
 * 如果主构造函数没有任何注解或者可见性修饰符，可以省略constructor关键字
 */
class Person2(firstName: String)

/**
 * 主构造函数不能包含任何的代码
 * 可以在变量定义时或init块中初始化
 */
class Person3(firstName: String) {
    private var originalFirstName = firstName
    var uppercaseFirstName: String

    init {
        uppercaseFirstName = originalFirstName.uppercase(getDefault())
    }
}

/**
 * 直接在主构造函数中定义并初始化属性
 */
class Person4(val firstName: String, val lastName: String, private var age: Int)

/**
 * 可以在类体中定义次构造函数
 */
class Person5 {
    constructor(firstName: String, lastName: String, age: Int) {
        println("Person5.constructor 3 parameter")
    }

    constructor(firstName: String, lastName: String) : this(firstName, lastName, 0) {
        println("Person5.constructor 2 parameter")
    }
}

/**
 * 同时定义主构造函数、次构造函数时，次构造函数必须调用主构造函数，或其他次构造函数（间接调用主构造函数）
 */
class Person6(val firstName: String, val lastName: String, private var age: Int) {
    constructor(firstName: String, lastName: String) : this(firstName, lastName, 0) {
        println("Person6.constructor 2 parameter")
    }

    constructor(firstName: String) : this(firstName, "") {
        println("Person6.constructor 1 parameter")
    }
}

fun main() {
    val empty1 = Empty1()
    empty1.toString()
//    val empty2 = Empty2()
    val p1 = Person1("p1")
    val p2 = Person2("p2")
    val p3 = Person3("p3")
    val p4 = Person4("first", "last", 10)
    val p5 = Person5("first", "last")
    val p6 = Person6("first")
}