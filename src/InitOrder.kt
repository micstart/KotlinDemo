fun main() {
//    var base = Base()
    println("--- First time ---")
    var sub1 = Sub()
    println("\n--- Second time ---")
    var sub2 = Sub()
}

fun printAndReturn(str: String): String {
    println(str)
    return str
}

open class Base {
    var baseStr1: String = printAndReturn("Base var 1")

    init {
        println("Base init 1")
    }

    constructor() {
        println("Base constructor ***")
    }

    companion object {
        var baseCompanionStr1: String = printAndReturn("Base companion var 1")

        init {
            println("Base companion init 1")
        }
    }

    var baseStr2: String = printAndReturn("Base var 2")

    init {
        println("Base init 2")
    }
}

class Sub : Base {
    var subStr1: String = printAndReturn("Sub var 1")

    init {
        println("Sub init 1")
    }

    constructor() {
        println("Sub constructor ***")
    }

    companion object {
        var subCompanionStr1: String = printAndReturn("Sub companion var 1")

        init {
            println("Sub companion init 1")
        }
    }

    var subStr2: String = printAndReturn("Sub var 2")

    init {
        println("Sub init 2")
    }

}
