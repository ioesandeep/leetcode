package easy;

public class StrStr {
    public int strStr(String haystack, String needle) {
        if (haystack.length() == 0 || needle.length() == 0) {
            if (haystack.length() == 0 && needle.length() > 0) {
                return -1;
            }

            if (needle.length() == 0) {
                return 0;
            }
        }
        int pos = -1;
        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            boolean found = true;
            for (int j = 0; j < needle.length(); j++) {
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    found = false;
                    break;
                }
            }
            if (found) {
                return i;
            }
        }
        return pos;
    }
}
