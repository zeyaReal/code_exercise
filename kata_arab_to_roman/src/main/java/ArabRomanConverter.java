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
        if (arabRomanMap.containsKey(number)){
            return arabRomanMap.get(number);
        }

        if (number > arabRomanMap.lastKey()) {
            return "V" + convert(number - 5);
        }

        if (number > 1) {
            return "I" + convert(number -1);
        }

        return "";
    }
}
