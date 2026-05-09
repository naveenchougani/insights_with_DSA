// given array if you find a cell with 1.. you have check left, right and up and down whose values are of 1 and count it cell count as area
// Give the maximum area of such cells of continuous 1's in an square or horizontal way i.e, up down left and right

public int maxAreaOfIsland(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int maxArea = 0;

        for(int i=0; i<rows; i++) {
            for( int j=0; j<cols; j++) {
                if(grid[i][j]==1) {
                    maxArea = Math.max(maxArea,findGridArea(i,j,grid));  // here findGridArea would recurisvely works and stops until its left,
                                                                        // right, top, bottom cells were explored 
                }
            }
        }

        return maxArea;
    }

    public int findGridArea(int row, int col, int[][] grid) {
        // as part of recursive functional call our base condition is
        // if row / col goes out of array bounds, or if grid cell hits 0, we stop
        if(row<0 || row>grid.length-1 ||
         col<0 || col>grid[0].length-1 || 
         grid[row][col]==0)
        return 0;

        // Else now make the current grid cell to Zero like we mark it 0
        // So it helps to avoid research again and it would be counted in the return
        grid[row][col]=0;

        // This return funciton is a combo of current cell area count
        // along with findGridArea grid should check up row+1, down row-1
        // along with findGridArea grid should check right col+1,left col-1;
        // If you specifically understand the flow..
        // It first go top and break, then down and break, then right and break
        // then left and break. The values are captured in stack at that time
        // providing you the correct variable values hence it works
        return 1+findGridArea(row+1,col,grid)   
                +findGridArea(row-1,col,grid)
                +findGridArea(row,col+1,grid)
                +findGridArea(row,col-1,grid);
    }
}
