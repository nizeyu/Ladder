public class Solution {
    /**
      * @param start, a string
      * @param end, a string
      * @param dict, a set of string
      * @return a list of lists of string
      */
    public List<List<String>> findLadders(String start, String end, Set<String> dict) {
        List<List<String>> results = new ArrayList<>();
        if (dict == null || dict.size() == 0) {
            return results;
        }
        
        Map<String, List<String>> map = new HashMap<>();
        Map<String, Integer> distance = new HashMap<>();
        
        dict.add(start);
        dict.add(end);
        
        bfs(map, distance, start, end, dict);
        
        dfs(end, map, distance, start, new ArrayList<String>(), results);
        
        return results;  
    }
    
    private void bfs(Map<String, List<String>> map, Map<String, Integer> distance, String start, String end, Set<String> dict) {
        
        Queue<String> queue = new LinkedList<String>();
        queue.offer(start);
        distance.put(start, 0);
        for (String s : dict) {
            map.put(s, new ArrayList<String>());
        }
        
        while (!queue.isEmpty()) {
            String word = queue.poll();
            for (String nextWord : getNextWords(word, dict)) {
                map.get(nextWord).add(word);
                if (distance.containsKey(nextWord)) {
                    continue;
                }
                distance.put(nextWord, distance.get(word) + 1);
                queue.offer(nextWord);
            }
        }
    }
    
    private void dfs(String word, Map<String, List<String>> map, Map<String, Integer> distance, String start, List<String> path, List<List<String>> results) {
        path.add(word);
        if (word.equals(start)) {
            Collections.reverse(path);
            results.add(new ArrayList<String>(path));
            Collections.reverse(path);
        } else {
            for (String next : map.get(word)) {
                if (distance.containsKey(next) && distance.get(word) == distance.get(next) + 1) { 
                    dfs(next, map, distance, start, path, results);
                }
            }           
        }
        path.remove(path.size() - 1);
    }
    
    // get connections with given word,
    // for example, given word = 'hot', dict = {'hot', 'hit', 'hog'}
    // it will return ['hit', 'hog']
    private ArrayList<String> getNextWords(String word, Set<String> dict) {
        ArrayList<String> nextWords = new ArrayList<String>();
        for (char c = 'a'; c <= 'z'; c++) {
            for (int i = 0; i < word.length(); i++) {
                if (c == word.charAt(i)) {
                    continue;
                }
                String nextWord = replace(word, i, c);
                if (dict.contains(nextWord)) {
                    nextWords.add(nextWord);
                }
            }
        }
        return nextWords;
    }
    
    // replace character of a string at given index to a given character
    // return a new string
    private String replace(String s, int index, char c) {
        char[] chars = s.toCharArray();
        chars[index] = c;
        return new String(chars);
    }
}
