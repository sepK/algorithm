package zhou;

/**给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转
 * 输入: -123
 * 输出: -321
 * @author Blade
 * @date 2020/8/5 15:39
 */
public class ReverseNum {
    /*public static void main(String[] args) {
        int x = 321;
        int y = -123;
        System.out.println(reverse(x));
        System.out.println(reverse(y));
        System.out.println(reverse(-8463847412L));
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);
    }*///测试
    public static int reverse2(long x) {
        long y = Math.abs(x);
        String s1 = y+"";
        StringBuffer sb1 = new StringBuffer(s1);
        sb1 = sb1.reverse();
        long num  = Long.parseLong(sb1.toString());
        if(x>0&&num <= Integer.MAX_VALUE ) {
            return (int) num;
        }else if(x<0 && num-1 <= Integer.MAX_VALUE){
            return -(int) num;
        }else {
            return 0;
        }
    }
    public static int reverse(long x) {
        StringBuffer sb1 = new StringBuffer(Math.abs(x)+"").reverse();
        long num  = Long.parseLong(sb1.toString());
        if(num <= Integer.MAX_VALUE && x>0) {
            return (int) num;
        }else if(x<0 && num-1 <= Integer.MAX_VALUE){
            return -(int) num;
        }else {
            return 0;
        }
    }
}
//num <= -Integer.MIN_VALUE