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
    }

    public int convert(String romanNumber) {

        if (romanNumber.isEmpty()) {
            return 0;
        }

        int result = romanArabMap.get( romanNumber.charAt(romanNumber.length()-1) );

        for (int i = 0; i < romanNumber.length() - 1; i++) {
            int currentNumber = romanArabMap.get( romanNumber.charAt(i) );
            int rightNumber = romanArabMap.get( romanNumber.charAt(i+1) );

            if (rightNumber > currentNumber) {
                result -= currentNumber;
            } else {
                result += currentNumber;
            }
        }
        return  result;
    }
}
