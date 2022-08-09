import java.util.LinkedList;
import java.util.Queue;

public class SnakesAndLadders {
    class QueuePair {
        int square;
        int moves;

        QueuePair(int square, int moves) {
            this.square = square;
            this.moves = moves;
        }
    }

    public int snakesAndLadders(int[][] board) {
        Queue<QueuePair> q = new LinkedList<>();
        boolean[] visited = new boolean[board.length * board[0].length + 1];
        visited[0] = true;
        visited[1] = true;

        int[] flatten = new int[board.length * board[0].length + 1];
        int count = board.length * board[0].length;
        boolean rev = board.length % 2 == 0 ? false : true;
        for (int[] row : board) {
            if (!rev) {
                for (int i = 0; i < row.length; i++) {
                    flatten[count--] = row[i];
                }
                rev = true;
            } else {
                for (int i = row.length - 1; i >= 0; i--) {
                    flatten[count--] = row[i];
                }
                rev = false;
            }
        }

        q.offer(new QueuePair(1, 0));
        while (!q.isEmpty()) {
            QueuePair pair = q.poll();
            int square = pair.square;
            int moves = pair.moves;

            for (int i = 1; i < 7; i++) {
                // Dice can move up to 6
                int nextsquare = square + i;

                if (flatten[nextsquare] != -1) {
                    // Either a snake or a ladder
                    nextsquare = flatten[nextsquare];
                }

                if (nextsquare == board.length * board.length) {
                    return moves + 1;
                }

                if (!visited[nextsquare]) {
                    visited[nextsquare] = true;
                    q.offer(new QueuePair(nextsquare, moves + 1));
                }
            }
        }

        return -1;
    }
}
