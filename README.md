# Stage 3/6: Candidate words
## Description
By inspecting the words.txt file provided in the previous stage, you noticed that most words are not very common. A file like this is vital for any word guessing program to recognize actual English words. What if the secret word is chosen from these words? It may frustrate the players. No one likes a word game where words are extra rare.

The solution to this problem is to keep another list with common English words. The secret word will be chosen from this list. These words are candidates for the secret word. The game's difficulty level can be defined by the words included in this list.

In this stage, your program will read two text files. Their filenames should be passed as arguments to the program. The first argument should be the file's filename with the completed list of all five-letter English words; the second argument should be the file's filename with the candidate words.

For testing purposes, you can use the <a href="https://stepik.org/media/attachments/lesson/720509/candidates.txt">candidates.txt</a> file, which contains many common English words. The words in this file are a subset of the words included in the words.txt file.

## Objectives
- Check the number of the passed arguments. If it isn't equal to two, then print the message `Error: Wrong number of arguments.` and exit;
- The first argument is the filename of the text file containing all words. If this file doesn't exist, print the message `Error: The words file <All words filename> doesn't exist.` and exit;
- The second argument is the filename of the text file containing the candidate words. If this file doesn't exist, print the message `Error: The candidate words file <Candidates filename> doesn't exist.` and exit;
- Check the file containing all words for invalid words. If present, print `Error: <Number of invalid words> invalid words were found in the <All words filename> file.` and exit;
- Check the file containing the candidate words for invalid words. If present, print `Error: <Number of invalid words> invalid words were found in the <Candidates filename> file.` and exit;
- Check whether each candidate word is included in the file with all words. If any candidate words don't comply with that, print Error: <Number of candidates not included> candidate words are not included in the <All words filename> file. and exit;
- If everything is fine, print the game title `Words Virtuoso` and exit.

## Examples
The greater-than symbol followed by a space (`> `) represents the user input. Note that it's not part of the input.

<b>Example 1:</b> <i>normal execution with arguments `words.txt candidates.txt`</i>
```
Words Virtuoso
```

<b>Example 2:</b> <i>the number of arguments is not two</i>
```
Error: Wrong number of arguments.
```

<b>Example 3:</b> <i>the first argument filename doesn't exist</i>
```
Error: The words file words.txt doesn't exist.
```

<b>Example 4:</b> <i>the second argument filename doesn't exist</i>
```
Error: The candidate words file candidates.txt doesn't exist.
```

<b>Example 5:</b> <i>invalid words in the words file</i>
```
Error: 5 invalid words were found in the words.txt file.
```

<b>Example 6:</b> <i>invalid words in the candidates file</i>
```
Error: 3 invalid words were found in the candidates.txt file.

```

<b>Example 7:</b> <i>candidate words are not in all words list</i>
```
Error: 2 candidate words are not included in the words.txt file.
```
