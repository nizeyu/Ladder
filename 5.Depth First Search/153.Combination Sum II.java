public class Solution {
    /**
     * @param num: Given the candidate numbers
     * @param target: Given the target number
     * @return: All the combinations that sum to target
     */
    public List<List<Integer>> combinationSum2(int[] num, int target) {
        List<List<Integer>> results = new ArrayList<>();
        if (num == null || num.length == 0) {
            return results;
        }
        
        // 1.排序
        // Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak)
        Arrays.sort(num);
        
        // 2.递归函数进行backtracking
        List<Integer> combination = new ArrayList<>();
        backtracking(0, target, combination, num, results);
        
        return results;
    }
    
    // 递归的定义：在candidates的从某个位置开始，找到所有和为 remainTarget 的子集拼在 subset 之后
    // candidates = [2,3,6,6], subset[2,2] + [3]
    // 或所有 subset 开头的和为 target 的子集都放到 results 里
    private void backtracking(int startIndex, 
                              int remainTarget, 
                              List<Integer> combination, 
                              int[] num, 
                              List<List<Integer>> results) {
        // 递归的出口
        if (remainTarget == 0) {
            // deep copy
            results.add(new ArrayList<>(combination));
        }
        
        // 递归的拆解
        for (int i = startIndex; i < num.length; i++) {
            if (num[i] > remainTarget) {
                break;
            }
            
            if (i != startIndex && num[i] == num[i-1]) {
                continue;
            }
            
            // subset=[2], remainTarget=5 => subset=[2,2], remainTarget=3
            combination.add(num[i]);
            remainTarget = remainTarget - num[i];
            // 和上题差别
            backtracking(i+1, remainTarget, combination, num, results);
            remainTarget = remainTarget + num[i];
            combination.remove(combination.size() - 1);// 回溯
        }
    }
}
