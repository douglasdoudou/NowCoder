import java.util.HashSet;
import java.util.Set;

/**
 * @author zhuyaokunll@foxmail.com
 * @date 2018/9/2 19:58
 *
 * 解题思路：动态规划法：从第一个开始，考察以第i个结尾的子串是否满足条件，并存储到数组里面
 *      考察以第i（i从0到length-1）个结尾的子串是否满足条件 具体做法：
 *      1、从第j(0<=j<=i)个元素开始，将[0,i]分为[0,j-1]和[j,i]
 *      2、前半部分默认已经判断过是否满足，存到布尔数组里面了（第i个位置代表[0,i]能够组成dict中的一个单词
 *      3、后半部分只要在set中就行
 */
@SuppressWarnings("Duplicates")
public class WordBreak {
    public static void main(String[] args) {
        Set<String> dict = new HashSet<>();
        dict.add("cat");
        dict.add("cats");
        dict.add("and");
        dict.add("sand");
        dict.add("dog");
        String s = "catsanddog";

        System.out.println(wordBreak2(s,dict));
        System.out.println("sdfhksd".substring(6,7));
    }

    public static boolean wordBreak(String s, Set<String> dict) {
        if(s==null||s.length()==0||dict==null)
            return false;
        boolean[] isRight = new boolean[s.length()];
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j <=i; j++) {
                String temp = s.substring(j,i+1);
                if(j>0)
                {
                    if(isRight[j-1]&&dict.contains(temp))
                        isRight[i] = true;
                }else
                {
                    if(dict.contains(temp))
                        isRight[i] = true;
                }

            }
        }
        return isRight[s.length()-1];
    }

    /**
     * 解题思路：动态规划法：从第一个开始，考察以第i个结尾的子串是否满足条件，并存储到数组里面
     *  *      考察以第i（i从1到length）个结尾的子串是否满足条件 具体做法：
     *  *      1、从第j(0<=j<i)个元素开始，将[0,i-1]分为[0,j-1]和[j,i-1]
     *  *      2、前半部分默认已经判断过是否满足，存到布尔数组里面了（第i个位置代表[0,i-1]能够组成dict中的一个单词
     *  *      3、后半部分只要在set中就行
     * @param s
     * @param dict
     * @return
     */
    public static boolean wordBreak2(String s, Set<String> dict) {
        if(s==null||s.length()==0||dict==null)
            return false;
        boolean[] isRight = new boolean[s.length()+1];
        isRight[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j <i; j++) {
                String temp = s.substring(j,i);
                if(isRight[j]&&dict.contains(temp))
                    isRight[i] = true;

            }
        }
        return isRight[s.length()];
    }
}
