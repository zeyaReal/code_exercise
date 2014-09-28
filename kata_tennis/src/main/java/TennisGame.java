/**
 * Created by zeya on 14-9-28.
 */
public class TennisGame {

    private int leftScore = 0;

    public String score() {
        String[] score = new String[]{"", "fifteen", "thirty", "forty"};
        if (leftScore == 1)
            return score[1] + " love";
        if (leftScore == 2)
            return score[2] + " love";
        if (leftScore == 3)
            return score[3] + " love";
        return "love all";
    }

    public void leftWin() {
        this.leftScore++;
    }
}
