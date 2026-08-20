class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ret = new ArrayList<>();
        HashMap<HashMap<Character, Integer>, ArrayList<String>> anagrams = new HashMap<>();
        for (String str : strs) {
            HashMap<Character, Integer> map = new HashMap<>();

            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);
                if (map.containsKey(c)) {
                    map.put(c, map.get(c) + 1);
                } else {
                    map.put(c, 1);
                }
            }

            if (anagrams.containsKey(map)) {
                anagrams.get(map).add(str);
            } else {
                ArrayList<String> value = new ArrayList<>();
                value.add(str);
                anagrams.put(map, value);
            }
        }

        for (ArrayList<String> list : anagrams.values()) {
            ret.add(list);
        }

        return ret;
    }
}
