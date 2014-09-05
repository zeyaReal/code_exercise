import java.util.ArrayList;
import java.util.List;

/**
 * Created by zeya on 14-9-1.
 */
public class Prime {
    public static List<Integer> factor(int number) {
        ArrayList<Integer> resultList = new ArrayList<Integer>();

        for (int factor = 2; number != 1; factor++) {
            for (; number % factor == 0 ; number /= factor)
                resultList.add(factor);
        }

        return resultList;
    }
}
