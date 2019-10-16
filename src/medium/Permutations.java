package medium;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        if (nums.length == 0) {
            return null;
        }

        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            numbers.add(nums[i]);
        }

        return permute(numbers);
    }

    List<List<Integer>> permute(List<Integer> numbers) {
        List<List<Integer>> list = new ArrayList<>();
        if (numbers.size() == 0) {
            list.add(new ArrayList<>());
            return list;
        }

        int num = numbers.remove(0);
        List<List<Integer>> permutes = permute(numbers);
        for (List<Integer> permute : permutes) {
            // <= ->insert in the end
            for (int i = 0; i <= permute.size(); i++) {
                List<Integer> permutation = insert(permute, num, i);
                list.add(permutation);
            }
        }

        return list;
    }

    List<Integer> insert(List<Integer> permutation, Integer num, int position) {
        List<Integer> copy = new ArrayList<>();
        copy.addAll(permutation);
        copy.add(position, num);
        return copy;
    }
}
