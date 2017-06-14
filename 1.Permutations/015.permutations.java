class Solution {
    /**
     * @param nums: A list of integers.
     * @return: A list of permutations.
     */
    public List<List<Integer>> permute(int[] nums) {
        // write your code here
        List<List<Integer>> results = new ArrayList<>();
        if(nums == null) { // []
            return results;
        }
        
        if(nums.length == 0) { // [[]]
            results.add(new ArrayList<Integer>());
            return results;
        }
        
        Arrays.sort(nums);
        
        backtracking(nums, new boolean[nums.length], new ArrayList<Integer>(), results);
        
        return results;
    }
    
    private void backtracking(int[] nums, boolean[] used, List<Integer> temp, List<List<Integer>> results) {
        if(temp.size() == nums.length) {
            results.add(new ArrayList<>(temp));
            return;
        }
        
        for(int i = 0; i < nums.length; i++) {
            if(used[i] == true) {
                continue;    
            }
            used[i] = true;
            temp.add(nums[i]);
            backtracking(nums, used, temp, results);
            used[i] = false;
            temp.remove(temp.size() - 1);
        }
    }
}
