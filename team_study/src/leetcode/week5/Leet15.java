package leetcode.week5;

import java.util.*;

public class Leet15 {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Set<List<Integer>> set = new HashSet<>();

        int length = nums.length;
        Arrays.sort(nums);

        for (int i = 1; i < length; i++) {
            int j = i - 1;
            int k = i + 1;
            while (true) {
                if (j == -1) {
                    break;
                } else if (k == length) {
                    break;
                }

                if (nums[j] + nums[i] + nums[k] == 0) {
                    set.add(List.of(nums[j], nums[i], nums[k]));
                    j--;
                } else if (nums[j] + nums[i] + nums[k] > 0) {
                    j--;
                } else {
                    k++;
                }
            }

        }

        for (List<Integer> i : set) {
            list.add(i);
        }

        return list;
    }
}
