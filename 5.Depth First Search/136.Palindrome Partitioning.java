public class Solution {
    /**
     * @param s: A string
     * @return: A list of lists of string
     */
    public List<List<String>> partition(String s) {
        List<List<String>> results = new ArrayList<>();
        if (s == null || s.length() == 0) {
            return results;
        }
        
        // 递归函数进行backtracking
        List<String> partition = new ArrayList<String>();
        backtracking(0, partition, s, results);
        
        return results;
    }
    
    // 递归的定义：所有 partition 开头的满足 isPalindrome 的 substring 都放到 results 里
    private void backtracking(int startIndex, 
                              List<String> partition, 
                              String s, 
                              List<List<String>> results) {
        // 递归的出口
        if (startIndex == s.length()) {
            // deep copy
            results.add(new ArrayList<String>(partition));
            return;
        }
        
        // 递归的拆解
        for (int i = startIndex; i < s.length(); i++) {
            String subString = s.substring(startIndex, i+1);
            if (!isPalindrome(subString)) {
                continue;
            }
            
            partition.add(subString);
            backtracking(i+1, partition, s, results);
            partition.remove(partition.size() - 1);// 回溯
        }
    }
    
    private boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
