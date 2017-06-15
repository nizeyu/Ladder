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
        
        for(int i = 0; i < nums.length; ++i) {
            if(used[i] == true || (i > 0 && nums[i] == nums[i-1] && used[i-1] == false)) {
                continue;
            }
            /*
            上面的判断主要是为了去除重复元素影响。
            比如，给出一个排好序的数组，[1,2,2]，那么第一个2和第二2如果在结果中互换位置，
            我们也认为是同一种方案，所以我们强制要求相同的数字，原来排在前面的，在结果
            当中也应该排在前面，这样就保证了唯一性。所以当前面的2还没有使用的时候，就
            不应该让后面的2使用。
            */
            temp.add(nums[i]);
            used[i] = true;
            backtracking(nums, used, temp, results);
            used[i] = false;
            temp.remove(temp.size() - 1);
        }
    }
}

//My Solution
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
