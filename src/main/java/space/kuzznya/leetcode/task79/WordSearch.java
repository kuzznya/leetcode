package space.kuzznya.leetcode.task79;

public class WordSearch {
    public boolean exist(char[][] board, String word) {
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(board, visited, i, j, word, 0)) return true;
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, boolean[][] visited, int i, int j, String word, int index) {
        if (index >= word.length()) return true;

        if (i < 0 || i >= board.length) return false;
        if (j < 0 || j >= board[0].length) return false;
        if (board[i][j] != word.charAt(index)) return false;
        if (visited[i][j]) return false;

        visited[i][j] = true;

        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        for (int[] direction : directions) {
            int nextI = i + direction[0];
            int nextJ = j + direction[1];

            if (dfs(board, visited, nextI, nextJ, word, index + 1)) return true;
        }
        visited[i][j] = false;
        return false;
    }

    public static void main(String[] args) {
        WordSearch wordSearch = new WordSearch();
        System.out.println(wordSearch.exist(new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}}, "ABCCED"));
        System.out.println(wordSearch.exist(new char[][]{{'a'}}, "aa"));
        System.out.println(wordSearch.exist(new char[][]{{'a'}}, "a"));
        System.out.println(wordSearch.exist(new char[][]{{'a'}}, "b"));
        System.out.println(wordSearch.exist(new char[][]{{'a'}, {'a'}}, "aaa"));
        System.out.println(wordSearch.exist(new char[][]{{'A','B','C','E'},{'S','F','E','S'},{'A','D','E','E'}}, "ABCESEEEFS"));
    }
}
