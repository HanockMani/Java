import java.util.*;

public class SetDemo {
    public static void main(String[] args) {
        Set<Integer> nums = new HashSet<Integer>();
        Set<Integer> orderedNums = new TreeSet<Integer>();
        
        nums.add(5);
        nums.add(15);
        nums.add(25);
        nums.add(35);

        orderedNums.add(5);
        orderedNums.add(15);
        orderedNums.add(25);
        orderedNums.add(35);

        System.out.println(nums);
        System.out.println(orderedNums);
    }
}
