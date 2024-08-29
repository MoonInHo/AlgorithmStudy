package programmers.books.algorithm08_hash;

import java.util.*;
import java.util.stream.Stream;

public class Problem22 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int arrSize = scanner.nextInt();

        String[] genres = new String[arrSize];
        int[] plays = new int[arrSize];

        scanner.nextLine();

        for (int i = 0; i < arrSize; i++) {
            genres[i] = scanner.nextLine();
        }
        for (int i = 0; i < arrSize; i++) {
            plays[i] = scanner.nextInt();
        }

        int[] result = solution(genres, plays);
        System.out.println(Arrays.toString(result));
    }

    public static int[] solution(String[] genres, int[] plays) {

        HashMap<String, ArrayList<int[]>> genreMap = new HashMap<>();
        HashMap<String, Integer> playMap = new HashMap<>();

        for (int i = 0; i < genres.length; i++) {

            String genre = genres[i];
            int play = plays[i];

            if (!genreMap.containsKey(genre)) {
                genreMap.put(genre, new ArrayList<>());
                playMap.put(genre, 0);
            }
            genreMap.get(genre).add(new int[]{i, play});
            playMap.put(genre, playMap.get(genre) + play);
        }

        ArrayList<Integer> answer = new ArrayList<>();

        Stream<Map.Entry<String, Integer>> sortedGenre = playMap.entrySet()
                .stream()
                .sorted(((o1, o2) -> Integer.compare(o2.getValue(), o1.getValue())));

        sortedGenre.forEach(entry -> {
            Stream<int[]> sortedSongs = genreMap.get(entry.getKey()).stream()
                    .sorted(((o1, o2) -> Integer.compare(o2[1], o1[1])))
                    .limit(2);
            sortedSongs.forEach(song -> answer.add(song[0]));
        });
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}