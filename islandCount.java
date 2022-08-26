class Solution {
    public int numIslands(char[][] grid) {
        int islandCount = 0;
        for(int row=0; row<grid.length; row++ ){
            for(int column =0; column< grid[row].length; column++){
                if(grid[row][column] == '1'){
                    islandCount=islandCount+1;
                    dfsCall(grid, row, column);
                }
            }
        }
        return islandCount;
    }
    
    private void dfsCall(char[][] grid, int row, int column){
        if( row<0 || row >=grid.length || column>=grid[row].length || column<0 || grid[row][column]!='1'){
            return;
        }
        grid[row][column]='0';
        dfsCall(grid, row-1, column); //UP
        dfsCall(grid, row, column+1); //RIGHT
        dfsCall(grid, row+1, column); //DOWN
        dfsCall(grid, row, column-1); //LEFT
    }
}
