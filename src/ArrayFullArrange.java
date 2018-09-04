/**
 * @author zhuyaokunll@foxmail.com
 * @date 2018/8/28 11:14
 */
public class ArrayFullArrange {
    public static void main(String[] args) {
        char[] list = new char[]{'a','b','c','b'};
        perm(list,0,list.length-1);
    }
    static boolean isSwap(char[] list, int begin, int end) {
        for (int i = begin; i < end; i++){
            if (list[i] == list[end])
                return false;
        }
        return true;
    }
    static void perm(char[] list, int i, int n){
        int j, temp;
        if (i == n) {
            for (int k = 0; k < list.length; k++) {
                System.out.print(list[k]+" ");
            }
            System.out.println();
        }
        else {
            for (j = i; j <= n; j++){
                if (isSwap(list, i, j)) {
                    //使用宏定义，传的是数值，如果这的swap用函数实现，传的应该是指针
                    swap(list, i, j);
                    //交互位置后，输出以list[j]不变，后面的字母改变的所有排列
                    perm(list, i + 1, n);
                    swap(list, i, j);
                }
            }
        }
    }
    static void swap(char[] arr,int a,int b)
    {
        char temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

}
