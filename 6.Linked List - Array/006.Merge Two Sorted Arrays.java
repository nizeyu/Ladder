// Self
class Solution {
    /**
     * @param A and B: sorted integer array A and B.
     * @return: A new sorted integer array
     */
    public int[] mergeSortedArray(int[] A, int[] B) {
        if ((A == null || A.length == 0) && (B == null || B.length == 0)) {
            return new int[]{};
        } else if (A == null || A.length == 0) {
            return B;
        } else if (B == null || B.length == 0) {
            return A;
        }
        
        int[] result = new int[A.length + B.length];
        int a = 0;
        int b = 0;
        int i = 0;
        while (a < A.length && b < B.length) {
            if (A[a] < B[b]) {
                result[i] = A[a];
                a++;
                i++;
            } else {
                result[i] = B[b];
                b++;
                i++;
            }
        }
        
        while (a < A.length) {
            result[i] = A[a];
            a++;
            i++;
        }
        
        while (b < B.length) {
            result[i] = B[b];
            b++;
            i++;
        }
        
        return result;
    }
}
