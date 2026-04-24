// Binary search used for rows, then binary search in selected row

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {

        int noOfRows = matrix.length, col=matrix[0].length;

        // If value is out of bound ie < first value and > last value
        // As values are sorted.. we return false
        if(target<matrix[0][0] || target>matrix[noOfRows-1][col-1])
            return false;
        
        int firstRow=0,lastRow=matrix.length-1,reqRow=0;

        while(firstRow<=lastRow) {
            int mid=firstRow + (lastRow-firstRow)/2;
            
            if(matrix[mid][0]<=target && matrix[mid][col-1]>=target) {
            reqRow=mid;
            break;
            } else if(matrix[mid][0]>target) {
                lastRow=mid-1;
            } else {
                firstRow=mid+1;
            }           

        }

       

            int j=0,k=matrix[reqRow].length-1;

            if(target==matrix[reqRow][j] || target==matrix[reqRow][k])
                return true;

            int mid = 0;
            while(j<=k) {             
                mid = j + (k-j)/2;
                if(target==matrix[reqRow][mid])
                return true;
                else if(target>matrix[reqRow][mid])
                j=mid+1;
                else 
                k=mid-1;
            }
        

        return false;
        
    }
}
