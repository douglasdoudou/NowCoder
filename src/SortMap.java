import java.util.*;

/**
 * @author zhuyaokunll@foxmail.com
 * @date 2018/8/17 9:38
 */
public class SortMap {
    public static void main(String[] args) {
        Map<String,Integer> hashMap = new HashMap<>();
        hashMap.put("abc",10);
        hashMap.put("ab",10);
        hashMap.put("z",102);
        hashMap.put("b",101);
        hashMap.put("c",5);
        Set<Map.Entry<String,Integer>> set = new TreeSet<>(
                (a,b) -> {
                    if(a.getValue()==b.getValue())
                        return a.getKey().compareTo(b.getKey());
                    else
                        return b.getValue().compareTo(a.getValue());
                });
        for(Map.Entry<String,Integer> one:hashMap.entrySet())
        {
            set.add(one);
        }
        System.out.println();
        TreeMap<String,Integer> treeMap = new TreeMap<>();
        treeMap.put("a",12);
        treeMap.put("va",12);
        treeMap.put("dfsa",12);
        treeMap.put("dfha",12);
        treeMap.put("sdfa",12);
        treeMap.put("dfa",12);
        System.out.println();
    }
}
