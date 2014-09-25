package com.gamesoft.guessnumber;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by zeya on 14-9-25.
 */
public class RandomAnswerGenerator {

    private Random random = new Random();

    public int[] randomGenerate() {
        ArrayList<Integer> baseDatas = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            baseDatas.add(i);
        }

        int[] result = new int[4];
        for (int i = 0; i < result.length; i++) {
            int randomIndex = random.nextInt(baseDatas.size());
            result[i] = baseDatas.remove(randomIndex);
        }

        return result;
    }
}
