package dfs;

import java.util.LinkedList;
import java.util.Queue;

public class SurroundedRegions {
    public void solve(char[][] board) {
        if(board.length == 0 || board[0].length == 0) return;
        if(board.length < 2 || board[0].length < 2) return;

        int col = board[0].length;
        int row = board.length;

        // start from first col and last col, turn '0' to '*'
        for (int i = 0; i < row; i++){
            if (board[i][0] == 'O')
                dfs(board, i, 0);
            if (board[i][col - 1] == 'O')
                dfs(board, i, col - 1);
        }

        // start from first row and last row, turn '0' to '*'
        for (int j = 0; j < col; j++){
            if (board[0][j] == 'O')
                dfs(board, 0, j);
            if (board[row - 1][j] == 'O')
                dfs(board, row - 1, j);
        }

        for (int i = 0; i < row; i++){
            for (int j = 0; j < col; j++){
                if (board[i][j] == 'O')
                    board[i][j] = 'X';
                else if (board[i][j] == '*')
                    board[i][j] = 'O';
            }
        }

    }

    private void dfs(char[][] board, int x, int y){
        if(x < 0 || x > board.length - 1 || y < 0 || y > board[0].length){
            return;
        }
        if(board[x][y] == 'O'){
            board[x][y] = '*';
        }
        if (x > 1 && board[x - 1][y] == 'O')
            dfs(board, x - 1, y);
        if (x < board.length - 2 && board[x + 1][y] == 'O')
            dfs(board, x + 1, y);
        if (y > 1 && board[x][y - 1] == 'O')
            dfs(board, x, y - 1);
        if (y < board[x].length - 2 && board[x][y + 1] == 'O')
            dfs(board, x, y + 1);
    }

    private void bfs(char[][] board, int x, int y){
        int[][] nums = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        Queue<Integer[]> queue = new LinkedList<>();
        Integer[] pos = {x, y};
        queue.offer(pos);

        while (queue != null && queue.size() != 0){
            Integer[] temp = queue.poll();
            for (int i = 0; i < 4; i++){
                Integer newX = temp[0] + nums[i][0];
                Integer newY = temp[1] + nums[i][1];
                if(newX < 0 || newX >= board.length || newY < 0 || newY >= board[0].length)
                    continue;
                if (board[newX][newY] == 'O'){
                    board[newX][newY] = '*';
                    Integer[] t = {newX, newY};
                    queue.offer(t);
                }
            }
        }
    }

    public static void main(String[] args){
        char[][] arr = {{'X', 'X', 'X', 'X'}, {'X', 'O', 'O', 'X'}, {'X', 'X', 'O', 'X'}, {'X', 'O', 'X', 'X'}};
        SurroundedRegions surroundedRegions = new SurroundedRegions();
        surroundedRegions.solve(arr); //按值传递，对象的引用被改变
        for (int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr[0].length; j++){
                System.out.print(arr[i][j] + "");
            }
            System.out.println(); // enter
        }
    }
}
