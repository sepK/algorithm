package tk.algorithm.string;

/**
 * 马拉车算法
 *
 * @author t.k
 * @date 2022/1/18 9:06
 */
public class Manacher {
    /**
     * 用一个数组 P 保存从中心扩展的最大个数，而它刚好也是去掉 "#" 的原回文串的总长度
     * 用 P 的下标 i 减去 P [ i ]，再除以 2 ，就是原字符串的开头下标
     * 用 C 表示回文串的中心，用 R 表示回文串的右边半径。所以 R = C + P[ i ] 。C 和 R 所对应的回文串是当前循环中 R 最靠右的回文串
     * 情况 1：当 i >= maxRight 的时候，这就是一开始，以及刚刚把一个回文子串扫描完的情况，此时只能够根据“中心扩散法”一个一个扫描，逐渐扩大 maxRight；
     * 情况 2：当 i < maxRight 的时候,
     * (1)p[mirror] 的数值比较小，不超过 maxRight - i。由于“以 center 为中心的回文子串”的对称性，导致了“以 i 为中心的回文子串”与“以 center 为中心的回文子串”也具有对称性，“以 i 为中心的回文子串”与“以 center 为中心的回文子串”不能再扩散了，此时，直接把数值抄过来即可，即 p[i] = p[mirror]
     * (2)p[mirror] 的数值恰好等于 maxRight - i。同情况（1）
     * (3)p[mirror] 的数值大于 maxRight - i。同情况（1）
     * 综合以上 3 种情况，当 i < maxRight 的时候，p[i] 可以参考 p[mirror] 的信息，以 maxRight - i 作为参考标准，p[i] 的值应该是保守的，即二者之中较小的那个值： p[i] = min(maxRight - i, p[mirror]);
     */

    public String preProcess(String s) {
        int n = s.length();
        if (n == 0) {
            return "^$";
        }
        StringBuilder ret = new StringBuilder("^");
        for (int i = 0; i < n; i++) {
            ret.append("#").append(s.charAt(i));
        }
        ret.append("#$");
        return ret.toString();
    }

    public String longestPalindrome(String s) {
        String t = preProcess(s);
        int n = t.length();
        int[] p = new int[n];
        int center = 0, maxRight = 0;
        for (int i = 1; i < n - 1; i++) {
            //对称点
            int iMirror = 2 * center - i;
            if (maxRight > i) {
                // 防止超出 R
                p[i] = Math.min(maxRight - i, p[iMirror]);
            } else {
                // 等于 R 的情况
                p[i] = 0;
            }

            // 碰到之前讲的三种情况时候，需要利用中心扩展法
            while (i - 1 - p[i] >= 0 && i + 1 + p[i] < t.length() && t.charAt(i + 1 + p[i]) == t.charAt(i - 1 - p[i])) {
                p[i]++;
            }

            // 判断是否需要更新 R
            if (i + p[i] > maxRight) {
                center = i;
                maxRight = i + p[i];
            }
        }

        // 找出 P 的最大值
        int centerIndex = 0;
        for (int i = 1; i < n - 1; i++) {
            if (p[i] > p[centerIndex]) {
                centerIndex = i;
            }
        }
        //求原字符串下标
        int start = (centerIndex - p[centerIndex]) / 2;
        return s.substring(start, start + p[centerIndex]);
    }
}
