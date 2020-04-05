package leetcode.easy;

public class StudentAttendanceRecordI {
    public boolean checkRecord(String s) {
        int absent = 0;
        int i = 0;

        while (i < s.length()) {
            if (s.charAt(i) == 'A') {
                absent++;
            }

            if (absent > 1) {
                return false;
            }

            if (s.charAt(i) == 'L') {
                int consecutive = 0;
                while (i < s.length() && s.charAt(i) == 'L') {
                    i++;
                    consecutive++;
                }

                if (consecutive > 2) {
                    return false;
                }
            } else {
                i++;
            }
        }

        return true;
    }
}
