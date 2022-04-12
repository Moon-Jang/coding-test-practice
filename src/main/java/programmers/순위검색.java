package programmers;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class 순위검색 {
    public int[] solution(String[] info, String[] query) {
        List<Applicant> applicants = Arrays.stream(info)
                .map(Applicant::new)
                .collect(Collectors.toList());

        Index index = new Index();

        for (Applicant applicant : applicants) {

        }

        List<Query> queries = Arrays.stream(query)
                .map(Query::new)
                .collect(Collectors.toList());

        return queries.stream()
                .mapToInt(el -> el.execute(applicants))
                .toArray();
    }

    class Index {
        private final Map<String,List<Applicant>> language = new HashMap<>();
        private final Map<String,List<Applicant>> jobGroup = new HashMap<>();
        private final Map<String,List<Applicant>> position = new HashMap<>();
        private final Map<String,List<Applicant>> soulFood = new HashMap<>();

        public Map<String, List<Applicant>> getLanguage() {
            return language;
        }

        public Map<String, List<Applicant>> getJobGroup() {
            return jobGroup;
        }

        public Map<String, List<Applicant>> getPosition() {
            return position;
        }

        public Map<String, List<Applicant>> getSoulFood() {
            return soulFood;
        }

//        public void add(Applicant applicant) {
//            if (language.isEmpty()) {
//                language.put(applicant.getLanguage(), Arrays.asList(applicant));
//            }
//            language.put(applicant.getLanguage(), )
//        }
    }

    class Applicant {
        private final char[] language;
        private final char[] jobGroup;
        private final char[] position;
        private final char[] soulFood;
        private final int score;

        public Applicant(String infoStr) {
            String[] info = infoStr.split(" ");
            this.language = info[0].toCharArray();
            this.jobGroup = info[1].toCharArray();
            this.position = info[2].toCharArray();
            this.soulFood = info[3].toCharArray();
            this.score = Integer.valueOf(info[4]);
        }

        public char[] getLanguage() {
            return language;
        }

        public char[] getJobGroup() {
            return jobGroup;
        }

        public char[] getPosition() {
            return position;
        }

        public char[] getSoulFood() {
            return soulFood;
        }

        public int getScore() {
            return score;
        }
    }

    class Query {
        private final char[] language;
        private final char[] jobGroup;
        private final char[] position;
        private final char[] soulFood;
        private final int score;
        private static final char ALL = '-';

        public Query(String queryStr) {
            String[] query = queryStr.replaceAll(" and", "").split(" ");
            this.language = query[0].toCharArray();
            this.jobGroup = query[1].toCharArray();
            this.position = query[2].toCharArray();
            this.soulFood = query[3].toCharArray();
            this.score = Integer.valueOf(query[4]);
        }

        public int execute(List<Applicant> applicants) {
            Stream<Applicant> s = applicants.stream();

            s = s.filter(el -> this.score <= el.getScore());

            if (this.language[0] != ALL) {
                s = s.filter(el -> isEqual(this.language, el.getLanguage()));
            }

            if (this.jobGroup[0] != ALL) {
                s = s.filter(el -> isEqual(this.jobGroup, el.getJobGroup()));
            }

            if (this.position[0] != ALL) {
                s = s.filter(el -> isEqual(this.position, el.getPosition()));
            }

            if (this.soulFood[0] != ALL) {
                s = s.filter(el -> isEqual(this.soulFood, el.getSoulFood()));
            }

            return (int) s.count();
        }

        private boolean isEqual(char[] a, char[] b) {
            for (int i = 0; i < a.length; i++) {
                if (a[i] != b[i]) return false;
            }

            return true;
        }
    }
}
