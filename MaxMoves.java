package com.learning.arrays;

import java.util.Arrays;

public class MaxMoves{
   public int maxMoves(int [][] grid) {
	   int m = grid.length, n = grid[0].length, i, j, k, max=0;
	   boolean[] curr = new boolean[m], next;
	   Arrays.fill(curr, true);

	   for(j=1; j<n && max==j-1; j++) {
		   next = new boolean[m];
		   for(i=0; i<m; i++) {
			   if(i>0 && curr[i-1] && grid[i][j]>grid[i-1][j-1]) {
				   next[i] = true;
				   max = j;
				   continue;
			   }
			   if(curr[i] && grid[i][j]>grid[i][j-1]) {
				   next[i] = true;
				   max = j;
				   continue;
			   }
			   if(i<m-1 && curr[i+1] && grid[i][j]>grid[i+1][j-1]) {
				   next[i] = true;
				   max = j;
			   }
		   }
		   curr = next;
	   }
	   return max;
   }

}
