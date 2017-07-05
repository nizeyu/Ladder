public class Solution {
    /**
     * @param nums: A list of integers
     * @return: A list of integers includes the index of the first number 
     *          and the index of the last number
     */
    public ArrayList<Integer> subarraySum(int[] nums) {
        ArrayList<Integer> results = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
       
        map.put(0, -1);
       
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
           
            if (map.containsKey(sum)) {
                results.add(map.get(sum) + 1);
                results.add(i);
                return results;
            }
            
            map.put(sum, i);
        }
       
        return results;

    }
}
