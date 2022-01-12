import java.util.ArrayList;
import java.util.List;

public class leet78 {

    private List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();//结果数组
        backtrack(list,new ArrayList<>(),nums,0);//结果数组、临时数组、搜索内容、开始节点
        return list;
    }
    public void backtrack(List<List<Integer>> list,List<Integer> templist,int[] nums,int start){
        list.add(new ArrayList<>(templist));
        for(int i=start;i<nums.length;i++){//从i节点开始向后遍历
            templist.add(nums[i]);//将此节点加入到数组中
            backtrack(list,templist,nums,i+1);//dfs
            templist.remove(templist.size()-1);//去除此节点遍历另外分支
        }
    }
    public static void main(String[] args) {
        int[] a = {1,2,3};
        System.out.println(DfsSubset(a));

    }

    public static List<List<Integer>> subsets1(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();//先把一个空数组加入到序列中去
        list.add(new ArrayList<>());
        for(int i=0;i<nums.length;i++){
            List<List<Integer>> temp = new ArrayList<>(list);//把结果列表里面的内容单独建一个，防止不断添加
            for(List l:temp){
                List addList = new ArrayList<>(l);//遍历结果数组中的内容，将此元素加入到这个数组中然后加入到结果中
                addList.add(nums[i]);
                list.add(addList);
            }
        }
        return list;
    }

    public static List<List<Integer>> DfsSubset(int[] nums){
        List<List<Integer>> res = new ArrayList<>();
        DFS(nums,res,new ArrayList<Integer>(),0);
        return res;
    }

    private static void DFS(int[] nums, List<List<Integer>> res, ArrayList<Integer> subset, int index) {
        res.add(new ArrayList<>(subset));//此处新建数组，防止引用传递
        if(index==nums.length)
            return;
        for(int i=index;i<nums.length;i++)//走完1，2，3之后，返回到2，然后返回到1，i=2的走完了，该i=3的了？？
        {
            subset.add(nums[i]);
            DFS(nums,res,subset,i+1);
            subset.remove(subset.size()-1);
        }
    }


}
