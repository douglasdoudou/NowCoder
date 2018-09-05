/**
 * @author zhuyaokunll@foxmail.com
 * @date 2018/9/5 15:13
 *  堆排序
 *  注意事项：
 *      1、shiftDown的地方，需要注意，全程是与刚刚传进来的arr[i]比较，
 *         并且i的值会有更新，所以需要用temp将其保存
 *         所以全程比较的话，需要与temp进行比较
 *      2、swap操作，不应该只是把arr[i]和arr[j]传过去，还需要将arr数组的引用传过去，才能达到交换的效果
 */
public class HeapSort {
    public static void main(String[] args) {
        int[] list = new int[]{2,3,456,67,234,678,43,4,34,78,9,56,234,567,2,34,12,36};
        heapSort(list);
        System.out.println();
    }
    public static void heapSort(int[] arr)
    {
        int n = arr.length;
        for(int i = (n-1-1)/2;i>=0;i--)
        {
            shiftDown(arr,n,i);
        }
        for (int i = n-1; i > 0 ; i--) {
//            swap(arr,0,i);
            swap2(arr[0],arr[i]);
            shiftDown(arr,i,0);
        }
    }

    private static void swap(int[] arr,int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    private static void swap2(int i, int j) {
        int temp = i;
        i = j;
        j = i;
    }

    private static void shiftDown(int[] arr, int n, int i) {
        int temp = arr[i];
        while(2*i+1<n)
        {
            int sonMaxIndex = 2*i+1;
            if(sonMaxIndex+1<n&&arr[sonMaxIndex+1]>arr[sonMaxIndex])
                sonMaxIndex += 1;
            if(temp>=arr[sonMaxIndex])
                break;
            arr[i] = arr[sonMaxIndex];
            i = sonMaxIndex;
        }
        arr[i] = temp;
    }
}
