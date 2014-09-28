/**
 * Created by zeya on 14-9-28.
 */
public class TennisGame {
    private int leftScore = 0;

    public String score() {
        if (leftScore == 1)
            return "fifteen love";
        return "love all";
    }

    public void leftWin() {
        this.leftScore++;
    }
}
