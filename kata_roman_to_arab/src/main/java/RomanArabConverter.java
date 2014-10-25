import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by zeya on 14-10-24.
 */
public class RomanArabConverter {

    private Map<Character, Integer> romanArabMap = new TreeMap<>();

    public RomanArabConverter() {
        romanArabMap.put('I', 1);
        romanArabMap.put('V', 5);
        romanArabMap.put('X', 10);
        romanArabMap.put('L', 50);
        romanArabMap.put('C', 100);
        romanArabMap.put('D', 500);
        romanArabMap.put('M', 1000);
    }

    public int convert(String romanNumber) {

        int result = 0;
        int lastRightArabVal = 0;

        for (int i = romanNumber.length() - 1; i >= 0; i--) {
            int currentArabVal = romanArabMap.get(romanNumber.charAt(i));

            if (currentArabVal < lastRightArabVal) {
                result -= currentArabVal;
            } else {
                result += currentArabVal;
                lastRightArabVal = currentArabVal;
            }
        }
        return result;
    }
}
