package tk;

/**
 * @author t.k
 * @date 2019/4/9 14:03
 */
public class RobotReturnToOrigin {
    public static boolean judgeCircle(String moves) {
        int x = 0;
        int y = 0;
        for (Character character: moves.toCharArray()) {
            switch (character) {
                case 'U':
                    y++;
                    break;
                case 'D':
                    y--;
                    break;
                case 'L':
                    x--;
                    break;
                case 'R':
                    x++;
                    break;
                default:
                    break;
            }
        }
        return x == 0 && y== 0;
    }

    public static void main(String[] args) {
        System.out.println(judgeCircle("LL"));
    }
}
