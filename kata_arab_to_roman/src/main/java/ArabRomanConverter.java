import java.util.Comparator;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * Created by zeya on 14-10-8.
 */
public class ArabRomanConverter {

    public static final int MAX_ROMAN_NUMBER = 3999;

    private SortedMap<Integer, String> arabRomanMap = new TreeMap<>(Comparator.<Integer>reverseOrder());

    public ArabRomanConverter() {
        arabRomanMap.put(1, "I");
        arabRomanMap.put(4, "IV");
        arabRomanMap.put(5, "V");
        arabRomanMap.put(9, "IX");
        arabRomanMap.put(10, "X");
        arabRomanMap.put(40, "XL");
        arabRomanMap.put(50, "L");
        arabRomanMap.put(90, "XC");
        arabRomanMap.put(100, "C");
        arabRomanMap.put(400, "CD");
        arabRomanMap.put(500, "D");
        arabRomanMap.put(900, "CM");
        arabRomanMap.put(1000, "M");
    }

    public String convert(int number) {
        if (number > MAX_ROMAN_NUMBER) {
            throw new UnsupportedOperationException("too big input! max roman number is 3999. input=" + number);
        }
        return innerConvert(number);
    }

    private String innerConvert(int number) {

        if (number == 0) return "";

        int largestArbicNumberInMappingSmallThanNumber = arabRomanMap.tailMap(number).firstKey();
        return arabRomanMap.get(largestArbicNumberInMappingSmallThanNumber) + innerConvert(number - largestArbicNumberInMappingSmallThanNumber);
    }
}
