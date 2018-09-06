import java.util.*;

/**
 * @author zhuyaokunll@foxmail.com
 * @date 2018/9/5 14:41
 *
 *  题目：美团点评2017秋招笔试编程题，第二题：人民币拼凑
 *  思路：1、动态规划法来做，从前i种人民币组成n元人民币的组合数到前6种
 *       2、result[i][j] = result[i-1][j] + result[i][j-money[i]]
 *       3、用人话说就是：
 *          1、首先对k种货币按面值从小到大排序
 *          2、动态规划法将：采用前1种货币到采用前k种货币 表示目标值（1元到n元）的所有组合全都保存下来，是一个kxn的矩阵
 *          3、那么新增一个货币，面值为coin[i] = j，
 *                              对于小于它面值j的目标值无增益作用；
 *                              对于大于等于它面值j的目标值m的组合数增益为：当前货币条件下的，目标值为：（m-j)的组合数
 *                              增益是在当前目标值的上一个货币条件下进行的
 */
public class RMB {
    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] money = new int[]{1,5,10,20,50,100};
        long[] result = new long[n+1];
        Arrays.fill(result,1);
        for (int i = 1; i < money.length; i++) {
            for (int j = 1; j < n+1; j++) {
                int index = j - money[i];
                if(index>=0)
                    result[j] = result[j] + result[index];
                else
                    result[j] = result[j];
            }
        }
        System.out.println(result[n]);

    }
}
