class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int head = 0;
        int max = 0;

        for (int tail = 0; tail < s.length(); tail++) {
            char c = s.charAt(tail);

            if (map.containsKey(c)) {
                head = Math.max(head, map.get(c) + 1);
            } 
            map.put(c, tail);

            if (tail - head + 1 > max) {
                max = tail - head + 1;
            }
        }

        return max;
    }
}
