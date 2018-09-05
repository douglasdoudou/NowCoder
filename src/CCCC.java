import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author zhuyaokunll@foxmail.com
 * @date 2018/9/5 20:07
 * 2019浪潮笔试第二题
 * 受到新考古发现的影响，小B最近迷上了考古，帮助考古学家根据已有的发现推测古时的一些建筑结构设计。
 * 最新某个区域中发现了古代祭祀场所的遗址，根据考古学者的研究，该遗址所在时代的祭祀场所通常设计为正多边形，
 * 但场所的大小和多边形角度因规模而异。多边形的每个角上设置有一个柱子，柱子之间通过绳子连接。
 * 新近出土的遗址由于受到破坏的原因，只发现了三个柱子，其余的柱子则湮灭在历史的时间长河中。
 * 根据已知的柱子坐标，考古学者请小B帮忙计算祭祀场所可能的最小面积。
 */
public class CCCC {
    public static void main(String[] args) {
        double PI = 3.1415926;
        Scanner scanner = new Scanner(System.in);
        int T =  Integer.parseInt(scanner.nextLine());
        ArrayList<double[][]> input = new ArrayList<>();
        for (int i = 0; i < T; i++) {
            double[][] temp = new double[3][2];
            for (int j = 0; j < 3; j++) {
                String[] a = scanner.nextLine().split(" ");
                temp[j][0] = Double.parseDouble(a[0]);
                temp[j][1] = Double.parseDouble(a[1]);
            }
            input.add(temp);

        }
        double x1, y1, x2, y2, x3, y3;
        double a, b, c;//a,b,c 为三角形边长；
        double A, B, C;//三角形角度的弧度值
        double r, S;//r 为三角形外接圆半径，S为三角形面积（用海伦公式求）
        double n;//正n边形
        double Sn;//正n边形的面积
        for (int i = 0; i < T; i++) {
            double[][] temp2 = input.get(i);
            x1 = temp2[0][0];
            y1 = temp2[0][1];
            x2 = temp2[1][0];
            y2 = temp2[1][1];
            x3 = temp2[2][0];
            y3 = temp2[2][1];
            a = get_edge(x1, y1, x2, y2);
            b = get_edge(x1, y1, x3, y3);
            c = get_edge(x2, y2, x3, y3);
            //三角形的角度公式cosA =（b2+c2-a2）/（2bc）;
            A = Math.acos((b*b + c*c - a*a) / (2 * b*c));
            B = Math.acos((a*a + c*c - b*b) / (2 * a*c));
            C = Math.acos((a*a + b*b - c*c) / (2 * a*b));
            //求三角形的面积，用海伦公式求解面积
            double p = (a + b + c) / 2;
            S = Math.sqrt(p*(p - a)*(p - b)*(p - c));
            r = a*b*c / 4 / S;
            double temp = gcdx(A, B);
            temp = gcdx(temp, C);
            //求多边形有多少条边，用360度除以每个圆心角的度数即可，而三角形对应的顶角是正多边形圆周角，
            //根据圆周角定理，一条弧所对圆周角等于它所对圆心角的一半，所以这里用PI除以temp
            n = PI / temp;
            Sn = (r*r / 2)*Math.sin(2 * PI / n)*n;//三角形面积公式1/2 absin（A），n个三角形
            System.out.printf("%.6f\n", Sn);
        }
    }
    static double get_edge(double x1, double y1,double x2,double y2){
        return Math.sqrt((x1 - x2)*(x1 - x2) + (y1 - y2)*(y1 - y2));
    }
    static double gcdx(double x, double y)
//辗转相除法求最大公约数，精度为0.001,这里的精度取决于题目中具体n最大是多少，一般去1/n比较合适
//因为弧度PI/n，精度满足这个条件即可。
    {
        while (Math.abs(x)>0.0001&&Math.abs(y)>0.0001)
        {
            if (x > y) { x = x - Math.floor(x / y)*y; }
            else       { y = y - Math.floor(y / x)*x; }
        }
        return x + y;
    }
}
