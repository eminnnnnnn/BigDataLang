import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

// Задана коллекция чисел. Разделить числа на четные и нечетные.

public class Lab91 {
    public static void main(String[] args) {
        Collection<Integer> nums = Arrays.asList(3, 5, 8, 10, 7, 6, 5, 5);
        System.out.println("Исходная коллекция чисел: " + Arrays.toString(nums.toArray()));

        Map<Boolean, List<Integer>> oddAndEven = nums.stream().collect(Collectors.partitioningBy((p) -> p % 2 == 0));
        System.out.println("Четные: " + oddAndEven.get(true));
        System.out.println("Нечетные: " + oddAndEven.get(false));
    }
}