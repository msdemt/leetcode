package 初级算法;

public class 删除排序数组中的重复项 {

    public static void main(String[] args) {
        int[] nums = { 1, 1, 2, 3, 4, 4, 5, 6 };
        int length = removeDuplicates(nums);
        System.out.println(length);
    }

    //双指针解决
    public static int removeDuplicates(int[] A) {
        //边界条件判断
        if (A == null || A.length == 0) {
            return 0;
        }
        int left = 0;
        for (int right = 1; right < A.length; right++) {
            //如果左指针和右指针指向的值一样，说明有重复值
            //这个时候，左指针不懂，右指针继续往右移。
            //如果他俩指向的值不一样，就把左指针右移，然后右指针的值赋给左指针
            if (A[right] != A[left]) {
                A[++left] = A[right];
            }
        }
        return left++;
    }
}
