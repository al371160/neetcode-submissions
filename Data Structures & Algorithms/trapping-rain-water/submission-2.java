class Solution {
    public int trap(int[] height) {
        //when tail >= head, count rainwater and place head with tail.
        int water = 0;
        int head = 0;
        int tail = 0;

        int curr = 0;
        while (tail < height.length) {
            if (height[tail] < height[head]) {
                curr += height[head] - height[tail];
                tail++;
            } else {
                water += curr;
                head = tail;
                tail++;
                curr = 0;
            }
        }

        curr = 0;
        int back = head;
        head = tail - 1;
        tail--;

        while (head >= back) {
            if (height[head] < height[tail]) {
                curr += height[tail] - height[head];
                head--;
            } else {
                water += curr;
                tail = head;
                head--;
                curr = 0;
            }
        }

        return water;
    }
}
