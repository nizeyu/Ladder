// Self
class Solution {
    /**
     * @param S: A set of numbers.
     * @return: A list of lists. All valid subsets.
     */
    public ArrayList<ArrayList<Integer>> subsets(int[] nums) {
        // write your code here
        ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
        
        // null
        if(nums == null) {
            return results;
        }
        
        // []
        if(nums.length == 0) {
            results.add(new ArrayList<Integer>());
            return results;// [[]]
        }
        
        Arrays.sort(nums);
        
        // [2, 1] == [1, 2]
        // 寻找所有 [] 开头的子集， 放到 res 里
        // 所有的字符串以 "" 开头
        backtracking(nums, 0, new ArrayList<Integer>(), results);
        
        return results;
    }
    
    //1. 递归的定义：在nums中寻找所有以subset 开头的子集，并放入 res
    private void backtracking(int[] nums, int offset, ArrayList<Integer> subset, ArrayList<ArrayList<Integer>> results) {
        // 2. 递归的拆解
        // 克隆操作 clone / 深度拷贝 deep copy
        results.add(new ArrayList<Integer>(subset));
        
        for(int i =  offset; i < nums.length; i++) {
            subset.add(nums[i]);
            // [] -> [1]
            // 把所有以[1]开头的子集都放到了 res 里
            backtracking(nums, i + 1, subset, results);
            // backtracking: [1] -> []
            subset.remove(subset.size() - 1);
        }
        // 3. 递归的出口
    }
}
