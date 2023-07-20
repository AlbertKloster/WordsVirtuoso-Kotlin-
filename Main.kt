package wordsvirtuoso

import java.io.File
import java.io.IOException
import java.util.Random

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

        val secretWord = candidates.elementAt(Random().nextInt(candidates.size))

        val startTime = System.currentTimeMillis()
        var turn = 1
        val wrongChars = mutableSetOf<Char>()
        val clueStrings = mutableListOf<String>()

        while (true) {
            println("Input a 5-letter word:")
            val guessWord = readln()

            if (guessWord == "exit") {
                println("The game is over.")
                break
            }

            if (isNotFiveLetterWord(guessWord)) {
                println("The input isn't a 5-letter word.")
                continue
            }

            if (hasNotEnglishCharacters(guessWord)) {
                println("One or more letters of the input aren't valid.")
                continue
            }

            if (hasDuplicateLetters(guessWord)) {
                println("The input has duplicate letters.")
                continue
            }

            if (!words.contains(guessWord.lowercase())) {
                println("The input word isn't included in my words list.")
                continue
            }

            val builder = StringBuilder()
            var matches = 0
            for (i in guessWord.indices) {
                if (guessWord[i] == secretWord[i]) {
                    builder.append(guessWord[i].uppercase().green())
                    matches++
                } else if (secretWord.contains(guessWord[i].lowercase())) {
                    builder.append(guessWord[i].uppercase().yellow())
                } else {
                    wrongChars.add(guessWord[i].uppercaseChar())
                    builder.append(guessWord[i].uppercase().grey())
                }
            }

            clueStrings.add(builder.toString())
            println(clueStrings.joinToString("\n\r"))

            if (matches == secretWord.length) {
                println("Correct!")
                val duration = System.currentTimeMillis() - startTime
                if (turn == 1)
                    println("Amazing luck! The solution was found at once.")
                else
                    println("The solution was found after $turn tries in ${duration / 1000} seconds.")
                break
            }

            println()
            println(wrongChars.sorted().joinToString("").azure())
            println()
            turn++

        }

    } catch (e: Exception) {
        println(e.message)
    }

}

private fun String.green() = "\u001B[48:5:10m$this\u001B[0m"

private fun String.yellow() = "\u001B[48:5:11m$this\u001B[0m"

private fun String.grey() = "\u001B[48:5:7m$this\u001B[0m"

private fun String.azure() = "\u001B[48:5:14m$this\u001B[0m"

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
