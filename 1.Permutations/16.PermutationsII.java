class Solution {
    /**
     * @param nums: A list of integers.
     * @return: A list of unique permutations.
     */
    
    public List<List<Integer>> permuteUnique(int[] nums) {
        // Write your code here
        List<List<Integer>> results = new ArrayList<List<Integer>>();
        if(nums == null) {
            return results;
        }
        
        if(nums.length == 0) {
            results.add(new ArrayList<>());
            return results;
        }
        
        Arrays.sort(nums);
        
        backtracking(nums, new boolean[nums.length], new ArrayList<>(), results);
        
        return results;
    }
    
   
    private void backtracking(int[] nums, boolean[] used, List<Integer> temp, List<List<Integer>> results) {
        if(temp.size() == nums.length) {
            results.add(new ArrayList<>(temp));
            return;
        }
        int pre = Integer.MAX_VALUE;
        for(int i = 0; i < nums.length; ++i) {
            if(used[i] == true) {
                continue;
            }
            
            if(nums[i] == pre) {
                continue;
            }
            
            temp.add(nums[i]);
            used[i] = true;
            backtracking(nums, used, temp, results);
            pre = nums[i];
            used[i] = false;
            temp.remove(temp.size() - 1);
        }
    }
}
