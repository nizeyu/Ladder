public class TwoSum {
    
    Map<Integer, Integer> map;
    
    public TwoSum() {
        map = new HashMap<Integer, Integer>();
    }
    
    // Add the number to an internal data structure.
    // 猜测add操作会比较多, find 相对较少
    public void add(int number) {
        if (map.containsKey(number)) {
            map.put(number, map.get(number) + 1);
        } else {
            map.put(number, 1);
        }
        // map.put(number, getOrDefault(number, 0) + 1);
    }

    // Find if there exists any pair of numbers which sum is equal to the value.
    public boolean find(int value) {
        for (int num : map.keySet()) {
            int num1 = value - num;
            if ((num == num1 && map.get(num) > 1) ||
                (num != num1 && map.containsKey(num1))) {
                    return true;
                }
        }
        return false;
    }
}


// Your TwoSum object will be instantiated and called as such:
// TwoSum twoSum = new TwoSum();
// twoSum.add(number);
// twoSum.find(value);
