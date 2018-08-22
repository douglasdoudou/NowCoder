import java.util.Scanner;

/**
 * @author zhuyaokunll@foxmail.com
 * @date 2018/8/21 20:27
 * 题目描述：P为给定的二维平面整数点集。定义 P 中某点x，如果x满足 P 中任意点都
 *         不在 x 的右上方区域内（横纵坐标都大于x），则称其为“最大的”。求出所有“最大的”
 *         点的集合。（所有点的横坐标和纵坐标都不重复, 坐标轴范围在[0, 1e9) 内）
 * 解题思路：
 *        由于具体的值是由min*sum得到的，所以，可以不断更换min的值来找到最优解
 *        1、读取数组的时候，计算sum值、寻找min值、记录min值的索引minIndex
 *        2、将数组分为  [start,minIndex-1]  和  [minIndex+1,end]，再去按照上述方法寻找min*sum，与之前的最大值比较
 *        3、注意递归的结束条件
 */
public class MaxInterval {
    private static int max;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int[] input = new int[n];
        int totalSum = 0,min=0;
        for (int i = 0; i < n; i++) {
            input[i] = scanner.nextInt();
            totalSum += input[i];
            if(input[i]<input[min])
                min = i;
        }
        max = totalSum*input[min];
        partition(input,0,input.length-1,min);
        System.out.println(max);
    }

    private static void partition(int[] input, int start, int end, int minIndex) {
        if(minIndex<start||minIndex>end||start>end)
            return;
        //计算[start,minIndex-1]区间的值
        int localMinIndex = start;
        int min = input[localMinIndex];
        int sum = input[localMinIndex];
        for (int i = start+1; i <=minIndex-1 ; i++) {
            sum+=input[i];
            if(input[i]<min) {
                min = input[i];
                localMinIndex = i;
            }
        }
        int localMax = min*sum;
        if(localMax>max)
            max = localMax;
        partition(input,start,minIndex-1,localMinIndex);
        localMinIndex = end;
        min = input[localMinIndex];
        sum = input[localMinIndex];
        for (int i = end-1; i >minIndex ; i--) {
            sum+=input[i];
            if(input[i]<min){
                min = input[i];
                localMinIndex = i;
            }
        }
        localMax = min*sum;
        if(localMax>max)
            max = localMax;
        partition(input,minIndex+1,end,localMinIndex);
    }
}
