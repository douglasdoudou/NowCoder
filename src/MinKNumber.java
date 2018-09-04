import java.util.Arrays;
import java.util.Scanner;

/**
 * @author zhuyaokunll@foxmail.com
 * @date 2018/9/4 12:46
 * 题目：https://www.nowcoder.com/test/question/cc727473d1e248ccb674eb31bd8683dc?pid=3910478&tid=18179143
 *      描述：找出输入的n个数中最小的k个数，升序输出
 *      思路：排序
 */
public class MinKNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] inputList = input.split(" ");
        int[] inputNumber = new int[inputList.length-1];
        for (int i = 0; i < inputList.length-1; i++) {
            inputNumber[i] = Integer.parseInt(inputList[i]);
        }
        int k = Integer.parseInt(inputList[inputList.length-1]);
        Arrays.sort(inputNumber);
        for (int i = 0; i < k; i++) {
            System.out.print(inputNumber[i]);
            if(i!=k-1)
                System.out.print(" ");
        }
    }
}
