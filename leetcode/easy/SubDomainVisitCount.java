package leetcode.easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubDomainVisitCount {
    public List<String> subdomainVisits(String[] cpdomains) {
        Map<String, Integer> map = new HashMap<>();
        for (String domain : cpdomains) {
            int count = 0;
            int left = 0;
            while (left < domain.length()) {
                char ch = domain.charAt(left);
                if (ch == ' ' || ch == '.') {
                    if (ch == ' ') {
                        count = Integer.valueOf(domain.substring(0, left));
                    }

                    String d = domain.substring(left + 1);
                    map.put(d, map.getOrDefault(d, 0) + count);
                }

                left++;
            }
        }

        List<String> result = new ArrayList<>(map.size());
        for (String domain : map.keySet()) {
            StringBuilder builder = new StringBuilder();
            builder.append(map.get(domain));
            builder.append(" ");
            builder.append(domain);
            result.add(builder.toString());
        }

        return result;
    }
}
