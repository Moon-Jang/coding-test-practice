package programmers;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class 온전한_이진트리 {
    public String solution(String text) {
        // B,D,D,E,A,B
        String[] nodes = text.replaceAll("[\\(\\),\\s]", "").split("");
        // union
        Map<String, String> union = createUnion(nodes);
        String root = findRoot(union);

        if (root.equals("E3")) {
            return "E3";
        }

        if (root.equals("E4")) {
            return "E4";
        }

        if(hasDuplicateParent(nodes)) {
            return "E1";
        }

        if(hasChildrenMoreThanTwo(nodes)) {
            return "E2";
        }

        return "(" + root + generateTree(root, "", union) + ")";
    }

    private boolean hasChildrenMoreThanTwo(String[] nodes) {
        Map<String,Integer> cntByNode = new HashMap<>();

        for (int i = 0; i < nodes.length; i+=2) {
            cntByNode.put(nodes[i], cntByNode.getOrDefault(nodes[i], 0) + 1);
        }

        return cntByNode.values()
                .stream()
                .anyMatch(cnt -> cnt > 2);
    }

    private boolean hasDuplicateParent(String[] nodes) {
        Map<String,Integer> cntByNode = new HashMap<>();

        for (int i = 1; i < nodes.length; i+=2) {
            cntByNode.put(nodes[i], cntByNode.getOrDefault(nodes[i], 0) + 1);
        }

        return cntByNode.values()
                .stream()
                .anyMatch(cnt -> cnt > 1);
    }

    private Map<String, String> createUnion(String[] nodes) {
        Map<String, String> union = new HashMap<>();

        for (String node : nodes) {
            union.put(node, node);
        }

        for (int i = 0; i < nodes.length; i += 2) {
            union.put(nodes[i+1], nodes[i]);
        }

        return union;
    }

    private String findRoot(Map<String, String> union) {
        List<String> roots = union.keySet()
                .stream()
                .filter(key -> union.get(key).equals(key))
                .collect(Collectors.toList());

        if (roots.size() > 1) {
            return "E3";
        }

        if (roots.size() == 0) {
            return "E4";
        }

        return roots.get(0);
    }

    private String generateTree(String current, String result, Map<String, String> union) {
        List<String> children = findChildren(current, union);

        if (children.isEmpty()) {
            return result;
        }

        for (String child : children) {
            result += "(" + child;
            result = generateTree(child, result, union);
            result += ")";
        }

        return result;
    }

    private List<String> findChildren(String parent, Map<String, String> union) {
        return union.keySet()
                .stream()
                .filter(key -> !key.equals(parent))
                .filter(key -> union.get(key).equals(parent))
                .sorted((a,b) -> a.compareTo(b))
                .collect(Collectors.toList());
    }
}

/*
-------------------------------------------------------------------

2. 온전한 이진트리 구하기
   문자열이 주어지면  요건에 맞춰 결과를 리턴 노드의 순서는 A → Z 순서로 진행 함
   제약조건
   → 부모 node가 2개 이상일 경우 "E1" 리턴
        예) input = (A,B) (C,D) (B,D)
   → 자식 node가 3개 이상일 경우 "E2" 리턴
        예) input = (A,B) (B,D) (A,C) (A,E)
   → 최상위 부모가 없는 경우 "E3" 리턴
        예) input = (A,C) (B,C)
   → 순환구조가 될 경우 "E4" 리턴
      예) input = (A,B) (B,D) (A,C) (C,D)

정상적인 이진트리 구조일 경우 아래와 같이 리턴
   예) input = (B,D) (D,E) (A,B) (C,F) (E,G) (A,C)
        output = (A(B(D(E(G))))(C(F)))

-----------------------------------------------------------------
 */
