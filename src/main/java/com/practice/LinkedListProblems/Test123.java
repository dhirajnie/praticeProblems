package com.practice.LinkedListProblems;

public class Test123
{

    static int ROW, COL, count;


    public static void main( String args[] )
    {
        int row = 3;
        int col = 2;
        int matrix[][] = new int[row + 1][col + 1];

        int sizeOfRowRodRemoval = 3;
        int sizeOfColRodRemoval = 2;
        int rowindexRodToRemove[] = { 1, 2, 3 };
        int colindexRodToRemove[] = { 1, 2 };

        ROW = row + 1;
        COL = col + 1;


        for ( int i = 0; i < rowindexRodToRemove.length; i++ ) {
            removeColRod( matrix, rowindexRodToRemove[i],  col+ 1 );
        }
        for ( int i = 0; i < colindexRodToRemove.length; i++ ) {
            removeRowRod( matrix, colindexRodToRemove[i], row + 1 );
            print( matrix, row + 1, col + 1 );
        }

        System.out.println( largestRegion(matrix) );

    }


    private static int getMaxArea( int[][] matrix, int ROW, int COL )
    {
        int currentMax = Integer.MIN_VALUE;
        for ( int x = 0; x < ROW; x++ ) {
            int i = x;
            int j = i;
            int counter = 0;
            while ( j < COL && i < ROW && matrix[i][j] == 1 ) {
                ++counter;
                ++i;
                ++j;

            }
            if ( counter > currentMax )
                currentMax = counter;
        }
        return currentMax * currentMax;

    }


    private static void removeColRod( int[][] matrix, int index, int colSize )
    {
        for ( int i = index - 1; i < index + 1; i++ ) {
            for ( int j = 0; j < colSize; j++ ) {
                matrix[i][j] = 1;
            }
        }
    }


    private static void removeRowRod( int[][] matrix, int index, int rowSize )
    {
        for ( int i = index - 1; i < index + 1; i++ ) {
            for ( int j = 0; j < rowSize; j++ ) {
                matrix[j][i] = 1;
            }
        }
    }


    static void print( int matrix[][], int rowSize, int colSize )
    {
        for ( int i = 0; i < rowSize; i++ ) {
            for ( int j = 0; j < colSize; j++ ) {
                System.out.print( matrix[i][j] );
            }
            System.out.println( "\n" );

        }
        System.out.println();
    }


    // A function to check if a given cell (row, col)
    // can be included in DFS
    static boolean isSafe(int[][] M, int row,
        int col, boolean[][] visited)
    {
        // row number is in range, column number is in
        // range and value is 1 and not yet visited
        return ((row >= 0) && (row < ROW) && (col >= 0)
            && (col < COL) && (M[row][col] == 1 &&
            !visited[row][col]));
    }

    // A utility function to do DFS for a 2D boolean
    // matrix. It only considers the 8 neighbours as
    // adjacent vertices
    static void DFS(int[][] M, int row,
        int col, boolean[][] visited)
    {
        // These arrays are used to get row and column
        // numbers of 8 neighbours of a given cell
        int[] rowNbr = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] colNbr = {-1, 0, 1, -1, 1, -1, 0, 1};

        // Mark this cell as visited
        visited[row][col] = true;

        // Recur for all connected neighbours
        for (int k = 0; k < 8; k++)
        {
            if (isSafe(M, row + rowNbr[k], col + colNbr[k], visited))
            {
                // increment region length by one
                count++;
                DFS(M, row + rowNbr[k], col + colNbr[k], visited);
            }
        }
    }

    // The main function that returns largest length region
    // of a given boolean 2D matrix
    static int largestRegion(int[][] M)
    {
        // Make a boolean array to mark visited cells.
        // Initially all cells are unvisited
        boolean[][] visited = new boolean[ROW][COL];

        // Initialize result as 0 and traverse through the
        // all cells of given matrix
        int result = 0;
        for (int i = 0; i < ROW; i++)
        {
            for (int j = 0; j < COL; j++)
            {

                // If a cell with value 1 is not
                if (M[i][j] == 1 && !visited[i][j])
                {

                    // visited yet, then new region found
                    count = 1;
                    DFS(M, i, j, visited);

                    // maximum region
                    result = Math.max(result, count);
                }
            }
        }
        return result;
    }


}
