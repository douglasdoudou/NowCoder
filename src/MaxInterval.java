import java.util.Scanner;

/**
 * @author zhuyaokunll@foxmail.com
 * @date 2018/8/21 20:27
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
