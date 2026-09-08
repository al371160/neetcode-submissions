class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        HashSet<List<Integer>> hs = new HashSet<>();

        for (int i = 0; i < nums.length - 2; i++) {
            int num = nums[i];
            HashSet<Integer> set = new HashSet<>();

            for (int j = i + 1; j < nums.length; j++) {
                if (set.contains(-num - nums[j])) {
                    ArrayList<Integer> good = new ArrayList<>();
                    good.add(num);
                    good.add(-num - nums[j]);
                    good.add(nums[j]);
                    Collections.sort(good);
                    hs.add(good);
                } else {
                    set.add(nums[j]);
                }
            }
        }

        return new ArrayList<>(hs);
    }
}
