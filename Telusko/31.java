import java.util.Map;
import java.util.HashMap;

class Demo{
    public static void main(String a[]){
        Map<String, Integer> students = new HashMap<>();
        // other than HashMap we also have HashTable
        // to use HashTable here just replace HashMap by HashTable everything else remains the same
        // HashTable is synchronized and thread safe by default
        // HashMap can also be made thread safe by adding the synchronized keyword manually

        students.put("AJ",234);
        students.put("AS",231);
        students.put("BV",232);

        System.out.println(students);
        System.out.println(students.get("AS"));
        for(String name:students.keySet()){//gives all the keys
            System.out.println(name+":"+students.get(name));
        }
    }
}