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
        //测试使用set和collections的sort方法进行排序，使用一个数据结构将hashmap的keyset拿出来，对它进行排序，最后遍历map的时候按照keyset的顺序来遍历就行
        List<String> mapKey = new ArrayList<>(hashMap.keySet());
        Collections.sort(mapKey);
        System.out.println();

        //测试使用set对hashMap进行排序，具体是将hashmap中的每一个entry拿出来放到list中，使用Collections.sort对list进行排序
        List<Map.Entry<String,Integer>> set = new ArrayList<Map.Entry<String,Integer>>(hashMap.entrySet());
        Collections.sort(set,(a,b) -> {
            //主排序按照map中的值降序排序
            //次排序按照map的键值升序排序
            if(a.getValue()==b.getValue())
                return a.getKey().compareTo(b.getKey());
            else
                return b.getValue().compareTo(a.getValue());
        });
        System.out.println();

        //测试使用TreeMap的key自然升序排列
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
