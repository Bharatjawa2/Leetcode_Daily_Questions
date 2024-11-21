class Solution {
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        int[][] grid=new int[m][n];
        for(int[] i:guards){
            int x=i[0];
            int y=i[1];
            grid[x][y]=2;
        }
        for(int[] i:walls){
            int x=i[0];
            int y=i[1];
            grid[x][y]=3;
        }
        int count=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==2){
                    solve(grid,i,j);
                }
            }
        }

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==0) count++;
            }
        }
        return count;
    }

    void solve(int[][] grid,int row,int col){
        int m=grid.length;
        int n=grid[0].length;
        int[] dr={0,0,1,-1};
        int[] dc={1,-1,0,0};
        for(int i=0;i<4;i++){
            int nrow=row+dr[i];
            int ncol=col+dc[i];

            solve1(grid,nrow,ncol,dr[i],dc[i]);
            }
    }

    void solve1(int[][] grid,int row,int col,int x,int y){
        int m=grid.length;
        int n=grid[0].length;
        while(row>=0 && row<m && col>=0 && col<n){
            if(grid[row][col]==2 || grid[row][col]==3) break;
            if(grid[row][col]==0) grid[row][col]=1;
            row+=x;
            col+=y;
        }
    }
}
