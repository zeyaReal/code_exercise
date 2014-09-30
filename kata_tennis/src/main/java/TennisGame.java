/**
 * Created by zeya on 14-9-28.
 */
public class TennisGame {

    private static final String[] SCORE = new String[]{"love", "fifteen", "thirty", "forty"};

    private int leftScore = 0;
    private int rightScore = 0;
    private String leftPlayer;
    private String rightPayer;

    public TennisGame(String leftPlayer, String rightPayer) {

        this.leftPlayer = leftPlayer;
        this.rightPayer = rightPayer;
    }

    public String score() {

        if (leftScore > rightScore && rightScore >= 3) {
            return "advantage " + leftPlayer;
        }

        if (rightScore > leftScore && leftScore >= 3) {
            return "advantage " + rightPayer;
        }

        if (leftScore == rightScore) {
            if (leftScore < 3) {
                return SCORE[this.leftScore] + " " + "all";
            }
            return "duece";

        }
        return SCORE[this.leftScore] + " " + SCORE[this.rightScore];
    }

    public void leftWin() {
        this.leftScore++;
    }

    public void rightWin() {
        this.rightScore++;
    }
}
