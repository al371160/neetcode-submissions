class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        HashMap<Integer, Integer> top = new HashMap<>();
        int[] ret = new int[k];
        //possibility to store the worst number that still fits in the top k.
        int least = 0;
        int leastValue = 0;

        for (int i : nums) {
            if (map.containsKey(i)) {
                map.put(i, map.get(i) + 1);
            } else {
                map.put(i, 1);
            }
        }

        for (int i : map.keySet()) {
            if (top.size() < k) {
                top.put(i, map.get(i));
                if (leastValue == 0) {
                    least = i;
                    leastValue = map.get(i);
                } else if (map.get(i) < leastValue) {
                    least = i;
                    leastValue = map.get(i);
                }
            } else {
                if (leastValue < map.get(i)) {
                        top.put(i, map.get(i));
                        top.remove(least);
                        least = i;
                        leastValue = map.get(i);
                    }
                for (int j : top.keySet()) {
                    if (top.get(j) < leastValue) {
                        least = j; 
                        leastValue = map.get(j);
                    }
                }
            }
        }

        int index = 0;
        
        for (int i : top.keySet()) {
            ret[index] = i;
            index++;
        }
        return ret;
    }
}
