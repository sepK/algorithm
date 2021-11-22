package tk.problem;

/**
 * @author t.k
 * @date 2021/4/27 15:08
 */
public class MaxProfit_121 {

    public static int maxProfit(int[] prices) {
        int max = 0;
        int currentMin = prices[0];
        for (int i = 1; i < prices.length; i++) {
            int price = prices[i];
            if (price < currentMin) {
                currentMin = price;
            } else {
                max = Math.max(max, price - currentMin);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] temp = new int[]{7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit(temp));
        temp = new int[]{7, 6, 5, 4, 3, 1};
        System.out.println(maxProfit(temp));
    }
}
