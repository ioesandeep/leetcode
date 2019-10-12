package string;

public class RemoveVowelsFromString {
    public String removeVowels(String S) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < S.length(); i++) {
            char ch = S.charAt(i);
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                continue;
            }
            builder.append(ch);
        }
        return builder.toString();
    }
}
