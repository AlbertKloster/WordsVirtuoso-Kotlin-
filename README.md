# Stage 5/6: Game enhancements
## Description
The core game is ready, but the final touches remain.

Let's add a dab of challenge to the game. Commend the users when they are successful by considering two indicators. The first is the <b>number of turns</b> (how many inputs) until the player finds the solution (including the erroneous input). The second is the time the player took to find the solution. That is, from the moment the first question is printed to the moment when the success message is printed.

You can use the <a href="https://www.baeldung.com/kotlin/measure-elapsed-time">Measuring Elapsed Time in Kotlin</a> tutorial to measure the time. The simplest solution is to use `System.currentTimeMillis()` to measure duration in <b>milliseconds</b> as in the following example:
```
var start = System.currentTimeMillis()
// Code to measure the execution time
var end = System.currentTimeMillis()
val duration = end - start  // Milliseconds as a Long
```

Also, print the clue strings from the previous tries after each valid input in the order they occurred (see Examples 1 and 2).

The player should also have the wrong characters from all the previous tries at their disposal. Print them in alphabetical order, without spaces or anything else between them, in uppercase. This way, the player will have all the available information gathered together (see Examples 1 and 2).

## Objectives
- If players input an invalid word, print an error message and ask for another input;
- If players find the secret word on the first try, print the word in upper case, the line `Amazing luck! The solution was found at once.` and exit (see Example 3).
- Otherwise, print the clue strings with the valid input. They should appear in the order of the input (the first one on top and the last at the bottom). Then print all the wrong characters from all the tries in alphabetical order, upper case, without any separators in between;
- When the user guesses the word (on the 2nd+ attempt), print all the clue strings (but not the wrong characters), `The solution was found after <turns> tries in <time lapsed> seconds.`, and exit, where `<turns>` is how many times the player input words (including wrong input); `<time lapsed>` is the time in seconds.

## Examples
The greater-than symbol followed by a space (`> `) represents the user input. Note that it's not part of the input.

<b>Example 1:</b> <i>normal execution</i>
```
Words Virtuoso

Input a 5-letter word:
> train

tr___

AIN

Input a 5-letter word:
> scope

tr___
S_O__

ACEINP

Input a 5-letter word:
> score

tr___
S_O__
S_OR_

ACEINP

Input a 5-letter word:
> storm

tr___
S_O__
S_OR_
STORM

Correct!
The solution was found after 4 tries in 54 seconds.
```

<b>Example 2:</b> <i>normal execution</i>
```
Words Virtuoso

Input a 5-letter word:
> smile

_____

EILMS

Input a 5-letter word:
> speak

_____
___a_

EIKLMPS

Input a 5-letter word:
> basic

_____
___a_
Ba___

CEIKLMPS

Input a 5-letter word:
> begin

_____
___a_
Ba___
B___n

CEGIKLMPS

Input a 5-letter word:
> brain

_____
___a_
Ba___
B___n
BRA_n

CEGIKLMPS

Input a 5-letter word:
> brand

_____
___a_
Ba___
B___n
BRA_n
BRAND

Correct!
The solution was found after 7 tries in 108 seconds.
```

<b>Example 3:</b> <i>secret word guessed on the first try</i>
```
Words Virtuoso

Input a 5-letter word:
swift

SWIFT

Correct!
Amazing luck! The solution was found at once.
```
