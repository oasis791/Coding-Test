import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

static class Solution {
    public static String solution(int[] numbers) {
        Comparator<String> comparator = (o1, o2) -> (o2 + o1).compareTo(o1 + o2);
        String[] array = Arrays.stream(numbers).mapToObj(Integer::toString).sorted(comparator).toArray(String[]::new);

        if (array[0].equals("0"))
            return "0";

        return Arrays.stream(array).collect(Collectors.joining());
    }
}
