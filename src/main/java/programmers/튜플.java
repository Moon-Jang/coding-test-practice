package programmers;

import java.util.*;
import java.util.stream.Collectors;

public class 튜플 {
    public int[] solution(String s) {
        List<List<Integer>> tuples = generateTuples(s);
        Set<Integer> visited = new HashSet<>();
        List<Integer> result = new ArrayList<>();

        for (List<Integer> tuple : tuples) {
            for (int element : tuple) {
                if (visited.contains(element)) continue;

                visited.add(element);
                result.add(element);
            }
        }

        return result.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }

    private List<List<Integer>> generateTuples(String str) {
        String[] splitStr = str.substring(1, str.length() - 1).split(",\\{");

        return Arrays.stream(splitStr)
                .map(el -> el.replaceAll("[\\{\\}]", ""))
                .map(el -> Arrays.stream(el.split(","))
                        .map(Integer::valueOf)
                        .collect(Collectors.toList()))
                .sorted((a,b) -> a.size() - b.size())
                .collect(Collectors.toList());
    }
}
