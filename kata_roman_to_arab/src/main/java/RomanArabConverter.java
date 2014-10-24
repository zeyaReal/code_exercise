/**
 * Created by zeya on 14-10-24.
 */
public class RomanArabConverter {
    public int convert(String romanNumber) {

        if (romanNumber.isEmpty()) {
            return 0;
        }

        if (romanNumber.equals("I")) {
            return 1;
        }

        return 1 + convert(romanNumber.substring(1));
    }
}
