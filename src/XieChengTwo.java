import java.util.Collections;
        import java.util.HashMap;
        import java.util.Map;
        import java.util.Scanner;

/**
 * @author zhuyaokunll@foxmail.com
 * @date 2018/9/4 19:33
 * 计算KL散度
 */
@SuppressWarnings("Duplicates")
public class XieChengTwo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] pInput = scanner.nextLine().split(" ");
        double[] pp = new double[pInput.length];
        HashMap<Double,Integer> phash = new HashMap<>();
        HashMap<Double,Integer> qhash = new HashMap<>();
        for (int i = 0; i < pInput.length; i++) {
            double temp = Double.parseDouble(pInput[i]);
            pp[i] = temp;
            if(phash.containsKey(temp))
            {
                phash.put(temp,phash.get(temp)+1);
            }else{
                phash.put(temp,1);
            }
        }
        String[] qInput = scanner.nextLine().split(" ");
        double[] qq = new double[qInput.length];
        for (int i = 0; i < qInput.length; i++) {
            double temp = Double.parseDouble(qInput[i]);
            qq[i] =temp;
            if(qhash.containsKey(temp))
            {
                qhash.put(temp,qhash.get(temp)+1);
            }else{
                qhash.put(temp,1);
            }
        }
        double[] pgailv = new double[phash.size()];
        double[] qgailv = new double[qhash.size()];
        int i = 0;
        for(Map.Entry<Double,Integer> one:phash.entrySet())
        {
            pgailv[i] = (double)one.getValue()/pp.length;
            qgailv[i] = (double)qhash.get(one.getKey())/qq.length;
            i =i+1;
        }
        double result = 0.0;
        for(int j=0;j<pgailv.length;j++)
        {
            result  += pgailv[j]*Math.log10(pgailv[j]/qgailv[j])/Math.log10(2);
        }
        System.out.printf("%.2f",result);
    }
}
