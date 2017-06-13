class Solution {
    /**
     * @param nums: A set of numbers.
     * @return: A list of lists. All valid subsets.
     */
    public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] nums) {
        // [1,1,1,1,1,1] 2^6   不能先找完再去重
        // write your code here
        ArrayList<ArrayList<Integer>> results = new ArrayList<>();
        
        if (nums == null) {
            return results;
        }
        if (nums.length == 0) {
            results.add(new ArrayList<Integer>());
            return results;
        }    
        
        Arrays.sort(nums);
        
        backtracking(nums, 0, new ArrayList<Integer>(), results);
        
        return results;
    }
    
    private void backtracking (int[] nums, int offset, ArrayList<Integer> subset, ArrayList<ArrayList<Integer>> results) {
        //deep copy subset & add to results
        results.add(new ArrayList<>(subset));
        
        for (int i = offset; i < nums.length; ++i) {
            // 确保前一个数没有被放进subset里面
            if (i != 0 && i > offset && nums[i] == nums[i-1]) {
                continue;
            }
                
            subset.add(nums[i]);
            backtracking(nums, i+1, subset, results);
            subset.remove(subset.size() - 1);
        }
    }
}
