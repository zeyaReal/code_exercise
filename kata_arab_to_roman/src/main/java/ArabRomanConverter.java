/**
 * Created by zeya on 14-10-8.
 */
public class ArabRomanConverter {
    public String convert(int number) {
        String result = "";
        if (number == 5) {
            return "V";
        }

        while (number > 0) {
            result += "I";
            number--;
        }
        return result;
    }
}
