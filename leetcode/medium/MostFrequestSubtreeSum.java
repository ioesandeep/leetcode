package leetcode.medium;

import leetcode.easy.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MostFrequestSubtreeSum {
    Map<Integer, Integer> counter;
    int maxCount;

    public int[] findFrequentTreeSum(TreeNode root) {
        counter = new HashMap<>();
        maxCount = Integer.MIN_VALUE;

        findSums(root, 0);
        List<Integer> sum = new ArrayList<>();
        for (Map.Entry<Integer, Integer> count : counter.entrySet()) {
            if (count.getValue() == maxCount) {
                sum.add(count.getKey());
            }
        }
        int[] result = new int[sum.size()];
        for (int i = 0; i < sum.size(); i++) {
            result[i] = sum.get(i);
        }

        return result;
    }

    int findSums(TreeNode root, int sum) {
        if (root == null) {
            return sum;
        }

        sum += root.val;
        sum += findSums(root.left, 0);
        sum += findSums(root.right, 0);
        counter.put(sum, counter.getOrDefault(sum, 0) + 1);
        if (counter.get(sum) > maxCount) {
            maxCount = counter.get(sum);
        }
        return sum;
    }
}
