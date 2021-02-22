import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author t.k
 * @date 2019/6/10 15:52
 */
public class Random {
    public static List<Integer> getList(List<Integer> list, int divNum) {
        List<Integer> array = new ArrayList<>();
        int step = list.size() / divNum;
        java.util.Random random = new java.util.Random();
        for (int index = 1; index <= divNum; index++) {
            array.add(random.nextInt(step * divNum));
        }
        return array;
    }
    private static List<Integer> scoreTimeList = Arrays.asList(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,
            31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,49,50,51,52,53,54,55,56,57,58,59,60,61,62,63,64,65,66,67,68,69,70,71,72,73,74,
            75,76,77,78,79,80,81,82,83,84,85,86,87,88,89,90);
    public static void main(String[] args) {
        List<Integer> list = getList(scoreTimeList, 5);
        Collections.sort(list);
        System.out.println(list);
    }
}
