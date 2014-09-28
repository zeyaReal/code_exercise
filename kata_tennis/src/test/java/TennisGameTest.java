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
        assertThat(game.score(), is("love all"));
    }

    @Test
    public void test_shouuld_be_fifteen_lovel_when_game_score_1_0() throws Exception {
        setLeftScore(1);
        assertThat(game.score(), is("fifteen love"));
    }

    @Test
    public void test_shouuld_be_thirty_lovel_when_game_score_2_0() throws Exception {
        setLeftScore(2);
        assertThat(game.score(), is("thirty love"));
    }

    @Test
    public void test_shouuld_be_forty_lovel_when_game_score_3_0() throws Exception {
        setLeftScore(3);
        assertThat(game.score(), is("forty love"));
    }

    @Test
    public void test_shouuld_be_love_fifteen_when_game_score_0_1() throws Exception {
        setRightScore();
        assertThat(game.score(), is("love fifteen"));
    }

    @Test
    public void test_shouuld_be_love_thirty_when_game_score_0_2() throws Exception {
        setRightScore();
        setRightScore();
        assertThat(game.score(), is("love thirty"));
    }

    @Test
    public void test_shouuld_be_love_forty_when_game_score_0_3() throws Exception {
        setRightScore();
        setRightScore();
        setRightScore();
        assertThat(game.score(), is("love forty"));
    }

    private void setRightScore() {
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
