/**
 * Created by zeya on 14-10-24.
 */
public class RomanArabConverter {
    public int convert(String romanNumber) {
        int result = 0;
        if (romanNumber.equals("III")){
           result = 1 + convert(romanNumber.substring(1));
           return result;
        }

        if (romanNumber.equals("II")){
            result = 1 + convert(romanNumber.substring(1));
            return result;
        }
        return 1;
    }
}
