package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class 수식_최대화 {
    public long solution(String expression) {
        final String regExp = "[-+*]";
        List<String> operators = match(expression, regExp);
        List<Long> numbers = Arrays.stream(expression.split(regExp))
                .map(Long::valueOf)
                .collect(Collectors.toList());
        String[][] cases = {{"-", "+", "*"}, {"-", "*", "+"}, {"+", "-", "*"}, {"+", "*", "-"}, {"*", "+", "-"}, {"*", "-", "+"}};

        List<Long> results = new ArrayList<>();

        for (String[] c : cases) {
            List<String> clonedOperators = cloneList(operators);
            List<Long> clonedNumbers = cloneList(numbers);

            for (String op : c) {
                calculate(op, clonedOperators, clonedNumbers);
            }

            results.add(Math.abs(clonedNumbers.get(0)));
        }

        return results.stream()
                .mapToLong(Long::longValue)
                .max()
                .orElseThrow(IllegalArgumentException::new);
    }

    private List<String> match(String text, String regExp) {
        Matcher matcher = Pattern.compile(regExp).matcher(text);
        List<String> list = new LinkedList<>();

        while (matcher.find()) {
            list.add(matcher.group(0));
        }

        return list;
    }

    private void calculate(String target, List<String> operators, List<Long> numbers) {
        while (operators.contains(target)) {
            final int targetIdx = operators.indexOf(target);
            final long left = numbers.get(targetIdx);
            final long right = numbers.get(targetIdx + 1);
            long result = 0;

            switch (target) {
                case "-":
                    result = left - right;
                    break;
                case "+":
                    result = left + right;
                    break;
                case "*":
                    result = left * right;
                    break;
                default:
                    throw new IllegalArgumentException();
            }

            operators.remove(targetIdx);
            numbers.remove(targetIdx);
            numbers.remove(targetIdx);
            numbers.add(targetIdx, result);
        }
    }

    private <T> List<T> cloneList(List<T> list) {
        List<T> clone = new LinkedList<T>();
        clone.addAll(list);
        return clone;
    }
}
