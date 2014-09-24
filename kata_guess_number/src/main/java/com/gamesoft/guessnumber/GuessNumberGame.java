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
        for (int i = 0; i < this.answerNumbers.length; i++) {
            if (this.answerNumbers[i] == guessNumbers[i]){
                completeRightCount++;
            }
        }
        return completeRightCount+"A0B";
    }
}
