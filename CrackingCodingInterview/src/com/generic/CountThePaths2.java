package com.generic;

/**
 * Dynamic programming with memoization (example - count no of paths)
 * Version 2
 * 
 * Counting the paths from bottom right and top left seems the most efficient
 * solution. (countPathsGenMemo)
 * Comparison of different solution approaches and iterations they take has been
 * given at the end of the class.
 */
public class CountThePaths2 {

	public static void main(String[] args) throws Exception {
		int rows = 8, cols = 8;
		
		int[][] grid0 = {
				{ 0,  0,  0,  0,   0,  0,  0,  0},
				{ 0,  0,  0,  0,   0,  0,  0,  0},
				{ 0,  0,  0,  0,   0,  0,  0,  0},
				{ 0,  0,  0,  0,   0,  0,  0,  0},
				{ 0,  0,  0,  0,   0,  0,  0,  0}, 
				{ 0,  0,  0,  0,   0,  0,  0,  0},
				{ 0,  0,  0,  0,   0,  0,  0,  0},
				{ 0,  0,  0,  0,   0,  0,  0,  0},
		};
		
		int[][] grid1 = {
				{ 0,  0,  0,  0,   0,  0,  0,  0},
				{ 0,  0, -1,  0,   0,  0, -1,  0},
				{ 0,  0,  0,  0,  -1,  0,  0,  0},
				{-1,  0, -1,  0,   0, -1,  0,  0},
				{ 0,  0, -1,  0,   0,  0,  0,  0},
				{ 0,  0,  0, -1,  -1,  0, -1,  0},
				{ 0, -1,  0,  0,   0, -1,  0,  0},
				{ 0,  0,  0,  0,   0,  0,  0,  0},
		};

		
		int paths = countPathsGeneric(rows, cols);
		System.out.format("\ncountPathsGeneric (%d×%d) : %d, iterations: %d", rows, cols, paths, cpg);
		
		int paths1 = countPaths(0, 0, grid0);
		System.out.format("\ncountPaths (%d×%d) : %d, iterations: %d", rows, cols, paths1, it);
		
		int paths2 = countPathsMemo(0, 0, grid0, new int[rows][cols]);
		System.out.format("\ncountPathsMemo (%d×%d) : %d, iterations: %d", rows, cols, paths2, it1);
		
		cpg = 0;
		int pathsg = countPathsGenMemo(rows, cols, grid0, new int[rows][cols]);
		System.out.format("\ncountPathsGenMemo (%d×%d) : %d, iterations: %d", rows, cols, pathsg, cpgm);
		
		it = 0;
		int paths3 = countPaths(0, 0, grid1);
		System.out.format("\ncountPaths (%d×%d) #-1 : %d, iterations: %d", rows, cols, paths3, it); // countPaths with #-1 (8×8) grid : 27 -- 212 iterations
		
		it1 = 0;
		int paths4 = countPathsMemo(0, 0, grid1, new int[rows][cols]);
		System.out.format("\ncountPathsMemo (%d×%d) #-1 : %d, iterations: %d", rows, cols, paths4, it1); // countPathsMemo with #-1 (8×8) grid : 27 -- 90 iterations

		cpgm = 0;
		int path5 = countPathsGenMemo(rows, cols, grid1, new int[rows][cols]);
		System.out.format("\ncountPathsGenMemo (%d×%d) #-1 : %d, iterations: %d", rows, cols, path5, cpgm);
		
		// with a 3*4 grid without obstacles 
		System.out.println("\n\n\n*** with a 3*4 grid without obstacles *** ");
		rows = 3; cols = 4;
		
		int[][] grid11 = {
				{ 0,  0,  0,  0},
				{ 0,  0,  0,  0},
				{ 0,  0,  0,  0}
		};
		
		int paths10 = countPathsGeneric(rows, cols);
		System.out.format("\ncountPathsGeneric (%d×%d) : %d, iterations: %d", rows, cols, paths10, cpg);
		
		it = 0;
		int paths11 = countPaths(0, 0, grid11);
		System.out.format("\ncountPaths (%d×%d) : %d, iterations: %d", rows, cols, paths11, it); // countPaths with #-1 (8×8) grid : 27 -- 212 iterations
		
		it1 = 0;
		int paths12 = countPathsMemo(0, 0, grid11, new int[rows][cols]);
		System.out.format("\ncountPathsMemo (%d×%d) : %d, iterations: %d", rows, cols, paths12, it1); // countPathsMemo with #-1 (8×8) grid : 27 -- 90 iterations

		cpgm = 0;
		int paths13 = countPathsGenMemo(rows, cols, grid11, new int[rows][cols]);
		System.out.format("\ncountPathsGenMemo (%d×%d) : %d, iterations: %d", rows, cols, paths13, cpgm);
		
		
		System.out.print("\n\n*** with a 3*4 grid WITH obstacles *** ");
		rows = 3; cols = 4;
		
		int[][] grid12 = {
				{  0,  0,  0,  0},
				{  0,  0, -1,  0},
				{  0,  0,  0,  0}
		};
		
		//int paths14 = countPathsGeneric(rows, cols);
		//System.out.format("\ncountPathsGeneric (%d×%d) : %d, iterations: %d", rows, cols, paths10, itg);
		
		it = 0;
		int paths14 = countPaths(0, 0, grid12);
		System.out.format("\ncountPaths (%d×%d) #-1 : %d, iterations: %d", rows, cols, paths14, it); // countPaths with #-1 (8×8) grid : 27 -- 212 iterations
		
		it1 = 0;
		int paths15 = countPathsMemo(0, 0, grid12, new int[rows][cols]);
		System.out.format("\ncountPathsMemo (%d×%d) #-1 : %d, iterations: %d", rows, cols, paths15, it1); // countPathsMemo with #-1 (8×8) grid : 27 -- 90 iterations

		cpgm = 0;
		int paths16 = countPathsGenMemo(rows, cols, grid12, new int[rows][cols]);
		System.out.format("\ncountPathsGenMemo (%d×%d) #-1 : %d, iterations: %d", rows, cols, paths16, cpgm);
		
		
		//int[][] copy = Arrays.stream(matrix).map(int[]::clone).toArray(int[][]::new);
		//System.out.println("\n" + countPathsGeneric(3, 4));
		//System.out.println("\n" + countPathsGenMemo(3, 4, new int[3][4],new int[3][4]));
		//System.out.println("\n" + countPathsGenMemo(8, 8, new int[8][8],new int[8][8]));
	}

