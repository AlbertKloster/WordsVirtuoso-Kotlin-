# Stage 1/6: Validate strings
## Description
In this project, you will create a game where users guess words. Users input a series of words, and the program reports on the input word characters that coincide with a randomly chosen secret word.

The words in this game have specific properties. They are five-letter English words that don't have any duplicate characters. That is, they consist of five unique (word-wise) English-alphabet characters.

In this stage, write the appropriate code for checking whether an input string consists of five unique English letters. The input is referred to as a string, not a word because you will not check whether it is a valid English word.

## Objectives
- Output the `Input a 5-letter string:` line and wait for a five-letter string. Ignore any leading or trailing spaces. The input string isn't case-sensitive so that it can be a mix of upper or lower case characters.

If the user inputs a string:

- with a number of letters different than five, print `The input isn't a 5-letter string.`;
- that consists of non-English alphabet characters (from `A` to `Z`), print `The input has invalid characters.`;
- with duplicate characters, print `The input has duplicate letters.`;
- otherwise, print `The input is a valid string.`.

The order of checking the string properties should be the same as above.

## Examples
The greater-than symbol followed by a space (`> `) represents the user input. Note that it's not part of the input.

<b>Example 1:</b> <i>a valid string</i>
```
Input a 5-letter string:
> Smile
The input is a valid string.
```

<b>Example 2:</b> <i>input isn't a five-letter string</i>
```
Input a 5-letter string:
> Trains
The input isn't a 5-letter string.
```

<b>Example 3:</b> <i>Input with no English characters</i>
```
Input a 5-letter string:
> trέξs
The input has invalid characters.
```

<b>Example 4:</b> <i>input with a space</i>
```
Input a 5-letter string:
> so da
The input has invalid characters.
```

<b>Example 5:</b> <i>input with duplicate characters</i>
```
Input a 5-letter string:
> HELLO
The input has duplicate letters.
```
