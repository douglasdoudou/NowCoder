import java.util.*;

/**
 * @author zhuyaokunll@foxmail.com
 * @date 2018/8/21 19:48
 *
 * 解题思路：
 *       1、将点存为x, y ; 注意最后的输出是按照x由小到大，y由大到小排列
 *       2、将点按照：优先 y 升序排列，x 降序排列
 *       3、从后向前打印；先打印最后一个，并用max存储最后一个的x，然后向上遍历，满足x>max的就打印，并且更新max的值
 *
 * eg：
 *       输入：
 *       5
 *       1 2
 *       4 6
 *       5 3
 *       7 5
 *       9 0
 *       排序后：
 *       9 0
 *       1 2
 *       5 3
 *       7 5
 *       4 6
 *       期望输出：
 *       4 6
 *       7 5
 *       9 0
 */
public class MaxPoint {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        ArrayList<Integer[]> weizhi = new ArrayList<Integer[]>();
        for (int i = 0; i < n; i++) {
            String[] temp = scanner.nextLine().split(" ");
            Integer[] tempList = new Integer[2];
            tempList[0] = Integer.parseInt(temp[0]);
            tempList[1] = Integer.parseInt(temp[1]);
            weizhi.add(tempList);
        }
        //将数组按照o1[1]优先升序排列，o1[0]次降序排列
        //若o1[0]-o2[0]>0，则将o1[0]和o2[0]交换
        Collections.sort(weizhi, (o1, o2) -> o1[1]==o2[1]?o1[0]-o2[0]:o2[1]-o1[1]);
        System.out.println(weizhi.get(0)[0]+" "+weizhi.get(0)[1]);
        int max = weizhi.get(0)[0];
        for (int i = 1; i < weizhi.size(); i++) {
            if(weizhi.get(i)[0]>max)
            {
                System.out.println(weizhi.get(i)[0]+" "+weizhi.get(i)[1]);
                max = weizhi.get(i)[0];
            }
        }
    }
}
