package me;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class 두배열_최소값 {
    public int solution(int[] A, int[] B) {
        Set<Integer> left = Arrays.stream(A)
                .mapToObj(Integer::valueOf)
                .collect(Collectors.toSet());
        Set<Integer> right = Arrays.stream(B)
                .mapToObj(Integer::valueOf)
                .collect(Collectors.toSet());

        return left.stream()
                .filter(el -> right.contains(el))
                .mapToInt(Integer::intValue)
                .min()
                .orElseGet(() -> -1);
    }
}
