// Question was you can move right and down to reach any cell and 0,0 is starting m-1,n-1 is ending
// They give rows count and columns count as m , n create a array and store the values adn return output
// So by the above combo how many different ways we have by the end of the grid.

// Here answer changes for the every cell, you process. So we can use dp.. which store the 
// best possible answer at every calculation or every cell

// And for dp to run.. same like recursion we need atleast one correct combo to create a solution which works for other combos

// So they say you can only reach to the cell by moving right and down.. i.e,
// If you reached a cell you have come from left , or top. 
// In 2D array left and top cell would only occur if you have 2nd row and 2nd column.. minimum viable combo.
// So we will replace the rows and column with m n and will write the solution

// so grid[m][n] (current cell) = grid[m-1][n] + grid[m][n-1]  ( top cell + left cell)

// at the end grid[m][n] holds the all possible paths to it.  the above would work fine for all the combos.

// This way at every cell, the above operation would make sure it has best possible answer.

// But as per edge case first rows and first column have only one way to reach every cell,, eigth just moving right or left

// hence we make all those cell values to be 1 becasue as per unique paths they want
// **One identical direction, repeated any number of times, still results in a single unique path ** //

-----------code ------------------

    public int uniquePaths(int m, int n) {
        
        int[][] grid = new int[m][n];

        for(int i=0;i<n;i++)  // top row we move only right 
            grid[0][i]=1;     // multiple right directions at any cell, still results in a single unique path
        
        for(int i=0;i<m;i++) // first column move only down
            grid[i][0]=1;     // multiple down directions at any cell, still results in a single unique path

        for(int i=1;i<m;i++) {
            for( int j=1;j<n;j++) {
                grid[i][j] = grid[i-1][j]+grid[i][j-1];  // calculate from top , and left celss
            }
        }
        
        return grid[m-1][n-1];  // last cell would hold the value
    }
