package recursionandbacktracking_striver;

// https://practice.geeksforgeeks.org/problems/m-coloring-problem-1587115620/1
public class _4_M_Colouring_Problem {
    public boolean graphColoring(boolean graph[][], int m, int n) {
        int[] colour = new int[n];
        return checkColours(0, graph, colour, m, n);
    }

    public boolean checkColours(int node, boolean[][] graph, int[] colour, int numcolours, int numnodes) {
        if (node == numnodes) {
            // We have finished checking all nodes
            // If the code reached here, then all the nodes from 0 - (n-1) have been
            // assigned colours
            return true;
        }

        // Checking for each possible colours
        for (int itercolour = 1; itercolour <= numcolours; itercolour++) {
            if (isAllowed(node, graph, colour, numnodes, itercolour)) {
                colour[node] = itercolour;
                boolean result = checkColours(node + 1, graph, colour, numcolours, numnodes);
                if (result == true)
                    return true;
                colour[node] = 0;
            }
        }

        // If true is not returned and code reaches here
        // That would mean that all the colours could not be assigned
        return false;
    }

    public boolean isAllowed(int node, boolean[][] graph, int[] colour, int numnodes, int itercolour) {
        for (int i = 0; i < numnodes; i++) {
            if (graph[node][i] == true && colour[i] == itercolour) {
                // If an adjacent node has the same colour
                return false;
            }
        }
        return true;
    }
}
