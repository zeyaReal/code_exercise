package com.gamesoft.guessnumber;

/**
 * Created by zeya on 14-9-23.
 */
public class GuessNumberGame {
    public static final int MAX_NUMBER = 9;
    private int[] answerNumbers;
    private boolean isWin = false;
    private int maxTryNum;
    private int currentGuessNum = 0;

    private GuessNumberGame(int[] answerNumbers) {
        this.answerNumbers = answerNumbers;
    }

    public static GuessNumberGame createGuessNumberGame(int[] answerNumbers) {
        return new GuessNumberGame(answerNumbers);
    }

    public String guess(int[] inputNumbers) {
        checkWrongNumber(inputNumbers);
        checkNumberBeyondRange(inputNumbers);
        checkDuplicatedNumber(inputNumbers);

        return guessValidInputNumber(inputNumbers);
    }

    private String guessValidInputNumber(int[] inputNumbers) {
        int completeRightCount = 0;
        int wrongPositionCount = 0;
        for (int i = 0; i < inputNumbers.length; i++) {
            int index = findNumberIndexInAnswer(inputNumbers[i]);

            if (index < 0) continue;

            if (index == i)
                completeRightCount++;
            else
                wrongPositionCount++;
        }
        this.currentGuessNum++;
        setWinflag(completeRightCount);
        return completeRightCount + "A" + wrongPositionCount + "B";
    }

    private void setWinflag(int completeRightCount) {
        if (completeRightCount == answerNumbers.length) {
            this.isWin = true;
        }
    }

    private void checkWrongNumber(int[] guessNumbers) {
        if (guessNumbers.length != this.answerNumbers.length)
            throw new IllegalArgumentException("wrong numbers");
    }

    private void checkNumberBeyondRange(int[] guessNumbers) {
        for (int i = 0; i < guessNumbers.length; i++) {
            if (guessNumbers[i] > MAX_NUMBER)
                throw new IllegalArgumentException("number " + guessNumbers[i] + " beyond max number" + MAX_NUMBER);
        }
    }

    private void checkDuplicatedNumber(int[] guessNumbers) {
        for (int i = 0; i < guessNumbers.length; i++) {
            for (int j = i + 1; j < guessNumbers.length; j++) {
                if (guessNumbers[i] == guessNumbers[j])
                    throw new IllegalArgumentException("duplicated numbers");
            }
        }
    }

    private int findNumberIndexInAnswer(int guessNumber) {
        for (int i = 0; i < this.answerNumbers.length; i++) {
            if (guessNumber == this.answerNumbers[i]) {
                return i;
            }
        }
        return -1;
    }

    public boolean isWin() {
        return isWin;
    }

    public void setMaxTry(int maxTryNum) {
        this.maxTryNum = maxTryNum;
    }

    public boolean canTryAgain() {
        return currentGuessNum < this.maxTryNum;
    }

    public int[] getAnswer() {
        return this.answerNumbers;
    }
}
