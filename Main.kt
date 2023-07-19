package wordsvirtuoso

import java.io.File
import java.io.IOException

fun main(args: Array<String>) {
    try {
        if (args.size != 2) throw RuntimeException("Error: Wrong number of arguments.")

        val wordsFilename = args[0]
        val candidatesFilename = args[1]

        val words = readWords(wordsFilename)
        val invalidWords = countInvalidWords(words)

        if (invalidWords != 0) throw RuntimeException("Error: $invalidWords invalid words were found in the $wordsFilename file.")

        val candidates = readCandidates(candidatesFilename)
        val invalidCandidates = countInvalidWords(candidates)

        if (invalidCandidates != 0) throw RuntimeException("Error: $invalidCandidates invalid words were found in the $candidatesFilename file.")

        val notIncludedCandidatesInWords = countNotIncludedCandidatesInWords(candidates, words)

        if (notIncludedCandidatesInWords != 0) throw RuntimeException("Error: $notIncludedCandidatesInWords candidate words are not included in the $wordsFilename file.")

        println("Words Virtuoso")

    } catch (e: Exception) {
        println(e.message)
    }

}

private fun countNotIncludedCandidatesInWords(candidates: Set<String>, words: Set<String>) = candidates.count { !words.contains(it) }

private fun countInvalidWords(words: Set<String>) = words.count { isNotValidWord(it) }

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

private fun readWords(filename: String): Set<String> {
    try {
        return File(filename).useLines { it.map { word -> word.lowercase() }.toSet() }
    } catch (e: IOException) {
        throw RuntimeException("Error: The words file $filename doesn't exist.")
    }
}

private fun readCandidates(filename: String): Set<String> {
    try {
        return File(filename).useLines { it.map { word -> word.lowercase() }.toSet() }
    } catch (e: IOException) {
        throw RuntimeException("Error: The candidate words file $filename doesn't exist.")
    }
}
