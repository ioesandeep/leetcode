package medium;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class NestedIterator implements Iterator<Integer> {

    Queue<Integer> queue;

    public NestedIterator(List<NestedInteger> nestedList) {
        queue = new LinkedList<>();
        buildQueue(nestedList);
    }

    void buildQueue(List<NestedInteger> nested) {
        for (NestedInteger n : nested) {
            if (n.isInteger()) {
                queue.add(n.getInteger());
                continue;
            }
            buildQueue(n.getList());
        }
    }

    @Override
    public Integer next() {
        return queue.poll();
    }

    @Override
    public boolean hasNext() {
        return !queue.isEmpty();
    }
}
