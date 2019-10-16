package medium;

public class OneEditDistance {
    public boolean isOneEditDistance(String s, String t) {
        if (Math.abs(s.length() - t.length()) > 1) {
            return false;
        }

        if (s.length() == t.length()) {
            return oneWordReplace(s, t);
        }

        if (s.length() < t.length()) {
            return oneWordInsert(s, t);
        }

        return oneWordDelete(s, t);

    }

    boolean oneWordReplace(String s, String t) {
        int replaces = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == t.charAt(i)) {
                continue;
            }

            if (replaces > 1) {
                return false;
            }

            ++replaces;

        }
        return replaces == 1;
    }

    boolean oneWordInsert(String s, String t) {
        boolean inserted = false;
        int j = 0;
        int i = 0;
        while (i < s.length()) {
            if (s.charAt(i) != t.charAt(j)) {
                if (!inserted) {
                    inserted = true;
                    j++;
                    continue;
                }
                return false;
            }
            i++;
            j++;
        }
        return true;
    }

    boolean oneWordDelete(String s, String t) {
        return oneWordInsert(t, s);
    }
}
