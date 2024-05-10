import java.util.*;

public class MapDemo {
    public static void main(String[] args) {
        Map<String, Integer> students = new HashMap<>();
        students.put("Jake", 20);
        students.put("Jake", 78);
        students.put("Jhon", 68);
        students.put("Alen", 90);
        students.put("Akhil", 86);

        System.out.println(students);

        for (String key : students.keySet()) {
            System.out.println(key +": "+students.get(key));
        }
    }
}
