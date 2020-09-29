import java.io.File
import java.io.InputStream

fun main(args: Array<String>) {
    val inputStream: InputStream = File(args.get(1)).inputStream()

    var inputString = inputStream.bufferedReader().use {
        it.readText()
    }

    if (args.get(2).isNotEmpty() && args.get(3).isNotEmpty()) {
        val regex = Regex(args.get(2))
        inputString = inputString.replace(regex, args.get(3))

        if (inputString.isNotEmpty() && args.get(1).isNotEmpty()) {
            File("new_${args.get(1)}").writeText(inputString)
        } else {
            println("Sorry, write file error!")
        }
    } else {
        println("Please send first/second params!")
    }
}