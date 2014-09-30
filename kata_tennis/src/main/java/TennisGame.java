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

        if (isWinnerExist()) return getHigherScorePayer() + " win";

        if (isAdvantageExist()) return "advantage " + getHigherScorePayer();

        if (isDuece()) return "duece";

        if (leftScore == rightScore)
            return SCORE[this.leftScore] + " " + "all";

        return SCORE[this.leftScore] + " " + SCORE[this.rightScore];
    }

    private boolean isDuece() {
        return leftScore == rightScore && leftScore > 2;
    }

    private boolean isWinnerExist() {
        return leftScore - rightScore > 1 && rightScore > 1 || rightScore - leftScore > 1 && leftScore > 1;
    }

    private boolean isAdvantageExist() {
        return leftScore > rightScore && rightScore > 2 || rightScore > leftScore && leftScore > 2;
    }

    private String getHigherScorePayer() {
        return leftScore > rightScore ? leftPlayer : rightPayer;
    }

    public void leftWin() {
        this.leftScore++;
    }

    public void rightWin() {
        this.rightScore++;
    }
}
