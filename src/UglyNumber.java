import java.util.Scanner;

/**
 * @author zhuyaokunll@foxmail.com
 * @date 2018/8/25 22:01
 *
 * 解题思路：丑数（只包含因子2,3,5的正整数）
 *      1、动态规划的思路来做：通过将前面的数字乘以2或3或5获得后面的数字
 *      2、但是整个过程需要输出的是所有丑数中第index大的丑数，所以需要比较前面的数到底是乘以2大还是乘以3大还是乘以5大
 *      3、使用三个指针分别记录上一次用于乘以2 3 5的丑数索引，新的一次，比较他们的下一个位置的元素与2 3 5相乘谁小，下一个丑数就是谁
 *      4、另外还要注意，下面的几个if判断没有使用else，因为例如：6等于2*3 也等于3*2，为了避免重复，都跳过
 */
public class UglyNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println(GetUglyNumber_Solution(n));
    }

    public static int GetUglyNumber_Solution(int index) {
        if(index==0)
            return 0;
        int two = 0;
        int three = 0;
        int five = 0;
        int[] uglyNum = new int[index];
        uglyNum[0]=1;
        for (int i = 1; i < index; i++) {
            uglyNum[i] = Math.min(Math.min(uglyNum[two]*2,uglyNum[three]*3),uglyNum[five]*5);
            if(uglyNum[i]==uglyNum[two]*2)
                two++;
            if(uglyNum[i]==uglyNum[three]*3)
                three++;
            if(uglyNum[i]==uglyNum[five]*5)
                five++;
        }
        return uglyNum[index-1];
    }

}
