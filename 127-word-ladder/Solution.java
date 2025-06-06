import java.util.*;

class Solution {

    public static void main(String[] args) {
        
        List<String> wordList = List.of("hot","dot","dog","lot","log","cog");

        String beginWord = "hit";
        String endWord = "cog";

        System.out.println("----------------");
        System.out.println(ladderLength(beginWord, endWord, wordList));
    }

    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {

        boolean isEndWordExist = false;

        Map<String, List<String>> graph = new HashMap<>();

        for(int i = 0; i < wordList.size(); i++) {

            List<String> words = new ArrayList<>();
            
            for(int j = 0; j < wordList.size(); j++) {

                if (i == j) continue;

                if (isOneLetterDifferent(wordList.get(i), wordList.get(j))) {
                    words.add(wordList.get(j));
                }
            }

            graph.put(wordList.get(i), words);

            if(wordList.get(i).equals(endWord)) isEndWordExist = true;
        }

        if (!isEndWordExist) return 0;

        Queue<Pair<String, Integer>> queue = new LinkedList<>();

        for (int i = 0; i < wordList.size(); i++) {
            if (isOneLetterDifferent(beginWord, wordList.get(i))) {
                queue.offer(new Pair<String,Integer>(wordList.get(i), 1));
            }
        }

        while (!queue.isEmpty()) {
            Pair<String, Integer> pair = queue.poll();

            if (pair.getKey().equals(endWord)) return pair.getValue() + 1;

            if(graph.containsKey(pair.getKey())) {
                for(String word : graph.get(pair.getKey())) {
                    queue.add(new Pair<String,Integer>(word, pair.getValue() + 1));
                }

                graph.remove(pair.getKey());
                
            }
        }
        
        return 0;
    }

    public static boolean isOneLetterDifferent(String wordOne, String wordTwo) {

        int diffCount = 0;
        for (int i = 0; i < wordOne.length(); i++) {
            if (wordOne.charAt(i) != wordTwo.charAt(i)) {
                diffCount++;
            }
        }

        return diffCount == 1;
    }
}