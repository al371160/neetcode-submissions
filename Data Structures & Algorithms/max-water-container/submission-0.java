class Solution {
    public int maxArea(int[] heights) {
        //move head & tail according to which bar is smaller. 
        int head = 0;
        int tail = heights.length - 1;
        int max = 0;

        while (head < tail) {
            int a = heights[head];
            int b = heights[tail];

            int area = Math.min(a,b) * (tail - head);

            if (area > max) {
                max = area;
            }

            if (a > b) {
                tail--;
            } else {
                head++;
            }

        }

        return max;
    }
}
