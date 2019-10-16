package leetcode.medium;

public class ReverseWordsInString {
    public void reverseWords(char[] s) {
        int i = 0;
        int j = s.length - 1;
        //reverse the array first
        while (i < j) {
            char ch = s[i];
            s[i] = s[j];
            s[j] = ch;
            i++;
            j--;
        }

        //now lets reverse every word
        int start = 0;
        i = 0;
        while (i < s.length) {
            if (s[i] == ' ') {
                reverse(s, start, i);
                start = i + 1;
            }
            i++;
        }
        //the last word was't reversed
        //also the array containing only one word
        //wasn't reversed
        reverse(s, start, i);
    }

    //reverses word in the array
    void reverse(char[] s, int start, int i) {
        int end = (i + start) / 2;
        int k = i - 1;
        int j;
        for (j = start; j < end; j++) {
            char ch = s[j];
            s[j] = s[k];
            s[k] = ch;
            k--;
        }
    }
}
