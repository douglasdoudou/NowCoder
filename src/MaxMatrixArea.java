import java.util.Arrays;
import java.util.Scanner;

/**
 * @author zhuyaokunll@foxmail.com
 * @date 2018/9/5 21:40
 *  题目：美团点评2017秋招笔试编程题——第三题
 *       给定一组非负整数组成的数组h，代表一组柱状图的高度，
         其中每个柱子的宽度都为1。 在这组柱状图中找到能组成的最大矩形的面积
         入参h为一个整型数组，代表每个柱子的高度，返回面积的值。
 */
public class MaxMatrixArea {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int[] input = new int[n];
        int minIndex = 0;
        int minValue = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            input[i] = scanner.nextInt();
            minIndex = input[i]<minValue?i:minIndex;
            minValue = input[i]<minValue?input[i]:minValue;
        }
        System.out.println(loop(input));
    }

    /**
     * 递归实现：首先找到数组中最小的元素，计算以他为高度的矩阵的面积
     *          其次，找到其右边的最大面积，左边最大面积，
     *          最后，挑选其中最大的
     * @param input
     * @return
     */
    static int recursive(int[] input)
    {
        return getMaxArea(input,0,input.length-1);
    }

    /**
     * 循环思路：遍历数组每一个元素 i ，找到：以元素 i 为开始，结尾为 i 到数组结尾中最大的矩阵，即为所求
     * @param input
     * @return
     */
    static int loop(int[] input)
    {
        int max = 0;
        for (int i = 0; i < input.length; i++) {
            int minValue = input[i];
//            max = Math.max(max,minValue);
            for (int j = i; j < input.length; j++) {
                minValue = Math.min(minValue,input[j]);
                max = Math.max(max,(j-i+1)*minValue);
            }
        }
        return max;
    }

    private static int getMaxArea(int[] input, int start, int end) {
        int minIndex = findMinIndex(input,start,end);
        int maxArea = input[minIndex]*(end-start+1);
        int leftArea = getMaxArea(input, 0,minIndex-1);
        int rightArea = getMaxArea(input, minIndex+1,end);
        return Math.max(maxArea,Math.max(leftArea,rightArea));
    }

    private static int findMinIndex(int[] input, int start, int end) {
        if(start>=end)
            return start;
        int minValue = Integer.MAX_VALUE;
        int minIndex = end;
        for (int i = start; i <= end ; i++) {
            if(input[i]<minValue)
            {
                minIndex = i;
                minValue = input[i];
            }
        }
        return minIndex;
    }
}
