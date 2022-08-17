import java.util.LinkedList;
import java.util.Queue;

// https://practice.geeksforgeeks.org/problems/knight-walk4521/1
public class KnightWalk {
    private boolean isAllowed(int i, int j, int n)
    {
        if (i < 1 || i > n || j < 1 || j > n){
            return false;
        }
        return true;
    }

    public int minStepToReachTarget(int KnightPos[], int TargetPos[], int N)
    {
        boolean[][] visited = new boolean[N + 1][N + 1];

        int targeti = TargetPos[1];
        int targetj = TargetPos[0];

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{KnightPos[1], KnightPos[0], 0});
        visited[KnightPos[1]][KnightPos[0]] = true;

        int[][] directions = new int[][]{{1,2},{2,1},{1,-2},{2,-1},{-1, 2},{-2, 1},{-1,-2},{-2,-1}};

        while(!q.isEmpty()){
            int[] temp = q.poll();
            int i = temp[0];
            int j = temp[1];
            int dist = temp[2];

            if(i == targeti && j == targetj){
                return dist;
            }

            for(int index = 0; index < directions.length; index++){
                int newi = i + directions[index][0];
                int newj = j + directions[index][1];
                if(isAllowed(newi, newj, N) && !visited[newi][newj]){
                    visited[newi][newj] = true;
                    q.offer(new int[]{newi, newj, dist + 1});
                }
            }
        }

        return -1;
    }
}
