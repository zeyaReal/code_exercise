import java.util.SortedMap;
import java.util.TreeMap;

/**
 * Created by zeya on 14-10-8.
 */
public class ArabRomanConverter {

    private SortedMap<Integer,String> arabRomanMap = new TreeMap<>();

    public ArabRomanConverter() {
        arabRomanMap.put(1, "I");
        arabRomanMap.put(4, "IV");
        arabRomanMap.put(5, "V");
    }

    public String convert(int number) {
        return convertFromMap(number, arabRomanMap);
    }

    private String convertFromMap(int number, SortedMap<Integer, String> currentArabRomanMap) {
        if (currentArabRomanMap.containsKey(number)){
            return currentArabRomanMap.get(number);
        }

        if (currentArabRomanMap.isEmpty()){
            return "";
        }

        if (number > currentArabRomanMap.lastKey()) {
            return currentArabRomanMap.get(currentArabRomanMap.lastKey()) + convertFromMap(number - currentArabRomanMap.lastKey(), currentArabRomanMap);
        }

        return convertFromMap(number, currentArabRomanMap.headMap(currentArabRomanMap.lastKey()));
    }
}
