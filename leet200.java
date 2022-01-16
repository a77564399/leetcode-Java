public class leet200 {
//    static int[][] grid = new int[][] {{1,1,1,1,0},{1,1,0,1,0},{1,1,0,0,0},{0,0,0,0,0}};
    static int[][] grid = new int[][]     { {1,1,0,0,0}, {1,1,0,0,0}, {0,0,1,0,0}, {0,0,0,1,1} }
        ;
    public static void main(String[] args) {
        int res=0;
        int row = grid.length;
        int col = grid[0].length;
        int all = grid.length*grid[0].length;
        UnionFind uf = new UnionFind(grid);
        int[][] directions = new int[][] {{-1,0},{1,0},{0,-1},{0,1}};//定义偏移量，找到1后从其上下左右四个方向寻找1并进行同化(设置共同祖先)
        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[0].length;j++)
            {
                if(grid[i][j]==1)
                {
                    for(int[] d:directions) {
                        int x = i+d[0];
                        int y = j+d[1];
                        if(x>=0&&x<row&&y>=0&&y<col&&grid[x][y]==1){
                            uf.quickUnion(i*col+j,x*col+y);
                        }
                    }
                }else {
                    all--;
                }
            }
        }
        System.out.println(all-uf.getUniunNum());
    }

}
