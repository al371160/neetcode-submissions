class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        //can't store an array
        //can possible do a hashmap of frequencies, then put into array, then sort
        //maybe do an array of size k but maintain it
        //uhh, maybe 2000 element array? it gotta be fast right

        //idea is to sort the values, then pick the top k values, search in map2, then go.
        HashMap<Integer, Integer> map1 = new HashMap<>(); 
            //int -> count (values will be sorted in list)
        HashMap<Integer, ArrayList<Integer>> map2 = new HashMap<>(); 
            //count -> int (values will be in output)

        int[] ret = new int[k];

        //(1,1),(2,2),(3,3)

        for (int i : nums) {
            if (map1.containsKey(i)) {
                map1.put(i, map1.get(i) + 1);
            } else {
                map1.put(i, 1);
            }
        } 

        for (Integer i : map1.keySet()) {
            if (map2.containsKey(map1.get(i))) {
                map2.get(map1.get(i)).add(i);
            } else {
                ArrayList<Integer> list = new ArrayList<>();
                list.add(i);
                map2.put(map1.get(i), list);
            }
        }

        ArrayList<Integer> list = new ArrayList<>();

        for (Integer i : map1.values()) {
            list.add(i);
        }

        Collections.sort(list, Collections.reverseOrder());

        for (int i = 0; i < ret.length; i++) {
            ArrayList<Integer> sharedCounts = map2.get(list.get(i));
            ret[i] = sharedCounts.get(sharedCounts.size() - 1);
            sharedCounts.remove(sharedCounts.size() - 1);
        }

        return ret;
    }
}
