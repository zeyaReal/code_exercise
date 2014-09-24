package com.gamesoft.guessnumber;

/**
 * Created by zeya on 14-9-23.
 */
public class GuessNumberGame {
    private int[] answerNumbers;

    public GuessNumberGame(int[] answerNumbers) {
        this.answerNumbers = answerNumbers;
    }

    public String guess(int[] guessNumbers) {
        int completeRightCount = 0;
        int wrongPositionCount = 0;
        for (int i = 0; i < guessNumbers.length; i++) {
            int index = findNumberIndex(guessNumbers[i]);
            if (index < 0) continue;
            if (index == i) {
                completeRightCount++;
            }
            else{
                wrongPositionCount++;
            }
        }
        return completeRightCount + "A" + wrongPositionCount +"B";
    }

    private int findNumberIndex(int guessNumber) {
        for (int i = 0; i < this.answerNumbers.length; i++) {
            if (guessNumber == this.answerNumbers[i]) {
                return i;
            }
        }
        return -1;
    }
}
