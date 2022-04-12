package programmers;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class 순위검색2 {
    public int[] solution(String[] info, String[] query) {
        List<Applicant> applicants = new ArrayList<>();

        for (int i = 0; i < info.length; i++) {
            applicants.add(new Applicant(i, info[i]));
        }

        Index index = new Index();

        for (Applicant applicant: applicants) {
            index.add(applicant);
        }

        List<Query> queries = Arrays.stream(query)
                .map(Query::new)
                .collect(Collectors.toList());

        return queries.stream()
                .mapToInt(el -> el.execute(applicants, index))
                .toArray();
    }

    class Index {
        private final Map<String,Set<Integer>> language = new HashMap<>();
        private final Map<String,Set<Integer>> jobGroup = new HashMap<>();
        private final Map<String,Set<Integer>> position = new HashMap<>();
        private final Map<String,Set<Integer>> soulFood = new HashMap<>();

        public Map<String, Set<Integer>> getLanguage() {
            return language;
        }

        public Map<String, Set<Integer>> getJobGroup() {
            return jobGroup;
        }

        public Map<String, Set<Integer>> getPosition() {
            return position;
        }

        public Map<String, Set<Integer>> getSoulFood() {
            return soulFood;
        }

        public void add(Applicant applicant) {
            if (language.get(applicant.getLanguage()) == null) {
                Set<Integer> set = new HashSet<>();
                set.add(applicant.getIdx());
                language.put(applicant.getLanguage(), set);
            } else {
                language.get(applicant.getLanguage()).add(applicant.getIdx());
            }

            if (jobGroup.get(applicant.getJobGroup()) == null) {
                Set<Integer> set = new HashSet<>();
                set.add(applicant.getIdx());
                jobGroup.put(applicant.getJobGroup(), set);
            } else {
                jobGroup.get(applicant.getJobGroup()).add(applicant.getIdx());
            }

            if (position.get(applicant.getPosition()) == null) {
                Set<Integer> set = new HashSet<>();
                set.add(applicant.getIdx());
                position.put(applicant.getPosition(), set);
            } else {
                position.get(applicant.getPosition()).add(applicant.getIdx());
            }

            if (soulFood.get(applicant.getSoulFood()) == null) {
                Set<Integer> set = new HashSet<>();
                set.add(applicant.getIdx());
                soulFood.put(applicant.getSoulFood(), set);
            } else {
                soulFood.get(applicant.getSoulFood()).add(applicant.getIdx());
            }
        }
    }

    class Applicant {
        private final int idx;
        private final String language;
        private final String jobGroup;
        private final String position;
        private final String soulFood;
        private final int score;

        public Applicant(int idx, String infoStr) {
            this.idx = idx;
            String[] info = infoStr.split(" ");
            this.language = info[0];
            this.jobGroup = info[1];
            this.position = info[2];
            this.soulFood = info[3];
            this.score = Integer.valueOf(info[4]);
        }

        public int getIdx() {
            return idx;
        }

        public String getLanguage() {
            return language;
        }

        public String getJobGroup() {
            return jobGroup;
        }

        public String getPosition() {
            return position;
        }

        public String getSoulFood() {
            return soulFood;
        }

        public int getScore() {
            return score;
        }
    }

    class Query {
        private final String language;
        private final String jobGroup;
        private final String position;
        private final String soulFood;
        private final int score;

        public Query(String queryStr) {
            String[] query = queryStr.replaceAll(" and", "").split(" ");
            this.language = query[0];
            this.jobGroup = query[1];
            this.position = query[2];
            this.soulFood = query[3];
            this.score = Integer.valueOf(query[4]);
        }

        public int execute(List<Applicant> applicants, Index index) {
            IntStream result = applicants.stream()
                    .filter(el -> this.score <= el.getScore())
                    .mapToInt(Applicant::getIdx);
            // () -> {}
            if (this.language.equals("-") == false) {
                result = result.filter(el -> index.getLanguage().get(this.language).contains(el));
            }

            if (this.jobGroup.equals("-") == false) {
                result = result.filter(el -> index.getJobGroup().get(this.jobGroup).contains(el));
            }

            if (this.position.equals("-") == false) {
                result = result.filter(el -> index.getPosition().get(this.position).contains(el));
            }

            if (this.soulFood.equals("-") == false) {
                result = result.filter(el -> index.getSoulFood().get(this.soulFood).contains(el));
            }

            return (int) result.count();
        }
    }
}