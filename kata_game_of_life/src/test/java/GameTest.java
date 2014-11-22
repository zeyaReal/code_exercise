import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by zeya on 14/11/20.
 */
public class GameTest {

    private Game game;

    @Before
    public void setUp() {
        int[][] world = new int[][]{
                {0,1,0,1},
                {0,1,1,1},
                {1,1,0,1},
                {1,0,0,1}
        };
        game = new Game(world);
    }

    @Test
    public void test_cell_0_0_is_dead() throws Exception {
        assertThat(game.isAlive(0, 0), is(false));
    }

    @Test
    public void test_cell_1_1_is_alive() throws Exception {
        assertThat(game.isAlive(1, 1), is(true));
    }

    @Test
    public void test_cell_$1_$2_is_dead() throws Exception {
        assertThat(game.isAlive(-1,-1), is(false));
    }

    @Test
    public void test_cell_4_4_is_dead() throws Exception {
        assertThat(game.isAlive(4,4),is(false));
    }

    @Test
    public void test_cell_3_1_is_alive_after_evolve_for_3_neighbours() throws Exception {
        game.evolve();
        assertThat(game.isAlive(3,1), is(true));
    }

    @Test
    public void test_cell_1_2_is_dead_after_evolve_for_too_crowd() throws Exception {
        game.evolve();
        assertThat(game.isAlive(1,2), is(false));
    }

    @Test
    public void test_cell_3_3_is_dead_after_evolve_for_too_lonely() throws Exception {
        game.evolve();
        assertThat(game.isAlive(3,3), is(false));
    }

}
