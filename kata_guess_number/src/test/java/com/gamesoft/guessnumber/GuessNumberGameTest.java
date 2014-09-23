package com.gamesoft.guessnumber;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Created by zeya on 14-9-23.
 */
public class GuessNumberGameTest {

    @Test
    public void test_should_return_1A0B_when_input_1567() throws Exception {
        GuessNumberGame game = new GuessNumberGame(new int[]{1,2,3,4});
        assertThat(game.guess(new int[]{1,5,6,7}), is("1A0B"));
    }
}
