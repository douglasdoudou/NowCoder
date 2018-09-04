import java.util.Scanner;

/**
 * @author zhuyaokunll@foxmail.com
 * @date 2018/9/4 10:51
 * 题目：https://www.nowcoder.com/question/next?pid=3910478&qid=68216&tid=18179143
 *      描述：找出输入字符串中最长的连续数字串
 *      思路：通过两个指针的移动来找
 *      结果：花了40分钟写出来
 */
public class MaxLengthNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String  input = scanner.nextLine();
        String result = findMaxContinuousNumers(input);
        System.out.println(result);
    }

    private static String findMaxContinuousNumers(String input) {
        int maxLength = 0;
        char[] chars = input.toCharArray();
        int finalStartIndex = -1;
        int finalEndIndex = -1;
        int startIndex = 0;
        int endIndex = 0;
        for (int i = 0; i < chars.length; i++) {
            char temp = chars[i];
            if(temp>='0'&&temp<='9'){
                endIndex++;
            }else{
                startIndex = i+1;
                endIndex = startIndex;
            }
            int tempMaxLength = Math.max(maxLength,endIndex-startIndex);
            if(tempMaxLength!=maxLength)
            {
                finalStartIndex = startIndex;
                finalEndIndex = endIndex;
                maxLength = tempMaxLength;
            }
        }
        if(finalStartIndex<0||finalStartIndex>chars.length||finalEndIndex>chars.length)
            return "";
        return input.substring(finalStartIndex,finalEndIndex);
    }
}
