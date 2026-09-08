class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int head = 0;
        int tail = numbers.length - 1;
        int[] ret = new int[2];

        while (head <= tail) {
            if (numbers[head] + numbers[tail] > target) {
                tail--;
            } else if (numbers[head] + numbers[tail] < target) {
                head++;
            } else {
                ret[0] = head + 1;
                ret[1] = tail + 1;
                return ret;
            }
        }

        return ret;
    }
}

//[1,2,4,5,7],