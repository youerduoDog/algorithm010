学习笔记
从昨天开始才真正开始算法训练营的学习，前两周一直忙私事儿（离职、找房搬家），处于请假状态，
今天把视频恶补了一下，暂时谈不上有什么收获，这需要大量时间的积累和连续付出才
会有所感悟，从第四周开始，我会认证写自己的学习总结，希望收获满满。


//原谅我实在没有思路，照抄一遍，先把作业交了


//二叉树的最近公共祖先

class Solution {

    private TreeNode ans;

    public Solution() {
        this.ans = null;
    }

    private boolean dfs(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return false;
        boolean lson = dfs(root.left, p, q);
        boolean rson = dfs(root.right, p, q);
        if ((lson && rson) || ((root.val == p.val || root.val == q.val) && (lson || rson))) {
            ans = root;
        } 
        return lson || rson || (root.val == p.val || root.val == q.val);
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        this.dfs(root, p, q);
        return this.ans;
    }
}


//组合

class Solution {
  List<List<Integer>> output = new LinkedList();
  int n;
  int k;

  public void backtrack(int first, LinkedList<Integer> curr) {
    // if the combination is done
    if (curr.size() == k)
      output.add(new LinkedList(curr));

    for (int i = first; i < n + 1; ++i) {
      curr.add(i);
      backtrack(i + 1, curr);
      curr.removeLast();
    }
  }

  public List<List<Integer>> combine(int n, int k) {
    this.n = n;
    this.k = k;
    backtrack(1, new LinkedList<Integer>());
    return output;
  }
}