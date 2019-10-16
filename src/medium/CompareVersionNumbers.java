package medium;

public class CompareVersionNumbers {
    public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");

        int j = 0;
        for (int i = 0; i < v1.length; i++) {
            if (i >= v2.length) {
                while (i < v1.length) {
                    int val = Integer.valueOf(v1[i]);
                    if (val > 0) {
                        return 1;
                    }
                    i++;
                }
                return 0;
            }

            int val1 = Integer.valueOf(v1[i]);
            int val2 = Integer.valueOf(v2[i]);
            if (val1 > val2) {
                return 1;
            }

            if (val2 > val1) {
                return -1;
            }

            j++;
        }

        if (j < v2.length) {
            while (j < v2.length) {
                int val = Integer.valueOf(v2[j]);
                if (val > 0) {
                    return -1;
                }
                j++;
            }
        }

        return 0;
    }
}
