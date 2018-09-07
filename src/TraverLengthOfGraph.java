import java.util.Scanner;

/**
 * @author zhuyaokunll@foxmail.com
 * @date 2018/9/7 9:43
 *  题目：2019美团算法笔试第一题：给定一个无向图，找到其从第一点开始的最短遍历所有点的路径长度
 *  思路：
 *      1、从点1开始，遍历所有点回到点1，所经历的路径长度为2*(n-1)，n为所有点的个数
 *      2、那么要满足题目要求的，只需要将上述结果减去从1开始的最长路径的长度
 *      3、其实有参考代码（文末注释部分），在其基础上改进了一个小bug
 *
 */
public class TraverLengthOfGraph {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int[] lines = new int[n+1];
        for (int i = 0; i < n-1; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            //这里必须要调整一下，让 a 比 b 小才行
            if(a>b)
            {
                a = a + b;
                b = a - b;
                a = a - b;
            }
            lines[b] = lines[a]+1;
        }
        int maxLength = 0;
        for (int j = 0; j < lines.length; j++) {
            maxLength = lines[j]>maxLength?lines[j]:maxLength;
        }
        System.out.println(2*(n-1)-maxLength);
//        #include<bits/stdc++.h>
//                using namespace std;
//        int lst[999999];
//        int main(){
//            int n;
//            while(cin>>n){
//                memset(lst,0,sizeof(lst));
//                for(int i = 0;i<n-1;i++){
//
//                    int a,b;
//                    cin>>a>>b;
//                    lst[b] = lst[a]+1;
//                }
//                int length = 0;
//                for(int i = 1;i<=n;i++)
//                    length = lst[i]>length?lst[i]:length;
//                cout<<2*n-2-length<<endl;
//            }
//            return 0;
//        }
    }
}
