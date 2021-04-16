class HelloWorld(private val name: String) {
    fun hello() {
        println("Hello, $name")
    }
}

// Kotlin 1.3开始支持无参数的main方法
//fun main() {
// Kotlin 1.3之前的版本必须带参数
fun main(args: Array<String>) {
    println("Hello World")

    val name = if (args.isEmpty() || args[0].isEmpty()) "World!" else args[0]
    println("Hello $name")

    HelloWorld(name).hello()

    for (str in args) {
        println("Hello, $str!")
    }

    val language = if (args.isEmpty()) "EN" else args[0]
    println(
        when (language) {
            "EN" -> "Hello!"
            "FR" -> "Salut!"
            "IT" -> "Ciao!"
            else -> "Sorry, I can't greet you in $language yet"
        }
    )
}
