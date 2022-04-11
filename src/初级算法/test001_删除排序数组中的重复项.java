package 初级算法;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/x2gy9m/
 *
 * 删除排序数组中的重复项
 *
 * 给你一个 升序排列 的数组 nums ，请你 原地 删除重复出现的元素，使每个元素 只出现一次 ，返回删除后数组的新长度。元素的 相对顺序 应该保持 一致 。
 * 由于在某些语言中不能改变数组的长度，所以必须将结果放在数组nums的第一部分。更规范地说，如果在删除重复项之后有 k 个元素，那么 nums 的前 k 个元素应该保存最终结果。
 * 将最终结果插入 nums 的前 k 个位置后返回 k 。
 * 不要使用额外的空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 *
 */
public class test001_删除排序数组中的重复项 {

    public static void main(String[] args) {
        int[] nums = { 1, 1, 2, 3, 4, 4, 5, 6 };
        int length = removeDuplicates(nums);
        System.out.println("len:"+length);
        Arrays.stream(nums).forEach(System.out::print);
        System.out.println();
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
        return ++left;
    }

    public static int removeDuplicates1(int[] A) {
        int count = 0; //重复的数字个数
        for (int right = 1; right < A.length; right++) {
            if (A[right] == A[right - 1]) {
                //如果有重复的，count要加1
                count++;
            } else {
                //如果没有重复的，后面的就往前挪
                A[right - count] = A[right];
            }
        }
        //数组的长度减去重复的个数
        return A.length - count;
    }
}