	/**
	 * Returns number of paths from top left corner ( or from any cell ) to the 
	 * bottom right corner of the grid. 
	 * 
	 * From each cell we can move either to the left or downwards.
	 * So with this logic, for an m×n grid, the paths from the cell (m, n)
	 * paths(m, n) = paths(m, n-1) + paths(m-1, n) 
	 * 
	 * Thus for the bottom right corner cell the number of paths will be 0 and 
	 * for all the cells above it & all the cells to the left of it will be 1.
	 * i.e. whenever m=1 or n=1, no of paths will be 1.
	 * 
	 * 		  n	 n-1					  1
	 * start---------------------------------
	 * (m×n)|	|	|	|	|	|	|	|	|
	 * 		---------------------------------
	 * 	m-1	|	|	|**	|	|	|	|**	|	|
	 * 		---------------------------------
	 * 		|	|	|	|**	|	|	|	|
	 * 		---------------------------------
	 * 		|**	|	|**	|	|	|**	|	|	|
	 * 		---------------------------------
	 * 		|	|	|**	|	|	|	|	|	|
	 * 		---------------------------------
	 * 		|	|	|	|**	|**	|	|**	|	|
	 * 		---------------------------------
	 * 		|	|**	|	|	|	|**	|	|	|
	 * 		---------------------------------
	 * 	1	|	|	|	|	|	|	|	|	|
	 * 		--------------------------------- end (1×1)
	 * 
	 * @param row
	 * @param column
	 * @return count of possible paths in the grid from (row,col) to (1,1) 
	 */
	static int cpg = 0/* , m = 3, n = 4 */;
	private static int countPathsGeneric(int row, int column) {
		cpg++;
		int paths = 0;
		
		if (row == 1 && column == 1) 
			paths = 0;
		else if (row == 1 || column == 1)
			paths = 1;
		else
			paths = (countPathsGeneric(row, column-1) + countPathsGeneric(row-1, column));
		
		//System.out.format("\n(%d, %d), grid["+(m-row)+"]["+(n-column)+"] : paths=%d", row, column, paths);
		return paths;
	}
	
