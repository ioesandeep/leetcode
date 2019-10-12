package easy;

public class LicenseKeyFormatting {
    public String licenseKeyFormatting(String S, int K) {
        StringBuilder builder = new StringBuilder();
        StringBuilder str = new StringBuilder();
        for (int i = S.length() - 1; i >= 0; i--) {
            if (S.charAt(i) == '-') {
                continue;
            }
            char ch = S.charAt(i);
            if (ch >= 'a' && ch <= 'z') {
                ch -= 32;
            }
            str.append(ch);
            if (str.length() == K) {
                builder.append(str.toString());
                builder.append("-");
                str = new StringBuilder();
            }
        }

        if (str.length() > 0) {
            builder.append(str);
        } else if (builder.length() > 0) {
            builder.deleteCharAt(builder.length() - 1);
        }

        return builder.reverse().toString();

    }
}
