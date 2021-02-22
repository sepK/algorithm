import java.util.ArrayList;
import java.util.List;

/**
 * @author t.k
 * @date 2020/6/1 14:17
 */
public class KidsWithCandies {

    public static List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int maxCandy = 0;
        for (int i = 0; i < candies.length; i++) {
            int candy = candies[i];
            maxCandy = maxCandy < candy ? candy : maxCandy;
        }
        List<Boolean> result = new ArrayList<>();
        for (int i = 0; i < candies.length; i++) {
            result.add(candies[i] + extraCandies >= maxCandy);
        }
        return result;
    }

    public static void main(String[] args) {
        List<Boolean> booleans = kidsWithCandies(new int[]{2,3,5,1,3}, 3);
        System.out.println(booleans);
    }
}
