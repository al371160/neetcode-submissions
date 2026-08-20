class Solution {

    public String encode(List<String> strs) {
        //find a character that is not ascii. or find a character that is 
        StringBuilder sb = new StringBuilder();

        for (String str : strs) {
            sb.append(str);

            char space = 266;
            sb.append(space);
        }

        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == 266) {
                list.add(sb.toString());
                sb = new StringBuilder();
            } else {
                sb.append(c);
            }
        }
        return list;
    }
}
