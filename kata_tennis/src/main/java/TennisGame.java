/**
 * Created by zeya on 14-9-28.
 */
public class TennisGame {

    private static final String[] SCORE = new String[]{"", "fifteen", "thirty", "forty"};

    private int leftScore = 0;
    private int rightScore = 0;

    public String score() {

        if (leftScore == rightScore && leftScore == 0)
            return "love all";

        if (rightScore == 1)
            return "love fifteen";
        if (rightScore == 2)
            return "love thirty";
        if (rightScore == 3)
            return "love forty";

        return SCORE[this.leftScore] + " love";
    }

    public void leftWin() {
        this.leftScore++;
    }

    public void rightWin() {
        this.rightScore++;
    }
}
