import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by zeya on 14-9-28.
 */
public class TennisGameTest {

    private TennisGame game;

    @Before
    public void setUp() {
        game = new TennisGame();
    }

    @Test
    public void test_shouuld_be_lovel_all_when_game_begin() throws Exception {
        assertLeftRightScore(0, 0, "love all");
    }

    @Test
    public void test_shouuld_be_fifteen_lovel_when_game_score_1_0() throws Exception {
        assertLeftRightScore(1, 0, "fifteen love");
    }

    @Test
    public void test_shouuld_be_thirty_lovel_when_game_score_2_0() throws Exception {
        assertLeftRightScore(2, 0, "thirty love");
    }

    @Test
    public void test_shouuld_be_forty_lovel_when_game_score_3_0() throws Exception {
        assertLeftRightScore(3, 0, "forty love");
    }

    @Test
    public void test_shouuld_be_love_fifteen_when_game_score_0_1() throws Exception {
        assertLeftRightScore(0, 1, "love fifteen");
    }

    @Test
    public void test_shouuld_be_love_thirty_when_game_score_0_2() throws Exception {
        assertLeftRightScore(0, 2, "love thirty");
    }

    @Test
    public void test_shouuld_be_love_forty_when_game_score_0_3() throws Exception {
        assertLeftRightScore(0, 3, "love forty");
    }

    @Test
    public void test_shouuld_be_fifteen_all_when_game_score_1_1() throws Exception {
        assertLeftRightScore(1, 1, "fifteen all");
    }

    @Test
    public void test_shouuld_be_thirty_all_when_game_score_2_2() throws Exception {
        assertLeftRightScore(2, 2, "thirty all");
    }

    @Test
    public void test_shouuld_be_duece_when_game_score_3_3() throws Exception {
        assertLeftRightScore(3, 3, "duece");
    }

    @Test
    public void test_shouuld_be_duece_when_game_score_4_4() throws Exception {
        assertLeftRightScore(4, 4, "duece");
    }

    @Test
    public void test_shouuld_be_duece_when_game_score_5_5() throws Exception {
        assertLeftRightScore(5, 5, "duece");
    }

    private void assertLeftRightScore(int leftScore, int rightScore, String score) {
        setScore(leftScore, rightScore);
        assertThat(game.score(), is(score));
    }

    private void setScore(int leftCount, int rightCount) {
        setLeftScore(leftCount);
        setRightScore(rightCount);
    }

    private void setRightScore(int count) {
        for (int i = 0; i < count; i++) {
            game.rightWin();
        }
    }

    private void setLeftScore(int count) {
        for (int i = 0; i < count; i++) {
            game.leftWin();
        }
    }

}
