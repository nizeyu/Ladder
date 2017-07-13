public class Solution {
    /**
     * @param numbers : Give an array numbers of n integer
     * @return : Find all unique triplets in the array which gives the sum of zero.
     */
    public ArrayList<ArrayList<Integer>> threeSum(int[] numbers) {
        ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
        if (numbers == null || numbers.length <= 2) {
            return results;
        }
        
        Arrays.sort(numbers);
        
        for (int i = 0; i < numbers.length - 2; i++) {
            if (i > 0 && numbers[i-1] == numbers[i]) {
                continue;
            }
            
            int l = i + 1;
            int r = numbers.length - 1;
            int target = -numbers[i];
            
            twoSum(l, r, target, numbers, results);
        }
        
        return results;
    }
    
    private void twoSum(int l, int r, int target, int[] numbers, ArrayList<ArrayList<Integer>> results) {
        while (l < r) {
            if (numbers[l] + numbers[r] == target) {
                ArrayList<Integer> temp = new ArrayList<>();
                temp.add(-target);
                temp.add(numbers[l]);
                temp.add(numbers[r]);
                results.add(temp);
                l++;
                r--;
                while (l < r && numbers[l] == numbers[l-1]) {
                    l++;
                }
                while (l < r && numbers[r] == numbers[r+1]) {
                    r--;
                }
                
            } else if (numbers[l] + numbers[r] < target) {
                l++;
                
                
            } else {
                r--;
            }
        }
    }
}
