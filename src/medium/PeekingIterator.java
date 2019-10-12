package medium;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class PeekingIterator implements Iterator<Integer> {
    List<Integer> arr;
    int cursor = 0;

    public PeekingIterator(Iterator<Integer> iterator) {
        arr = new ArrayList<>();
        cursor = 0;
        while (iterator.hasNext()) {
            arr.add(iterator.next());
        }

    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        return arr.get(0);
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        return arr.remove(0);
    }

    @Override
    public boolean hasNext() {
        return arr.size() > 0;
    }
}
