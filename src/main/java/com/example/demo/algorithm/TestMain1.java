package com.example.demo.algorithm;

import com.google.common.collect.Maps;

import java.util.Map;

/**
 * 给定一个数组和一个目标和，从数组中找两个数字相加等于目标和，输出这两个数字的下标。
 */
public class TestMain1 {

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4,5,6,7,8};
        int target = 9;

        System.out.println(test1(nums, target));
        System.out.println(test2(nums, target));
        System.out.println(test3(nums, target));

    }

    /**
     * 解法一
     * 两重循环，遍历所有情况看相加是否等于目标和，如果符合直接输出
     *
     * 时间复杂度：两层 for 循环，O（n²）
     * 空间复杂度：O（1）
     */
    private static int[] test1(int[] nums, int target){
        int[] arr = new int[2];
        for (int i = 0; i < nums.length; i++){
            for (int j = i + 1; j < nums.length; j++){
                if (nums[i] + nums[j] == target) {
                    arr[0] = i;
                    arr[1] = j;
                    System.out.println(arr[0] + "-1-" + arr[1]);
                    return arr;
                }
            }
        }
        System.out.println(arr[0] + "-1-" + arr[1]);
        return arr;
    }

    /**
     * 解法二
     * 有没有一种方法，不用遍历就可以找到元素里有没有等于 sub 的？
     * hash table ！！！
     * 我们可以把数组的每个元素保存为 hash 的 key，下标保存为 hash 的 value 。
     * 这样只需判断 sub 在不在 hash 的 key 里就可以了，而此时的时间复杂度仅为 O（1）！
     * 需要注意的地方是，还需判断找到的元素不是当前元素，因为题目里讲一个元素只能用一次。
     */
    private static int[] test2(int[] nums, int target){
        Map<Integer, Integer> map = Maps.newHashMap();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            int sub = target - nums[i];
            if (map.containsKey(sub) && map.get(sub) != i){
                System.out.println(i + "-2-" + map.get(sub));
                return new int[]{i, map.get(sub)};
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    /**
     * 解法三
     * 将解法二的两个循环合并起来
     */
    private static int[] test3(int[] nums, int target){
        Map<Integer, Integer> map = Maps.newHashMap();
        for (int i = 0; i < nums.length; i++) {
            int sub = target - nums[i];
            if (map.containsKey(sub)){
                System.out.println(i + "-2-" + map.get(sub));
                return new int[]{i, map.get(sub)};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }

}
