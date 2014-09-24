package com.gamesoft.guessnumber;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Created by zeya on 14-9-23.
 */
public class GuessNumberGameTest {

    private GuessNumberGame game;

    @Before
    public void setUp() {
        game = new GuessNumberGame(new int[]{1,2,3,4});
    }

    @Test
    public void test_should_return_1A0B_when_input_1567() throws Exception {
        assertThat(game.guess(new int[]{1,5,6,7}), is("1A0B"));
    }

    @Test
    public void test_should_return_2A0B_when_input_1267() throws Exception {
        assertThat(game.guess(new int[]{1,2,6,7}), is("2A0B"));
    }

    @Test
    public void test_should_return_3A0B_when_input_1237() throws Exception {
        assertThat(game.guess(new int[]{1,2,3,7}), is("3A0B"));
    }

    @Test
    public void test_should_return_4A0B_when_input_1234() throws Exception {
        assertThat(game.guess(new int[]{1, 2, 3, 4}), is("4A0B"));
    }

    @Test
    public void test_should_return_0A1B_when_input_5170() throws Exception {
        GuessNumberGame game = new GuessNumberGame(new int[]{1,2,3,4});
        assertThat(game.guess(new int[]{5,1,7,0}), is("0A1B"));
    }

    @Test
    public void test_should_return_1A2B_when_input_5132() throws Exception {
        GuessNumberGame game = new GuessNumberGame(new int[]{1,2,3,4});
        assertThat(game.guess(new int[]{5,1,3,2}), is("1A2B"));
    }


}
