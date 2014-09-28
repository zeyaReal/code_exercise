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
        game.leftWin();
        assertThat(game.score(), is("fifteen love"));
    }

}
