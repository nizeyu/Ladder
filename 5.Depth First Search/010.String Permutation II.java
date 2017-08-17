// Self
public class Solution {
    /**
     * @param str a string
     * @return all permutations
     */
    public List<String> stringPermutation2(String str) {
        List<String> results = new ArrayList<>();
        if (str == null) {
            return results;
        }
        if (str.length() == 0) {
            results.add("");
            return results;
        }
        
        char[] strArray = str.toCharArray();
        Arrays.sort(strArray);
        
        dfs(new StringBuilder(), new boolean[str.length()], strArray, results);
        
        return results;
    }
    
    private void dfs(StringBuilder sb, boolean[] used, char[] strArray, List<String> results) {
        if (sb.length() == strArray.length) {
            results.add(sb.toString());
            return;
        }
        
        for (int i = 0; i < strArray.length; i++) {
            if (used[i]) {
                continue;
            }
            
            if (i > 0 && strArray[i] == strArray[i-1] && used[i-1] == false) {
                continue;
            }
            
            sb.append(strArray[i]);
            used[i] = true;
            dfs(sb, used, strArray, results);
            used[i] = false;
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
