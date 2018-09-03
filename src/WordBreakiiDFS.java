import java.util.*;

/**
 * @author zhuyaokunll@foxmail.com
 * @date 2018/9/2 21:14
 *
 * 解题思路：回溯法：找到第一个单词，接着去找剩下的是否符合，不符合就放弃那个单词
 */
public class WordBreakiiDFS {
    public static void main(String[] args) {
        Set<String> dict = new HashSet<>();
        dict.add("cat");
        dict.add("cats");
        dict.add("and");
        dict.add("sand");
        dict.add("dog");
        String s = "catsanddog";
        List<String> result = wordBreak(s,dict);
        System.out.println();
    }
    public static ArrayList<String> wordBreak(String s, Set<String> wordDict) {
        ArrayList<String> res = new ArrayList<String>();

        // 用来记录s.substring(i)这个字符串能否分解
        boolean[] possible = new boolean[s.length() + 1];
        Arrays.fill(possible, true);
        dfs(res, "", s, wordDict,  0, possible);
        return res;
    }

    public static void dfs(List<String> res, String cur, String s, Set<String> wordDict, int start, boolean[] possible) {
        if (start == s.length()) {
            res.add(cur);
            return;
        }
        for (int i = start + 1; i <= s.length(); i++) {
            String str = s.substring(start, i);
            if (wordDict.contains(str) && possible[i]) {
                int prevSize = res.size();
                dfs(res, cur + (cur.equals("") ? "" : " ") + str, s, wordDict, i, possible);

                // DFS后面部分结果没有变化，说明后面是没有解的
                if (res.size() == prevSize)
                    possible[i] = false;
            }
        }
    }
}
