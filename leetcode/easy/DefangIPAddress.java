package leetcode.easy;

public class DefangIPAddress {
    public String defangIPaddr(String address) {
        StringBuilder builder = new StringBuilder();
        for (char c : address.toCharArray()) {
            if (c == '.') {
                builder.append('[');
                builder.append('.');
                builder.append(']');
            } else {
                builder.append(c);
            }
        }
        return builder.toString();
    }
}
