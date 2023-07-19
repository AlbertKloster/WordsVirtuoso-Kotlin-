# Stage 2/6: Read words from a file
## Description
There is only one solution to check whether a string is an actual English word— use a dictionary.

In this stage, your program will read a text file with English words, one in each line. Check every word as in the previous stage. It should be a five-letter word, consisting of `A` to `Z` characters, only unique letters. All words are considered <b>case-insensitive</b>.

For testing purposes, you can use the <a href="https://stepik.org/media/attachments/lesson/720509/words.txt">words.txt</a> file, which includes almost all valid words, and the <a href="https://stepik.org/media/attachments/lesson/720509/invalidWords.txt">invalidWords.txt</a> file which contains some invalid words.

## Objectives
- Output the following line: `Input the words file:` to ask users to input a filename of a file with words. If the file doesn't exist, print `Error: The words file <filename> doesn't exist.` and terminate the program. The `<filename>` is the filename user input. One way to terminate a program is to use the `kotlin.system exitProcess()` <a href="https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.system/exit-process.html">function</a>;
- Check whether every line of the file satisfies the required rules. If all words are valid, print `All words are valid!` otherwise, print `Warning: <number of invalid words> invalid words were found in the <filename> file.`, where `<number of invalid words>` are the total number of words that don't comply with our word rules;
- Terminate the program

## Examples
The greater-than symbol followed by a space (`> `) represents the user input. Note that it's not part of the input.

<b>Example 1:</b> <i>all words are correct</i>
```
Input the words file:
> words.txt
All words are valid!
```

<b>Example 2:</b> <i>invalid words in the file</i>
```
Input the words file:
> invalidwords.txt
Warning: 5 invalid words were found in the invalidwords.txt file.
```

<b>Example 3:</b> <i>file doesn't exist</i>
```
Input the words file:
> filenoexist.txt
Error: The words file filenoexist.txt doesn't exist.
```
