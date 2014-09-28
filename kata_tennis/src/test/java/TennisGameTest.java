import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by zeya on 14-9-28.
 */
public class TennisGameTest {
    @Test
    public void test_shouuld_be_lovel_all_when_game_begin() throws Exception {
        TennisGame game = new TennisGame();
        assertThat(game.score(), is("love all"));
    }
}
