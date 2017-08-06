// Self
class Solution {
    /*
     * @param nums an integer array
     * @param k an integer
     * @return the top k largest numbers in array
     */
    public int[] topk(int[] nums, int k) {
        int[] result = new int[k];
        if (nums == null || nums.length == 0) {
            return result;
        }
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(k);
        
        for (int i = 0; i < nums.length; i++) {
            if (pq.size() < k) {
                pq.offer(nums[i]);
            } else {
                if (nums[i] > pq.peek()) {
                    pq.poll();
                    pq.offer(nums[i]);
                }
            }
        }
        
        int i = result.length - 1;
        while (!pq.isEmpty()) {
            result[i] = pq.poll();
            i--;
        }
        
        return result;
    }
};

// maxHeap
class Solution {
    /*
     * @param nums an integer array
     * @param k an integer
     * @return the top k largest numbers in array
     */
    public int[] topk(int[] nums, int k) {
        PriorityQueue<Integer> maxheap = new PriorityQueue<Integer>(k, new Comparator<Integer>(){
            public int compare(Integer o1, Integer o2) {
                if (o1 > o2) {
                    return -1;
                } else if (o1 < o2) {
                    return 1;
                } else {
                    return 0;
                }
            }
        });
        
        
        for (int num : nums) {
            maxheap.add(num);
        }
        int[] res = new int[k];
        for (int i = 0; i < res.length; i++) {
            res[i] = maxheap.poll();
        }
        
        return res;
    }
};

