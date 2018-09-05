import java.util.Scanner;

/**
 * @author zhuyaokunll@foxmail.com
 * @date 2018/9/4 22:10
 *  题目描述：美团点评2017秋招笔试编程题，第一题，大富翁游戏，掷骰子为n走n步，问玩家走到第n步（n<=骰子最大点数且是方法的唯一入参）时，总共有多少种投骰子的方法
 *  解题思路：
 *      1、动态规划，分别计算n从1到n的值
 *      2、其实很简单，输入为n，对应的输出值为2^(n-1)就行
 */
public class MonopolyGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        switch (n)
        {
            case 1:
                System.out.println(1);
                break;
            case 2:
                System.out.println(2);
                break;
            case 3:
                System.out.println(4);
                break;
            case 4:
                System.out.println(8);
                break;
            case 5:
                System.out.println(16);
                break;
            case 6:
                System.out.println(32);
                break;
        }
    }
}
