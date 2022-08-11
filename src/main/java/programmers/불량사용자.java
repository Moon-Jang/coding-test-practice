package programmers;


import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

class 불량사용자 {
    public int solution(String[] user_id, String[] banned_id) {
        List<Pattern> patterns = Arrays.stream(banned_id) // f*d*o
                .map(el -> el.replaceAll("\\*", "\\\\w"))
                .map(Pattern::compile)
                .collect(Collectors.toList());

        List<List<Integer>> list = patterns.stream() // f\wd\wo
                .map(el -> getMatchIndex(user_id, el))
                .collect(Collectors.toList());

        Set<Set<Integer>> result = new HashSet<>();

        search(0, list, new boolean[user_id.length], result);

        return result.size();
    }


    private void search(int depth, List<List<Integer>> list, boolean[] visited, Set<Set<Integer>> result) {
        if (depth >= list.size()) {
            result.add(getSetFromVisited(visited));
            return;
        }

        for (Integer el : list.get(depth)) {
            if (visited[el]) continue;

            visited[el] = true;
            search(depth + 1, list, visited, result);
            visited[el] = false;
        }
    }

    private Set<Integer> getSetFromVisited(boolean[] visited) {
        Set<Integer> list = new HashSet<>();

        for (int i = 0; i < visited.length; i++) {
            if (!visited[i]) continue;

            list.add(i);
        }

        return list;
    }

    private List<Integer> getMatchIndex(String[] user_id, Pattern pattern) {
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < user_id.length; i++) {
            final boolean isMatch = pattern.matcher(user_id[i]).matches();

            if (!isMatch) continue;

            result.add(i);
        }

        return result;
    }
}
