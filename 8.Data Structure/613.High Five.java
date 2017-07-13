/**
 * Definition for a Record
 * class Record {
 *     public int id, score;
 *     public Record(int id, int score){
 *         this.id = id;
 *         this.score = score;
 *     }
 * }
 */
public class Solution {
    /**
     * @param results a list of <student_id, score>
     * @return find the average of 5 highest scores for each person
     * Map<Integer, Double> (student_id, average_score)
     */
    public Map<Integer, Double> highFive(Record[] results) {
        Map<Integer, Double> ans = new HashMap<>();
        if (results == null || results.length == 0) {
            return ans;
        }
        
        Map<Integer, PriorityQueue<Integer>> map = new HashMap<>();
        for (Record r : results) {
            if (!map.containsKey(r.id)) {
                map.put(r.id, new PriorityQueue<Integer>());
            }
            
            PriorityQueue<Integer> pq = map.get(r.id);
            if (pq.size() < 5) {
                pq.add(r.score);
            } else {
                if (r.score > pq.peek()) {
                    pq.poll();
                    pq.add(r.score);
                }
            }
        }
        
        for (Map.Entry<Integer, PriorityQueue<Integer>> entry : map.entrySet()) {
            int id = entry.getKey();
            PriorityQueue<Integer> scores = entry.getValue();
            double avg = 0;
            for (int i = 0; i < 5; i++) {
                avg += scores.poll();
            }
            avg /= 5.0;
            
            ans.put(id, avg);
        }
        
        return ans;
    }
}
