import java.util.Arrays;
import java.util.Scanner;

/**
 * @author zhuyaokunll@foxmail.com
 * @date 2018/9/7 9:36
 *  题目：2019美团算法笔试第二题：零一反转  输入一个0-1数字串和可翻转的最大个数（将0翻转为1），输出最后得到的最长的全1串的长度
 *  思路：
 *          1、遍历子串，记录到达每一个位置 满足条件的最长字符串的长度
 *          2、输出最大值就行
 *          （本题的做法还有改进的空间，Ac率只有27%）
 */
public class ZeroOneReversal {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String[] inputLine = scanner.nextLine().split(" ");
        int n = Integer.parseInt(inputLine[0]);
        int k = Integer.parseInt(inputLine[1]);
        int[] nlist = new int[n];
        int[] mlist = new int[n];
        for (int i = 0; i < n; i++) {
            nlist[i] = scanner.nextInt();
            mlist[mlist.length-1-i] = nlist[i];
        }
        scanner.close();
        int[] result1 = new int[n+1];
        int[] result2 = new int[n+1];

        ggg(result1,nlist,k);
        ggg(result2,mlist,k);
        Arrays.sort(result1);
        Arrays.sort(result2);
        int result = Math.max(result1[result1.length-1],result2[result2.length-1]);
        System.out.println(result);
    }
    static void ggg(int[] result,int[] nlist,int k)
    {
        int zeroNum = 0;
        for (int i = 0; i < nlist.length; i++) {
            if(nlist[i]==0)
                zeroNum ++;
            if((nlist[i]==1||zeroNum<=k||(i>0&&nlist[i-1]==1))&&zeroNum<=k){
                result[i+1] = result[i]+1;
            }else{
                zeroNum=0;
            }
        }
    }
}
