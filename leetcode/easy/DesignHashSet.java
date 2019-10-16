package leetcode.easy;

import java.util.Arrays;

public class DesignHashSet {
    int[] arr;

    public DesignHashSet() {
        arr = new int[100000];
        Arrays.fill(arr, -1);
    }

    int hash(int key) {
        return key % arr.length;
    }

    public void add(int key) {
        int id = hash(key);

        //dont need to add it again
        if (arr[id] == key) {
            return;
        }

        if (arr[id] == -1) {
            arr[id] = key;
            return;
        }

        //collision
        int i = id;
        while (i < arr.length && arr[i] > -1) {
            if (arr[i++] == key) {
                return;
            }
        }

        if (i < arr.length && arr[i] == -1) {
            arr[i] = key;
        }
    }

    public void remove(int key) {
        int id = hash(key);

        if (arr[id] == key) {
            arr[id] = -1;
            return;
        }

        int i = id;
        while (i < arr.length && arr[i] != key) {
            ++i;
        }

        if (i < arr.length && arr[i] == key)
            arr[i] = -1;
    }

    /**
     * Returns true if this set contains the specified element
     */
    public boolean contains(int key) {
        int id = hash(key);
        if (arr[id] == -1) {
            return false;
        }

        while (id < arr.length && arr[id] > -1) {
            if (arr[id++] == key) {
                return true;
            }
        }

        return false;
    }
}
