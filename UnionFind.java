public class UnionFind {
    private int[] root = null;
    private int[] rank = null;
    private int uniunNum = 0;
    public UnionFind(int[][] grid)
    {
        int rowNum = grid.length;
        int colNum = grid[0].length;
        root = new int[rowNum*colNum];
        rank = new int[rowNum*colNum];
        for(int i=0;i<rowNum*colNum;i++)
        {
            root[i] = i;
            rank[i] = 0;
        }
    }
    public int Find(int x)
    {
        if(x==root[x])
            return x;
        else {
            return Find(root[x]);
        }
    }
    public void Union(int x,int y)
    {
        int rootX = Find(x);
        int rootY = Find(y);
        if(rootX!=rootY){
            root[rootX]=rootY;//注意，此处是修改根节点的祖先，不是直接改当前节点的。会出现链条断的情况
        }
    }
    public int quickFind(int x){
        if(x==root[x])
            return x;
        else {
            return root[x]=Find(root[x]);//每次查询的时候，都把当前节点的根节点直接关联到祖先上
        }
    }
    public void quickUnion(int x,int y)
    {
        int rootX = quickFind(x);
        int rootY = quickFind(y);
        if(rootX!=rootY)
        {
            uniunNum++;
            if(rank[rootX]<rank[rootY]){
                root[rootX]=rootY;
            }else if(rank[rootX]>rank[rootY]){
                root[rootY]=rootX;
            }else {
                root[rootX] = rootY;
                rank[rootY]+=1;
            }
        }
    }

    public int getUniunNum() {
        return uniunNum;
    }
}
