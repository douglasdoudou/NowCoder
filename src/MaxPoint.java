import java.util.*;

/**
 * @author zhuyaokunll@foxmail.com
 * @date 2018/8/21 19:48
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
