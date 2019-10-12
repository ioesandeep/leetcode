package string;

public class ToLowerCase {
    public String toLowerCase(String str) {
        char[] chars = str.toCharArray();
        for (int i = 0; i < str.length(); i++) {
            char ch = chars[i];
            if (ch >= 65 && ch <= 90) {
                chars[i] = (char) (ch + 32);
            }
        }
        return String.valueOf(chars);
    }
}
