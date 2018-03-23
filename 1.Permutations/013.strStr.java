#Method 1
public class Solution {
    /*
     * @param source: source string to be scanned.
     * @param target: target string containing the sequence of characters to match
     * @return: a index to the first occurrence of target in source, or -1  if target is not part of source.
     */
    public int strStr(String source, String target) {
        if (source == null || target == null) {
            return -1;
        }
        
        for (int i = 0; i < source.length() - target.length() + 1; i++) {
            int j = 0;
            for (j = 0; j < target.length(); j++) {
                if (source.charAt(i + j) != target.charAt(j)) {
                    break;
                }
            }
            
            if (j == target.length()) {
                return i;
            }
        }
        
        return -1;
    }
}


class Solution {
    /**
     * Returns a index to the first occurrence of target in source,
     * or -1  if target is not part of source.
     * @param source string to be scanned.
     * @param target string containing the sequence of characters to match.
     */
    public int strStr(String source, String target) {
        // write your code here
        if (source == null || target == null) {
            return -1;
        }
        if (source.length() == 0 && target.length() == 0) {
            return 0;
        } else if (target.length() == 0) {
            return 0;
        } else if (source.length() == 0) {
            return -1;
        }
        
        for (int i = 0; i < source.length(); ++i) {
            int t = i;
            for (int j = 0; j < target.length(); ++j) {
                if (t > source.length() - 1 || source.charAt(t) != target.charAt(j)) {
                    break;
                } else {
                    t++;
                }
            }
            if(t - i == target.length()) {
                return i;
            }
        }
        
        return -1;
    }
}
