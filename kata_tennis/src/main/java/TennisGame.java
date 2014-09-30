/**
 * Created by zeya on 14-9-28.
 */
public class TennisGame {

    private static final String[] SCORE = new String[]{"love", "fifteen", "thirty", "forty"};
    private static final int POINT_LOWER_ADVANTAGE_LIMIT = 2;
    private static final int POINT_LOWER_WIN_LIMIT = 3;
    private static final int SCORE_GAP_OF_WIN = 1;

    private int leftScore = 0;
    private int rightScore = 0;
    private String leftPlayer;
    private String rightPayer;

    public TennisGame(String leftPlayer, String rightPayer) {
        this.leftPlayer = leftPlayer;
        this.rightPayer = rightPayer;
    }

    public String score() {

        if (isWinnerExist())
            return getHigherScorePayer() + " win";

        if (isAdvantageExist())
            return "advantage " + getHigherScorePayer();

        if (isDuece())
            return "deuce";

        if (leftScore == rightScore)
            return SCORE[this.leftScore] + " all";

        return SCORE[this.leftScore] + " " + SCORE[this.rightScore];
    }

    private boolean isDuece() {
        return leftScore == rightScore && leftScore > POINT_LOWER_ADVANTAGE_LIMIT;
    }

    private boolean isWinnerExist() {
        return leftScore - rightScore > SCORE_GAP_OF_WIN && leftScore > POINT_LOWER_WIN_LIMIT || rightScore - leftScore > SCORE_GAP_OF_WIN && rightScore > POINT_LOWER_WIN_LIMIT;
    }

    private boolean isAdvantageExist() {
        return leftScore > rightScore && rightScore > POINT_LOWER_ADVANTAGE_LIMIT || rightScore > leftScore && leftScore > POINT_LOWER_ADVANTAGE_LIMIT;
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
