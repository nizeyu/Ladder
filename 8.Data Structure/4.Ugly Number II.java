class Solution {
    /**
     * @param n an integer
     * @return the nth prime number as description.
     */
    public int nthUglyNumber(int n) {
        // if (n == 1) {
        //     return 1;
        // }
        
        int count = 1;
        List<Integer> res = new ArrayList<>();
        res.add(1);
        
        Stack<Integer> s2 = new Stack<>();
        Stack<Integer> s3 = new Stack<>();
        Stack<Integer> s5 = new Stack<>();
        int i2 = 2;
        int i3 = 2;
        int i5 = 2;
        
        s2.push(2);
        s3.push(3);
        s5.push(5);
        
        while (count < n) {
            if (s2.peek() < s3.peek() && s2.peek() < s5.peek()) {
                int ugly = s2.peek();
                res.add(ugly);
                int newUgly = calculate(ugly, i2, 2);
                s2.push(newUgly);
                if (newUgly == Math.pow(2, i2)) {
                    i2++;
                }
            } else if (s3.peek() < s2.peek() && s3.peek() < s5.peek()) {
                int ugly = s3.peek();
                res.add(ugly);
                int newUgly = calculate(ugly, i3, 3);
                //System.out.println(newUgly);
                s3.push(newUgly);
                if (newUgly == Math.pow(3, i3)) {
                    i3++;
                }
            } else if (s5.peek() < s2.peek() && s5.peek() < s3.peek()) {
                int ugly = s5.peek();
                res.add(ugly);
                int newUgly = calculate(ugly, i5, 5);
                s5.push(newUgly);
                if (newUgly == Math.pow(5, i5)) {
                    i5++;
                }
            }
            count++;
        }
        
        for (int i = 0; i < res.size(); i++) {
            System.out.print(res.get(i) + " ");
        }
        
        return res.get(n - 1);
    }
    
    private int calculate(int ugly, int i, int num) {
        int[] base = {2, 3, 5};
        int min = Integer.MAX_VALUE;
        
        for (int j = 0; j < 3; j++) {
            min = Math.min(min, ugly * base[j]);
            //System.out.println(min);
        }
        
        int p = (int)Math.pow(num, i);
        
        //System.out.println((int)Math.min(min, p));
        
        return (int)Math.min(min, p);
    }
};
