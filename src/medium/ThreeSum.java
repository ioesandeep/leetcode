package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class ThreeSum {
    class Triplet {
        int a;
        int b;
        int c;

        Triplet(int a, int b, int c) {
            int[] arr = {a, b, c};
            Arrays.sort(arr);
            this.a = arr[0];
            this.b = arr[1];
            this.c = arr[2];
        }

        public int hashCode() {
            int hash = 7;
            hash *= 31 * hash;
            hash = hash + a + b + c;
            ;
            return hash;
        }

        public List<Integer> toList() {
            List<Integer> list = new ArrayList<>();
            list.add(a);
            list.add(b);
            list.add(c);
            return list;
        }

        public boolean equals(Object obj) {
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            if (obj == this) {
                return true;
            }
            Triplet t = (Triplet) obj;
            return t.a == a && t.b == b && t.c == c;
        }
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<Triplet> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            twoSum(nums, i, nums[i] * -1, result);
        }
        List<List<Integer>> output = new ArrayList();
        for (Triplet triplet : result) {
            output.add(triplet.toList());
        }
        return output;
    }

    void twoSum(int[] nums, int id, int target, List<Triplet> output) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = id + 1; i < nums.length; i++) {
            int num = nums[i];
            if (map.containsKey(target - num)) {
                Triplet t = new Triplet(target * -1, map.get(target - num), num);
                if (!output.contains(t)) {
                    output.add(t);
                }
                continue;
            }
            map.put(num, num);
        }
    }
}
