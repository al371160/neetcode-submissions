class Solution {
    public int maxProfit(int[] prices) {
        int head = 0;
        int tail = 0;
        int max = 0;
        while (tail < prices.length) {
            if (prices[tail] > prices[head]) {
                max = Math.max(max, prices[tail] - prices[head]);
            } else {
                head = tail;
            }
            tail++;
        }

        return max;
        
    }

    //find the maximum j - i, where j > i, or return 0.
    //logic based on coin change, maximum of current is 

    //naive solution, find all combos and compare min with 0, 
    //can we do better?
    //can we somehow find a minimum out of a subset of the array?
    //

    //4, 3, 2, 1, 5, 0, 10, -3, 9  
}
