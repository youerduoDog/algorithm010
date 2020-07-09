
class Solution {
    /**
     * 移动零
     * 题目一描述：给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
     *
     * 示例:
     * 输入: [0,1,0,3,12]
     * 输出: [1,3,12,0,0]
     *
     * 说明:
     * 1、必须在原数组上操作，不能拷贝额外的数组。
     * 2、尽量减少操作次数。
     */
    public void moveZeroes(int[] nums) {
        //用j指针用来记录非零元素，在循环中j++，每次将非零元素放到j++的位置
        int j = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] == 0) {
                nums[j++] = nums[i];
            }
        }
        //上面处理完非零的元素，接下来处理为0的元素，这里有个地方需要注意，是从j这个位置开始循环
        //在上面的循环中，j的值已经累加过了，在nums[j++]中对j已经做了++处理
        for (int i = j; i < nums.length; ++i) {
            nums[i] = 0;
        }
        //小技术点：需要注意++i和i++的区别
        // ++i是先做增加赋值的操作，也就是如果i本身等于0的话，则++i就等于1
        //i++是先采用当前的值，等当前值呗操作完之后，再做增加赋值的操作，比如：i为0的话，则i++也零，等当前操作结束后，下次再次进入循环体时，则i++等1
    }

    /**
     * 爬楼梯
     * 题目二描述：假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
     * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
     *
     * 注意：给定 n 是一个正整数。
     *
     * 示例 1：
     * 输入： 2
     * 输出： 2
     * 解释： 有两种方法可以爬到楼顶。
     * 1.  1 阶 + 1 阶
     * 2.  2 阶
     *
     *
     * 示例 2：
     * 输入： 3
     * 输出： 3
     * 解释： 有三种方法可以爬到楼顶。
     * 1.  1 阶 + 1 阶 + 1 阶
     * 2.  1 阶 + 2 阶
     * 3.  2 阶 + 1 阶
     *
     * @param n
     */
    public void climbStairs(int n) {




    }


    /**
     * 盛水最多的容器
     * 题目描述：给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，
     * 垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
     *
     * 说明：你不能倾斜容器，且 n 的值至少为 2。
     *
     *
     * 图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
     *
     *
     * 示例：
     * 输入：[1,8,6,2,5,4,8,3,7]
     * 输出：49
     *
     * @param height
     * 双指针法
     */
    public void maxArea(int[] height) {
        //首先，假定数组是给定的，数组长度和数组元素都是给定定的，可以拿给出的例子作为按理分析
        // 根据合适的数组长度和适当的最大的数组元素的乘积就是我们要求的最大面积（也就是宽*高，得到最大面积）
        //Math的API要运用熟练
        int res = 0;    //给出面积
        int i = 0;  //最左边的角标（指针）
        int j = height.length - 1;  //最右边的角标
        while (i < j) {
            //宽度乘以高度（因为是盛水，所以高度是元素中最小的值）
            int area = (j - i) * Math.min(height[i],height[j]);

            res = Math.max(res,area);
            //如果i柱子比j柱子低，则向右移动i，否则向左移动j
            if (height[i] < height[j]) {
                i++;
            } else {
                j--;
            }
        }
        rerun res;
    }




    //-----------------------------------------------------链表题目------------------------------------------------//

    /**
     * 反转一个单链表。
     *
     * 示例:
     * 输入: 1->2->3->4->5->NULL
     * 输出: 5->4->3->2->1->NULL
     *
     * 进阶:
     * 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
     */
    //事先定义一个链表结构
    private class ListNode {
        int val;
        ListNode next;  //只定义了向后指的指针
        ListNode(int x) { val = x; }
    }
    //方法一：循环迭代，理解链表的定义至关重要
    public ListNode reverseList1(ListNode head) {
        ListNode prev = null;   //定义一个链表对象，用来翻转
        ListNode curr = head;   //定义一个链表对象，代表当前结构
        //翻转
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;   //主要是这句话，这句话理解了就好理解下面的两句了
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }
    //方法二：递归
    public ListNode reverseList2(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode p = reverseList2(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }



















}