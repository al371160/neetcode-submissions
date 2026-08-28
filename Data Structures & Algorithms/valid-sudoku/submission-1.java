class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashMap<Integer, HashSet<Character>> boxes = new HashMap<>();
        HashMap<Integer, HashSet<Character>> vert = new HashMap<>();
        HashMap<Integer, HashSet<Character>> horiz = new HashMap<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == '.') {
                    continue;
                }
                int box = 3 * (i / 3) + j / 3;
                if (boxes.containsKey(box)) {
                    if (boxes.get(box).contains(board[i][j])) {
                        return false;
                    } else {
                        boxes.get(box).add(board[i][j]);
                    }
                } else {
                    HashSet<Character> set = new HashSet<>();
                    set.add(board[i][j]);
                    boxes.put(box, set);
                }
                //
                if (vert.containsKey(j)) {
                    if (vert.get(j).contains(board[i][j])) {
                        return false;
                    } else {
                        vert.get(j).add(board[i][j]);
                    }
                } else {
                    HashSet<Character> set = new HashSet<>();
                    set.add(board[i][j]);
                    vert.put(j, set);
                }

                if (horiz.containsKey(i)) {
                    if (horiz.get(i).contains(board[i][j])) {
                        return false;
                    } else {
                        horiz.get(i).add(board[i][j]);
                    }
                } else {
                    HashSet<Character> set = new HashSet<>();
                    set.add(board[i][j]);
                    horiz.put(i, set);
                }
            }
        }

        return true;
    }
}
