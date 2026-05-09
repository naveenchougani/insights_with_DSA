// Easy example for this is Do a Transpose. After the at every row.. reverse them. This becomes 90% rotation clock wise .
// Look at the below example.
(0,0) [1]    (0,1) [2]    (0,2) [3]
(1,0) [4]    (1,1) [5]    (1,2) [6]
(2,0) [7]    (2,1) [8]    (2,2) [9]
Transpose (Swap [i][j] with [j][i])

  Swap matrix[0][1] (2) with matrix[1][0] (4)
  Swap matrix[0][2] (3) with matrix[2][0] (7)
  Swap matrix[1][2] (6) with matrix[2][1] (8)
  
1  4  7   <-- Row 0 is the old Col 0
2  5  8   <-- Row 1 is the old Col 1
3  6  9   <-- Row 2 is the old Col 2

Reversing the above transpose matrix every row makes the belwo resulst

7  4  1
8  5  2
9  6  3

  The above matrix is the 90 rotation of the belwo matrix.
  
1 2 3
4 5 6
7 8 9

Java Implementation code
==========================
  
    public void rotate(int[][] matrix) {

        int n = matrix.length;

        // here j woudl always i+1 helps to look at upper triagnle
        // j = i + 1 helps to look only at the numbers above the diagonal
        // like i incremtne every row and j increments next to it
        // so it swaps with its elemnst below diagonal
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i]=temp;
            }
        }

    // at every row.. we would only traverse through the half way of help of j
    // because with 4 elements, you swap 0 with 3, and 1 with 2. Then you stop.
    // Else if j runs to 3.. ie when it reach to 2 and 3,
    // It again swaps them to original position. So its important to avoid it

        for(int i=0;i<n;i++){
            for(int j=0;j<n/2;j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n-1-j];
                matrix[i][n-1-j] = temp;
            }
        }

    }
