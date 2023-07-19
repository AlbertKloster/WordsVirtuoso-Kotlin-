package wordsvirtuoso

import java.io.File
import java.io.IOException

fun main() {
    println("Input the words file:")
    val filename = readln()
    try {
        val words = readAllWords(filename)
        var errorCount = 0
        words.forEach { word ->
            if (isNotValidWord(word)) errorCount++
        }

        if (errorCount == 0)
            println("All words are valid!")
        else
            println("Warning: $errorCount invalid words were found in the $filename file.")

    } catch (e: IOException) {
        println("Error: The words file $filename doesn't exist.")
    }

}

private fun isNotValidWord(word: String): Boolean {
    return isNotFiveLetterWord(word) || hasNotEnglishCharacters(word) || hasDuplicateLetters(word)
}

private fun isNotFiveLetterWord(word: String): Boolean {
    return word.length != 5
}

private fun hasNotEnglishCharacters(word: String): Boolean {
    return !word.matches(Regex("[a-zA-Z]+"))
}

private fun hasDuplicateLetters(word: String): Boolean {
    for (char in word) {
        if (word.count { it == char } > 1) return true
    }
    return false
}

private fun readAllWords(filename: String) = File(filename).useLines { it.toSet() }