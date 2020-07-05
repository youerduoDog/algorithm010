/**
 *
 */
class Fenfabingga {
    //双指针
    public int findContentChildren(int[] grid, int[] size) {
        if (grid == null || size == null) return 0;
        Arrays.sort(grid);
        Arrays.sort(size);
        int gi = 0, si = 0;
        //切忌直线思维for，因为在for中无法保证增减的单调性，用while的话保证了单调性，结合if，++或者--，从而得解
        while (gi < grid.length && si < size.length) {
            if (grid[gi] <= size[si]) {
                gi++;
            }
            si++;
        }
        return gi;
    }
}