	// count of possible paths in the grid from (row,col) to (1,1) 
	// so far most efficient solution??
	// memoized and improved version of solution in ''
	static int cpgm = 0;
	private static int countPathsGenMemo(int row, int col, int[][] grid, int[][] paths) throws Exception {
		cpgm++;
		int m = grid.length; int n = grid[0].length;
		
		if ((row == 1 && col == 1) || (grid[m-row][n-col] == -1))
			return 0;
		else if (row == 1 || col == 1)
			return 1;
		else if (paths[m-row][n-col] == 0) 
			paths[m-row][n-col] = countPathsGenMemo(row, col-1, grid, paths) 
			+ countPathsGenMemo(row-1, col, grid, paths);
		
		//return 0;
		//System.out.format("\n(%d, %d), grid[%d][%d] : paths = %d", row, col, (m-row), (n-col), paths);
		return paths[m-row][n-col];
	}

	static int it = 0;
	public static int countPaths(int row, int col, int[][] grid) {
		it++;
		if (!isValidSquare(row, col, grid)) return 0;
		if (isAtEnd(row, col, grid)) return 1;
		return countPaths(row + 1, col, grid) + countPaths(row, col + 1, grid);
	}
	private static boolean isValidSquare(int row, int col, int[][] grid) {
		return isInBounds(row, col, grid) && !isBlocked(row, col, grid);
	}
	public static boolean isBlocked(int row, int col, int[][] grid) {
		return grid[row][col] == 1;
	}
	public static boolean isInBounds(int row, int col, int[][] grid) {
		return (row < grid.length && col < grid[0].length);
	}
	private static boolean isAtEnd(int row, int col, int[][] grid) {
		// Does ORing instead of ANDing works more efficiently??
		// return grid.length - 1 == row && grid[row].length - 1 == col;
		return grid.length - 1 == row || grid[row].length - 1 == col; 
	}
	
