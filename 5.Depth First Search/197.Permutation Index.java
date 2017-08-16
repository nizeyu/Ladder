public class Solution {
    /*
     * @param A: An array of integers
     * @return: A long integer
     */
    public long permutationIndex(int[] A) {
        int len = A.length;
        int[] map = new int[len];
        for (int i = 0; i < len - 1; i++) {
            for (int j = i+1; j < len; j++) {
                if (A[j] < A[i]) {
                    map[i]++;
                }
            }
        }
        
        long index = 1;
        for (int i = 0; i < len; i++) {
            index += getFactorial(len - i - 1) * map[i];
        }
        return index;
    }
    
    private long getFactorial(long n) {
        if (n <= 0) {
            return 0;
        }
        long factorial = 1;
        while (n > 0) {
            factorial *= n;
            n--;
        }
        return factorial;
    }
};
