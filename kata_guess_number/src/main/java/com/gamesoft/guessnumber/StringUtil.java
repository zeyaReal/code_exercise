package com.gamesoft.guessnumber;

/**
 * Created by zeya on 14-9-27.
 */
public class StringUtil {
    public static int[] convertToIntArray(String str) {
        String[] inputArray = str.trim().split(" +");
        int[] resultArray =new int[inputArray.length];
        for (int i = 0; i <inputArray.length ; i++) {
            resultArray[i] = Integer.parseInt(inputArray[i]);
        }
        return resultArray;
    }
}
