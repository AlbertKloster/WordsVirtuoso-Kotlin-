# Stage 4/6: Play the game
## Description
Let's implement the core logic of the game. Create a game loop where the program asks players to guess a secret word and tell whether it was a success.

First of all, the program must randomly select a word from the candidate words list. This secret word is changed every time players restart the game. For choosing this word, use the `random` Kotlin class and the `nextInt()` function.

The code from the previous stage shouldn't be changed. In this stage you will build on that code. After printing the game title (in the previous stage), the program should ask players to guess the secret word. If the guessed word is the secret one, the game ends. If the word isn't a secret one, the program informs the player which letters of the input word are in the secret word. It also notifies the player if any of these letters has the same position in the secret word.

After a word's input, the program should print it again by making the following changes (the <b>clue string</b>):
- If a letter in the guess word is at the same position as in the secret word, print it in the uppercase.
- If it exists, but in other position, then print it in the lowercase.
- And finally, if a letter doesn't exist in the secret word, print an underscore `_` instead.

For example:

| Secret word | Guess word | Clue string |
|-------------|------------|-------------|
| write       | trail      | tR_i_       |
| house       | hound      | HOU__       |
| point       | train      | t__in       |
| solve       | batch      | _____       |

## Objectives
The code from the previous stage shouldn't be altered.

After printing the name of the game `Words Virtuoso`, implement the following:

1. Choose a secret word from the candidate words file.
2. Ask the player for input with the prompt `Input a 5-letter word:`. The input is case-insensitive.
3. The player can quit the game at any time, by inputting the word `exit`. In this case, print `The game is over.` and exit.
4. If the input is the same as the secret word, print `Correct!` and exit.
5. If the input is invalid, print an error message (described below) and go to step 2.
6. In any other case, print the clue string (created as described at the description).
7. Go to Step 2.

The player input should be checked for errors (step 4). So, if the input:
- isn't a five-letter word, print `The input isn't a 5-letter word.`
- has at least one invalid character (that is, not in `A` to `Z`), print `One or more letters of the input aren't valid.`
- has duplicate letters, print `The input has duplicate letters.`
- isn't in the words' list, print `The input word isn't included in my words list.`

The order of checking should be the same as above.

## Examples
The greater-than symbol followed by a space (`> `) represents the user input. Note that it's not part of the input.

<b>Example 1:</b> <i>standard execution with arguments: `words.txt candidates.txt`</i>
```
Words Virtuoso

Input a 5-letter word:
> train
_r_IN

Input a 5-letter word:
> round
RO_n_

Input a 5-letter word:
> robin

Correct!
```

<b>Example 2:</b> <i>early exit</i>
```
Words Virtuoso

Input a 5-letter word:
> alert
__er_

Input a 5-letter word:
> exit

The game is over.
```

<b>Example 3:</b> <i>input errors</i>
```
Words Virtuoso

Input a 5-letter word:
> trains
The input isn't a 5-letter word.

Input a 5-letter word:
> trouvée
The input isn't a 5-letter word.

Input a 5-letter word:
> étage
One or more letters of the input aren't valid.

Input a 5-letter word:
> walls
The input has duplicate letters.

Input a 5-letter word:
> poche
The input word isn't included in my words list.

Input a 5-letter word:
> exit

The game is over.
```
