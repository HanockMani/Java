import java.util.*;

public class ArrayListDemo {
    public static void main(String[] args) {
        List<Integer> nums = new ArrayList<Integer>();
        nums.add(15);
        nums.add(45);
        nums.add(5);
        nums.add(35);

        System.out.println(nums);
        Collections.sort(nums);
        System.out.println(nums);
        
        for(int num: nums){
            System.out.println(num+": "+nums.indexOf(num));
        }
    }
}
