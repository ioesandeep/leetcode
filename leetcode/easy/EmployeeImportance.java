package leetcode.easy;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EmployeeImportance {
    class Employee {
        // It's the unique id of each node;
        // unique id of this employee
        public int id;
        // the importance value of this employee
        public int importance;
        // the id of direct subordinates
        public List<Integer> subordinates;
    }

    public int getImportance(List<Employee> employees, int id) {
        Map<Integer, Employee> map = new HashMap<>();
        for (Employee e : employees) {
            map.put(e.id, e);
        }

        return sumImportance(map.get(id), 0, map);
    }

    int sumImportance(Employee e, int importance, Map<Integer, Employee> map) {
        importance += e.importance;
        if (e.subordinates.size() == 0) {
            return importance;
        }
        for (Integer id : e.subordinates) {
            importance = sumImportance(map.get(id), importance, map);
        }
        return importance;
    }
}
