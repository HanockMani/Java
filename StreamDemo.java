import java.util.*;
import java.util.stream.Stream;

public class StreamDemo{
    public static void main(String[] args) {
        
        List<Integer> nums = Arrays.asList(5, 6, 3, 8, 2, 4, 1);

        nums.forEach(n -> System.out.println(n));

        // Stream<Integer> s1 = nums.stream();
        // Stream<Integer> s2 = s1.filter(n -> n%2==0);       
        // Stream<Integer> s3 = s2.map(n -> n*2);
        // int result= s3.reduce(0, (c,e) -> c+e);

        int result = nums.stream().filter(n -> n%2==0).map(n->n*2).reduce(0, (c,e) -> c+e);
        System.out.println(result);

        Stream<Integer> sortedValues = nums.stream().filter(n -> n%2==0).sorted();
        sortedValues.forEach(n -> System.out.println(n));
    }
}