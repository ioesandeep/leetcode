package leetcode.hard;

import java.util.*;

public class IntegerToEnglish {
    Stack<String> stack;
    Map<Integer, String> eng;
    Map<Integer, String> prefixes;

    IntegerToEnglish() {
        eng = new HashMap<>();
        prefixes = new HashMap<>();

        eng.put(1, "One");
        eng.put(2, "Two");
        eng.put(3, "Three");
        eng.put(4, "Four");
        eng.put(5, "Five");
        eng.put(6, "Six");
        eng.put(7, "Seven");
        eng.put(8, "Eight");
        eng.put(9, "Nine");
        eng.put(10, "Ten");
        eng.put(11, "Eleven");
        eng.put(12, "Twelve");
        eng.put(13, "Thirteen");
        eng.put(14, "Fourteen");
        eng.put(15, "Fifteen");
        eng.put(16, "Sixteen");
        eng.put(17, "Seventeen");
        eng.put(18, "Eighteen");
        eng.put(19, "Nineteen");
        eng.put(20, "Twenty");
        eng.put(30, "Thirty");
        eng.put(40, "Forty");
        eng.put(50, "Fifty");
        eng.put(60, "Sixty");
        eng.put(70, "Seventy");
        eng.put(80, "Eighty");
        eng.put(90, "Ninety");

        prefixes.put(2, "Thousand");
        prefixes.put(3, "Million");
        prefixes.put(4, "Billion");
        prefixes.put(5, "Trillion");
    }


    public String numberToWords(int num) {
        if (num == 0) {
            return "Zero";
        }

        stack = new Stack<>();
        List<String> result = new ArrayList<>();

        buildStack(num);
        toWords(result);

        return output(result);
    }

    String output(List<String> result) {
        StringBuilder output = new StringBuilder();
        while (result.size() > 0) {
            output.append(result.remove(0));
            if (result.size() > 0) {
                output.append(" ");
            }
        }

        return output.toString();
    }

    void toWords(List<String> builder) {
        int size = stack.size();

        if (size == 0) {
            return;
        }

        String str = stack.pop();

        if (str.equals("")) {
            toWords(builder);
            return;
        }

        builder.add(str);
        if (prefixes.containsKey(size)) {
            builder.add(prefixes.get(size));
        }

        toWords(builder);
    }

    void buildStack(int num) {
        if (num == 0) {
            return;
        }

        int carry = num % 1000;
        num = num / 1000;

        String str = toStr(carry);

        stack.push(str);

        buildStack(num);
    }

    String toStr(int num) {
        StringBuilder builder = new StringBuilder();
        return toStr(num, builder);
    }

    String toStr(int num, StringBuilder builder) {
        if (num == 0) {
            return "";
        }

        int carry = 0;
        if (num >= 100) {
            carry = num % 100;
            num = num / 100;
            builder.append(eng.get(num));
            builder.append(" ");
            builder.append("Hundred");
        } else if (num >= 20) {
            carry = num % 10;
            num = num / 10;
            builder.append(eng.get(num * 10));
        } else {
            builder.append(eng.get(num));
        }

        if (carry != 0) {
            builder.append(" ");
        }

        if (carry > 0) {
            toStr(carry, builder);
        }

        return builder.toString();
    }
}
