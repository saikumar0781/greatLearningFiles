package Graphs;

import java.util.*;

public class MinimumEffortPath {

    static int output = 0;
    static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) {
        int mat[][] = {{7,2,6,5},{3,1,10,8}};
        System.out.println(minCostPath(mat));
    }
    public static int minCostPath(int[][] mat) {
        // code here
        int m = mat.length,n=mat[0].length;


        int[] delrow = {-1,0,1,0};
        int[] delcol = {0,1,0,-1};

        int[][] dist = new int[m][n];
        for(int i =0;i<m;i++)
            Arrays.fill(dist[i],(int)(1e9));
        dist[0][0] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.add(new int[]{0,0,0});


        while(!pq.isEmpty())
        {
            int[] p = pq.poll();
            int d = p[0];
            int row = p[1];
            int col = p[2];
            for(int i = 0;i<4;i++)
            {
                int row1 = row + delrow[i];
                int col1 = col + delcol[i];

                if(row1 >= 0 && col1 >=0 && row1 < m && col1<n)
                {
                    if(dist[row1][col1] > Math.max(d,Math.abs(mat[row][col]-mat[row1][col1])))
                    {
                        dist[row1][col1] = Math.max(d,Math.abs(mat[row][col]-mat[row1][col1]));
                    }
                    pq.add(new int[]{dist[row1][col1],row1,col1});
                }
            }
        }
        return dist[m-1][n-1];
    }
}