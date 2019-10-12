package easy;

public class NumberOfSegmentsInAString {
    public int countSegments(String s) {
        String[] words = s.split(" ");
        int count = 0;
        for (String word : words) {
            if (word != " " && word.length() > 0) {
                ++count;
            }
        }
        return count;
    }
}
