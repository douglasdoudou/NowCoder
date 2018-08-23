import java.util.Scanner;

/**
 * @author zhuyaokunll@foxmail.com
 * @date 2018/8/23 21:20
 *
 * 解题思路：
 *      1、首先，读懂题目很重要
 *      2、但是这道题总是不能AC
 */
public class Preference {
    static class Node{
        int l;
        int r;
        int k;
        Node(int l,int r,int k)
        {
            this.l = l;
            this.r = r;
            this.k = k;

        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int[] prefer = new int[n+1];
        String[] preferString = scanner.nextLine().split(" ");
        for (int i = 1; i < prefer.length; i++) {
            prefer[i] = Integer.parseInt(preferString[i-1]);
        }
        int m = scanner.nextInt();
        int l,r,k;
        for (int i = 0; i < m; i++) {
            System.out.println(count( new Node(scanner.nextInt(),scanner.nextInt(),scanner.nextInt()),prefer));
        }
    }

    private static int count(Node node, int[] prefer) {
        int count = 0;
        for(int l=node.l;l<=node.r;l++)
        {
            if(node.k==prefer[l])
                count++;
        }
        return count;
    }
}
