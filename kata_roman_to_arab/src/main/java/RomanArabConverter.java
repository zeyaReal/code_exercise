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
        romanArabMap.put("IV", 4);
        romanArabMap.put("V", 5);
    }

    public int convert(String romanNumber) {

        if (romanNumber.isEmpty()) {
            return 0;
        }

        if (romanArabMap.containsKey(romanNumber)){
            return romanArabMap.get(romanNumber);
        }

        return 1 + convert(romanNumber.substring(1));
    }
}
