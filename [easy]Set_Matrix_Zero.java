// in a matrix if a cell contains 0. than that corresponding whole row of that cell.. and corresponding whole column of that cell shoudl be made zero
// Looks fine.. but here the content in the every row.. are not sorted. 
// Means you must and should have to traverse each and every cell to find zero's no other way.
// Second is there any possibility to do in o(1) space.. there were new matrix and traverse original matrix and point them in the copy matrix
// So if there is possibility of doing in o(1) space.. yes but it comes with two caveats..
// First how can you make it has wihotu extra space
// We will make First Row and First Column has pointer to hold 0's so that That whole Row/Column can be made 0
// So we will not touch 0th row, 0th column, we will traverse rest of the matrxi
// IF any of the matrix[i][j] = 0  then its first row cell matrix[0][j] = 0, first column cell matrix[i][0]=0, made
// Now we will traverse through first row, if we found matrix[0][j]=0, that whole column made 0, and 
// Similary for first column, if we found matrix[i][0] = 0, then whole row made 0.
// But what if first Row, Column also contains 0.. their entrire row and column should make zero
// But this idenfitication has to be performed zero, implementation has to be perfoemed at the end just to avoid false zeros done by mid matrix.

public void setZeroes(int[][] matrix) {
  
        int rows=matrix.length, cols=matrix[0].length;
        boolean firstRowZero=false,firstColZero=false;

            // Identifying if the first row has zero
            for(int j=0;j<cols;j++){
                 if(matrix[0][j] == 0 ) {
                    firstRowZero=true;
                 }
            }

             // Identifying if the first column has zero
            for(int i=0;i<rows;i++){
                 if(matrix[i][0] == 0 ) {
                    firstColZero=true;
                 }
            }
        
        // Traverse rest of the array except first row and except first column
        for(int i=1;i<rows;i++) {
            for(int j=1;j<cols;j++) {
                  // If a cell has zero.. then its top and left is made zero to have tracking
                    if(matrix[i][j]==0) {
                        matrix[i][0]=0; // marking its top or first row cell 0
                        matrix[0][j]=0; // marking its left or first col cell 0
                    }
            }
        }   

        // Now check whole first row and fill that specific Colum Except FIRST CELL
        // Because if j=0, if the data contains 0 in the first cell.. This marks First Whole Column as Zero
        // Now the very first Column contains all 0's, It helps the next loop function to make all rows tobe zero as it starts from first column if we make j=1
        // So to avoid this edge case.. ignor that cell.. that would be taken care by firstRow and firstColumn boolean values
        // If first cell contains non zero... keeping j=0 would work
        for(int j=1;j<cols;j++){ 
             if (matrix[0][j] == 0) {
                fillThatColumn(j,rows,matrix);
             }
        }

      // Now check first column and fill that specific Row Except First cel 
      // Because if i=0, if the data contains 0 in the first cell.. as Fist column becomes zero by abvoe code
      // Now the very first Column contains all 0's, All Rows becomes Zero
      // So to avoid this edge case.. ignor that cell.. that would be taken care by firstRow and firstColumn boolean values
        // If first cell contains non zero... keeping i=0 would work
        for(int i=1;i<rows;i++){
             if (matrix[i][0] == 0) {
                fillThatRow(i,cols,matrix);
             }
        }

        if(firstRowZero){
            fillThatRow(0,cols,matrix);
        }
        if(firstColZero){
            fillThatColumn(0,rows,matrix);
        }

    }

    public void fillThatColumn(int column,int rowSize,int[][] arr) {
        for(int i=0;i<rowSize;i++){
            arr[i][column]=0;
        }
    }
    public void fillThatRow(int row,int colSize,int[][] arr) {
        for(int j=0;j<colSize;j++){
            arr[row][j]=0;
        }
    }
