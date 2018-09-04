/**
 * @author zhuyaokunll@foxmail.com
 * @date 2018/9/3 22:20
 *
 * 题目：剑指offer的第57题
 *      打印一个升序数组中和为s的两个数字
 */
public class SumIsS {
    public static void main(String[] args) {
        int[] list = new int[]{1,2,4,7,11,14};
        findTwoNumbersWithSumIsS(list,0,list.length-1,15);
    }
    static void findTwoNumbersWithSumIsS(int[] list,int start,int end,int s)
    {
        int iIndex = start;
        int jIndex = end;
        while(iIndex<jIndex)
        {
            if(list[iIndex]+list[jIndex]>s)
                jIndex--;
            else if(list[iIndex]+list[jIndex]<s)
                iIndex++;
            else{
                System.out.println(list[iIndex++]+" "+list[jIndex--]);
//                break;
            }
        }
    }

    static void findContinuousNumbersWithSumIsS(int[] list,int start,int end,int s)
    {
        int iIndex = start;
        int jIndex = end;
        while(iIndex<jIndex)
        {
            if(list[iIndex]+list[jIndex]>s)
                jIndex--;
            else if(list[iIndex]+list[jIndex]<s)
                iIndex++;
            else{
                System.out.println(list[iIndex++]+" "+list[jIndex--]);
//                break;
            }
        }
    }
}
