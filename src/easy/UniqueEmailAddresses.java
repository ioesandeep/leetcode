package easy;

import java.util.HashSet;
import java.util.Set;

public class UniqueEmailAddresses {
    public int numUniqueEmails(String[] emails) {
        Set<String> set = new HashSet<>();
        for (String email : emails) {
            String[] parts = email.split("@");
            String local = parts[0].split("\\+")[0].replaceAll("\\.", "");
            set.add(local + "@" + parts[1]);
        }
        return set.size();
    }
}
