package com.gamesoft.guessnumber;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by zeya on 14-9-26.
 */
public class GuessNumberRunner {

    public static void main(String [] args) {
        System.out.println("welcome to play guess number game! ");
        Scanner sc = new Scanner(System.in);

        GuessNumberGame game = createRandomGuessNumberGame();

        while(game.canTryAgain()) {
            try {
                int[] userGuessNumbers = readUserGuessNumbers(sc);
                System.out.println(game.guess(userGuessNumbers));
                if (game.isWin()) {
                    System.out.println("Congratulations, you win !");
                    return;
                }
            } catch (IllegalArgumentException e) {
                System.out.println("wrong input. please try again...");
            }
        }
        System.out.println("Sorry, you lost ! The answer is " + Arrays.toString(game.getAnswer()));
    }

    private static GuessNumberGame createRandomGuessNumberGame() {
        RandomAnswerGenerator answerGenerator = new RandomAnswerGenerator();
        GuessNumberGame game = GuessNumberGame.createGuessNumberGame(answerGenerator.randomGenerate());
        game.setMaxTry(6);
        return game;
    }

    private static int[] readUserGuessNumbers(Scanner sc) {
        System.out.print("please input 4 numbers:");
        String inputString = sc.nextLine();
        return StringUtil.convertToIntArray(inputString);
    }
}
