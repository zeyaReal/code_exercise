package com.gamesoft.guessnumber;

import org.hamcrest.CoreMatchers;
import org.hamcrest.Matcher;
import org.junit.Test;
import org.mockito.InOrder;
import org.mockito.Mockito;
import org.mockito.internal.util.reflection.Whitebox;

import java.util.Random;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by zeya on 14-9-25.
 */
public class RandomAnswerGeneratorTest {

    @Test
    public void test_should_generator_0_1_2_3_with_random_int_0_0_0_0() throws Exception {
        RandomAnswerGenerator gameAnswerGenerator = new RandomAnswerGenerator();
        Random mockRandom = mock(Random.class);
        Whitebox.setInternalState(gameAnswerGenerator, "random", mockRandom);
        when(mockRandom.nextInt(9)).thenReturn(0);
        when(mockRandom.nextInt(8)).thenReturn(0);
        when(mockRandom.nextInt(7)).thenReturn(0);
        when(mockRandom.nextInt(6)).thenReturn(0);

//        assertThat(gameAnswerGenerator.randomGenerate(),  array(new int[]{1, 2, 3, 4}));
        assertArrayEquals(gameAnswerGenerator.randomGenerate(), new int[]{0, 1, 2, 3});

        InOrder inOrder = Mockito.inOrder(mockRandom);
        inOrder.verify(mockRandom).nextInt(9);
        inOrder.verify(mockRandom).nextInt(8);
        inOrder.verify(mockRandom).nextInt(7);
        inOrder.verify(mockRandom).nextInt(6);
    }

    @Test
    public void test_should_generator_1_0_3_2_with_random_int_1_0_1_0() throws Exception {
        RandomAnswerGenerator gameAnswerGenerator = new RandomAnswerGenerator();
        Random mockRandom = mock(Random.class);
        Whitebox.setInternalState(gameAnswerGenerator, "random", mockRandom);
        when(mockRandom.nextInt(9)).thenReturn(1);
        when(mockRandom.nextInt(8)).thenReturn(0);
        when(mockRandom.nextInt(7)).thenReturn(1);
        when(mockRandom.nextInt(6)).thenReturn(0);

//        assertThat(gameAnswerGenerator.randomGenerate(),  array(new int[]{1, 2, 3, 4}));
        assertArrayEquals(gameAnswerGenerator.randomGenerate(), new int[]{1, 0, 3, 2});

        InOrder inOrder = Mockito.inOrder(mockRandom);
        inOrder.verify(mockRandom).nextInt(9);
        inOrder.verify(mockRandom).nextInt(8);
        inOrder.verify(mockRandom).nextInt(7);
        inOrder.verify(mockRandom).nextInt(6);
    }
}
