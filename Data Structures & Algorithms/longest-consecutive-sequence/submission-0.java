class Solution {
    public int longestConsecutive(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        HashSet<Integer> set = new HashSet<>();
        int max = 0;

        if (nums.length == 0) {
            return 0;
        } else {
            for (int i = 0; i < nums.length; i++) {
                set.add(nums[i]);
            }
        }

        for (int i : set) {
            if (!set.contains(i - 1)) {
                int curr = 1;
                int index = i;
                while (set.contains(index + 1)) {
                    curr++;
                    index++;
                }

                if (curr > max) {
                    max = curr;
                }
            }
        }

        return max;
    }
}
