package crackingTheCodingInterview;

import java.util.Scanner;

public class ConnectedCellInAGrid {

	public static int getBiggestRegion(int[][] matrix) {
        boolean[][] isVisited = new boolean[matrix.length][matrix[0].length];
        int largestRegion = 0;
        for (int y = 0; y < matrix.length; y++){
        	for (int x = 0; x < matrix[0].length; x++){
        		if (matrix[y][x] == 1 && !isVisited[y][x]){
        			largestRegion = Math.max(largestRegion, getSize(matrix, isVisited, y,x));
        		}
        	}
        }
        
        return largestRegion;
    }
    
    private static int getSize(int[][] matrix, boolean[][] isVisited, int y, int x) {
		if (y<0 || y>=matrix.length || x < 0 || x >= matrix[0].length || isVisited[y][x] || matrix[y][x] == 0 ) return 0;
		
		isVisited[y][x] = true;
		
		int total = 0;
		
		total += getSize(matrix,isVisited,y-1,x-1);
		total += getSize(matrix,isVisited,y-1,x);
		total += getSize(matrix,isVisited,y-1,x+1);
		total += getSize(matrix,isVisited,y,x-1);
		total += getSize(matrix,isVisited,y,x+1);
		total += getSize(matrix,isVisited,y+1,x-1);
		total += getSize(matrix,isVisited,y+1,x);
		total += getSize(matrix,isVisited,y+1,x+1);
		
		return total + 1;

	}

	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int grid[][] = new int[n][m];
        for(int grid_i=0; grid_i < n; grid_i++){
            for(int grid_j=0; grid_j < m; grid_j++){
                grid[grid_i][grid_j] = in.nextInt();
            }
        }
        System.out.println(getBiggestRegion(grid));
    }
}
