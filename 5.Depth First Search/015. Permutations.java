public class Solution {
    /*
     * @param nums: A list of integers.
     * @return: A list of permutations.
     */
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        if (nums == null) {
            return results;
        }
        
        if (nums.length == 0) {
            results.add(new ArrayList<>());
            return results;
        }
        
        dfs(nums, new HashSet<>(), new ArrayList<>(), results);
        
        return results;
        
    }
    
    private void dfs(int[] nums, Set<Integer> set, List<Integer> permutation, List<List<Integer>> results) {
        if (permutation.size() == nums.length) {
            results.add(new ArrayList<>(permutation));
        }
        
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                continue;
            }
            
            permutation.add(nums[i]);
            set.add(nums[i]);
            dfs(nums, set, permutation, results);
            set.remove(nums[i]);
            permutation.remove(permutation.size() - 1);
        }
    }
}
