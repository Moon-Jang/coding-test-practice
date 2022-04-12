package me;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class 배열_음수양수_최소값 {
    public int solution(int[] arr) {
        Map<Integer,Integer> map = new HashMap<>();

        for(int element : arr) {
            final int num = Math.abs(element);
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        return map.keySet()
                .stream()
                .filter(key -> map.get(key).equals(2))
                .mapToInt(Integer::intValue)
                .max()
                .orElseGet(() -> -1);
    }
}
