package easy;

public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }

        String min = strs[0];
        for (int i = 1; i < strs.length; i++) {
            if (strs[i].length() < min.length()) {
                min = strs[i];
            }
        }

        StringBuilder common = new StringBuilder();
        for (int i = 0; i < min.length(); i++) {
            for (int j = 0; j < strs.length; j++) {
                if (strs[j].charAt(i) != min.charAt(i)) {
                    return common.toString();
                }
            }
            common.append(min.charAt(i));
        }

        return common.toString();
    }
}
