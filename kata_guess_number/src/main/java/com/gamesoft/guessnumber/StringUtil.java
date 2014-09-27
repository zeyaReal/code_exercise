package com.gamesoft.guessnumber;

/**
 * Created by zeya on 14-9-27.
 */
public class StringUtil {
    public static int[] convertToIntArray(String str) {
        str = str.trim();
        if (isSpaceSplitterExist(str)) {
            return splitNumberBySpace(str);
        }
        return splitNumberByPosition(str);
    }

    private static boolean isSpaceSplitterExist(String str) {
        return str.indexOf(" ") >= 0;
    }

    private static int[] splitNumberBySpace(String str) {
        String[] inputArray = str.split(" +");
        int[] resultArray = new int[inputArray.length];
        for (int i = 0; i < inputArray.length; i++) {
            resultArray[i] = Integer.parseInt(inputArray[i]);
        }
        return resultArray;
    }

    private static int[] splitNumberByPosition(String str) {
        int[] resultArray = new int[str.length()];
        for (int i = 0; i < resultArray.length; i++) {
            if (!isValidNumberChar(str.charAt(i))) {
                throw new IllegalArgumentException("not a valid input str=" + str);
            }
            resultArray[i] = str.charAt(i) - '0';
        }
        return resultArray;
    }

    private static boolean isValidNumberChar(char ch) {
        return ch >= '0' && ch <= '9';
    }
}
