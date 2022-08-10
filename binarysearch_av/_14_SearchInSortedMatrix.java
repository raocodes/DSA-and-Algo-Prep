package binarysearch_av;

// https://practice.geeksforgeeks.org/problems/search-in-a-matrix17201720/1
public class _14_SearchInSortedMatrix {
    public static int matSearch(int mat[][], int N, int M, int X) {
        int i = 0;
        int j = M - 1;
        while (i < N && j >= 0) {
            if (mat[i][j] == X) {
                return 1;
            } else if (X > mat[i][j]) {
                i++;
            } else if (X < mat[i][j]) {
                j--;
            }
        }
        return 0;
    }
}
