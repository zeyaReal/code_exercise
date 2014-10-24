import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by zeya on 14-10-24.
 */
public class RomanArabConverter {

    private Map<String, Integer> romanArabMap = new TreeMap<String, Integer>();

    public RomanArabConverter() {
        romanArabMap.put("I", 1);
        romanArabMap.put("V", 5);
    }

    public int convert(String romanNumber) {

        if (romanNumber.isEmpty()) {
            return 0;
        }

        if (romanNumber.length() == 1) {
            return romanArabMap.get(romanNumber);
        }

        int result = 0;
        for (int i = 0; i < romanNumber.length() - 1; i++) {
            int currentNumber = romanArabMap.get( romanNumber.substring(i,i+1) );
            int nextNumber = romanArabMap.get( romanNumber.substring(i+1, i+2) );

            if (nextNumber > currentNumber) {
                result -= currentNumber;
            } else {
                result += currentNumber;
            }
        }
        result += romanArabMap.get( romanNumber.substring(romanNumber.length()-1) );
        return  result;
    }
}