	static int it1 = 0;
	private static int countPathsMemo(int row, int col, int[][] grid, int[][] paths) {
		//System.out.print("\n["+row+"]["+col+"] -- iteration = " + it1++);
		it1++;
		
		if (!(row < grid.length && col < grid[0].length) || 
				(grid[row][col] == -1)) return 0;
		
		//if (grid.length - 1 == row && grid[row].length - 1 == col) return 1;
		if (grid.length - 1 == row || grid[row].length - 1 == col) return 1;
		
		if (paths[row][col] == 0) {
			paths[row][col] = countPathsMemo(row + 1, col, grid, paths) 
					+ countPathsMemo(row, col + 1, grid, paths);
		}
		
		return paths[row][col]; 
	}
	
	
	/**
	 * 
	 * 
	 * 		  n	 n-1					  1
	 * start---------------------------------
	 * (m×n)|	|	|	|	|	|	|	|	|
	 * 		---------------------------------
	 * 	m-1	|	|	|**	|	|	|	|**	|	|
	 * 		---------------------------------
	 * 		|	|	|	|**	|	|	|	|
	 * 		---------------------------------
	 * 		|**	|	|**	|	|	|**	|	|	|
	 * 		---------------------------------
	 * 		|	|	|**	|	|	|	|	|	|
	 * 		---------------------------------
	 * 		|	|	|	|**	|**	|	|**	|	|
	 * 		---------------------------------
	 * 		|	|**	|	|	|	|**	|	|	|
	 * 		---------------------------------
	 * 	1	|	|	|	|	|	|	|	|	|
	 * 		--------------------------------- end (1×1)
	 * 
	 * 
	 * */

//	countPathsGeneric (8×8) : 3432, iterations: 6863
//	countPaths (8×8) : 3432, iterations: 18875
//	countPathsMemo (8×8) : 3432, iterations: 127
//	countPaths (8×8) #-1 : 27, iterations: 415
//	countPathsMemo (8×8) #-1 : 27, iterations: 91
	
//	countPathsGeneric (8×8) : 3432, iterations: 6863
//	countPaths (8×8) : 3432, iterations: 6863
//	countPathsMemo (8×8) : 3432, iterations: 127
//	countPaths (8×8) #-1 : 27, iterations: 209
//	countPathsMemo (8×8) #-1 : 27, iterations: 91


//	countPathsGeneric (8×8) : 3432, iterations: 6863
//	countPaths (8×8) : 3432, iterations: 6863
//	countPathsMemo (8×8) : 3432, iterations: 127
//	countPathsGenMemo (8×8) : 3432, iterations: 6863 -- BEFORE
//	countPaths (8×8) #-1 : 27, iterations: 209
//	countPathsMemo (8×8) #-1 : 27, iterations: 91
//	countPathsGenMemo (8×8) #-1 : 27, iterations: 209 -- BEFORE
//
//	countPathsGeneric (8×8) : 3432, iterations: 6863
//	countPaths (8×8) : 3432, iterations: 6863
//	countPathsMemo (8×8) : 3432, iterations: 127
//	countPathsGenMemo (8×8) : 3432, iterations: 99 -- AFTER
//	countPaths (8×8) #-1 : 27, iterations: 209
//	countPathsMemo (8×8) #-1 : 27, iterations: 91
//	countPathsGenMemo (8×8) #-1 : 27, iterations: 67 -- AFTER

//	*** with a 3*4 grid without obstacles *** 
//
//	countPathsGeneric (3×4) : 10, iterations: 19
//	countPaths (3×4) : 10, iterations: 19
//	countPathsMemo (3×4) : 10, iterations: 23
//	countPathsGenMemo (3×4) : 10, iterations: 13
//
//	*** with a 3*4 grid WITH obstacles *** 
//	countPaths (3×4) #-1 : 0, iterations: 3
//	countPathsMemo (3×4) #-1 : 0, iterations: 3
//	countPathsGenMemo (3×4) #-1 : 0, iterations: 3
//	
//	*** with a 3*4 grid WITH obstacles *** 
//	countPaths (3×4) #-1 : 4, iterations: 13
//	countPathsMemo (3×4) #-1 : 4, iterations: 21 // THere was mistake in the code!
//	countPathsGenMemo (3×4) #-1 : 4, iterations: 11
	
//	*************************************************
//	ANDing
//	*** with a 3*4 grid without obstacles *** 
//
//	countPathsGeneric (3×4) : 10, iterations: 19
//	countPaths (3×4) : 10, iterations: 19
//	countPathsMemo (3×4) : 10, iterations: 23
//	countPathsGenMemo (3×4) : 10, iterations: 13
//
//	*** with a 3*4 grid WITH obstacles *** 
//	countPaths (3×4) #-1 : 10, iterations: 19
//	countPathsMemo (3×4) #-1 : 4, iterations: 21
//	countPathsGenMemo (3×4) #-1 : 4, iterations: 11
	
//	*************************************************
//	ANDing	
}
