import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        // 장르별 총 재생 횟수를 저장할 맵
        Map<String, Integer> genrePlayCount = new HashMap<>();
        // 노래의 정보를 저장할 맵 (장르별로)
        Map<String, List<int[]>> genreToSongs = new HashMap<>();

        // 장르별 총 재생 횟수 계산 및 노래 정보 저장
        for (int i = 0; i < genres.length; i++) {
            String genre = genres[i];
            int play = plays[i];

            genrePlayCount.put(genre, genrePlayCount.getOrDefault(genre, 0) + play);

            if (!genreToSongs.containsKey(genre)) {
                genreToSongs.put(genre, new ArrayList<>());
            }
            genreToSongs.get(genre).add(new int[]{i, play});
        }

        // 장르별로 노래를 재생 횟수에 따라 정렬
        for (Map.Entry<String, List<int[]>> entry : genreToSongs.entrySet()) {
            Collections.sort(entry.getValue(), new Comparator<int[]>() {
                @Override
                public int compare(int[] a, int[] b) {
                    if (a[1] != b[1]) {
                        return b[1] - a[1];
                    } else {
                        return a[0] - b[0];
                    }
                }
            });
        }

        // 장르별 총 재생 횟수에 따라 장르 정렬
        List<Map.Entry<String, Integer>> sortedGenreList = new ArrayList<>(genrePlayCount.entrySet());
        Collections.sort(sortedGenreList, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> a, Map.Entry<String, Integer> b) {
                return b.getValue() - a.getValue();
            }
        });

        // 결과를 저장할 리스트
        List<Integer> answerList = new ArrayList<>();

        // 각 장르별 상위 2곡
        for (Map.Entry<String, Integer> genreEntry : sortedGenreList) {
            String genre = genreEntry.getKey();
            List<int[]> songs = genreToSongs.get(genre);
            int count = 0;
            for (int[] song : songs) {
                if (count < 2) {
                    answerList.add(song[0]);
                    count++;
                } else {
                    break;
                }
            }
        }

        // 결과
        int[] answer = new int[answerList.size()];
        for (int i = 0; i < answerList.size(); i++) {
            answer[i] = answerList.get(i);
        }

        return answer;
    }
}
