package wordsvirtuoso

fun main() {
    println("Input a 5-letter string:")
    val word = readln().trim()

    if (isNotFiveLetterWord(word)) {
        println("The input isn't a 5-letter string.")
    } else if (hasNonEnglishCharacters(word)) {
        println("The input has invalid characters.")
    } else if (hasDuplicateLetters(word)) {
        println("The input has duplicate letters.")
    } else {
        println("The input is a valid string.")
    }
}

private fun isNotFiveLetterWord(word: String): Boolean {
    return word.length != 5
}

private fun hasNonEnglishCharacters(word: String): Boolean {
    return !word.matches(Regex("[a-zA-Z]+"))
}

private fun hasDuplicateLetters(word: String): Boolean {
    for (char in word) {
        if (word.count { it == char } > 1) return true
    }
    return false
}
