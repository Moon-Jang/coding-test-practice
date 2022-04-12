package programmers;

import java.util.*;
import java.util.stream.Collectors;

class 신고 {
    public int[] solution(String[] id_list,String[] report,int k) {
        Map<String, Integer> reportCntById = Arrays.stream(id_list)
                .collect(Collectors.toMap(id -> id, i -> 0));
        // 무지: 0, ....

        Map<String, Set<String>> reporters = new LinkedHashMap<String, Set<String>>();

        for (String id : id_list) {
            reporters.put(id, new HashSet<String>());
        }

        // 무지: (홍길동, 라이언), 홍길동: (무지)
        for (String r : report) {
            String[] strArr = r.split(" "); // 무지 라이언
            Set<String> badGuys = reporters.get(strArr[0]); // ()

            if (badGuys.contains(strArr[1])) continue;

            reporters.get(strArr[0]).add(strArr[1]); // 무지: (라이언)
            reportCntById.put(strArr[1], reportCntById.get(strArr[1]) + 1); // 라이언: 1, 무지: 3
        }

        Set<String> badGuys = reportCntById.keySet().stream()
                .filter(key -> reportCntById.get(key) >= k)
                .collect(Collectors.toSet());

        return reporters.keySet().stream()
                .mapToInt(key -> getReportCnt(reporters.get(key), badGuys))
                .toArray();
    }

    private int getReportCnt(Set<String> reportSet, Set<String> badGuys) {
        return (int) reportSet.stream()
                .filter(r -> badGuys.contains(r))
                .count();
    }
}