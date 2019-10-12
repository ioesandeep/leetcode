package medium;

import java.util.*;

public class RandomizedSet {
    Map<Integer, Integer> nums;
    List<Integer> list;
    int size;

    public RandomizedSet() {
        nums = new HashMap<>();
        list = new ArrayList<>();
        size = 0;
    }

    public boolean insert(int val) {
        if (nums.containsKey(val)) {
            return false;
        }

        nums.put(val, size);
        list.add(size, val);

        size++;

        return true;
    }

    public boolean remove(int val) {
        if (!nums.containsKey(val)) {
            return false;
        }

        int id = nums.remove(val);

        //swap with last item in list
        int last = size - 1;
        int temp = list.get(last);
        list.set(last, list.get(id));
        list.set(id, temp);

        //replace the id of temp in hashmap
        nums.replace(temp, id);

        size--;

        return true;
    }

    public int getRandom() {
        Random r = new Random();
        int id = r.nextInt(size);
        return list.get(id);
    }
}
