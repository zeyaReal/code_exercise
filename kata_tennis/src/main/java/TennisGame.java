/**
 * Created by zeya on 14-9-28.
 */
public class TennisGame {

    private static final String[] SCORE = new String[]{"", "fifteen", "thirty", "forty"};

    private int leftScore = 0;

    public String score() {
        if (leftScore == 0)
            return "love all";

        return SCORE[this.leftScore] + " love";
    }

    public void leftWin() {
        this.leftScore++;
    }
}
