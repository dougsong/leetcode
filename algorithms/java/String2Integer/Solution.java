class Solution {
    public int myAtoi(String str) {
        if (str == null || str.length() <= 0) {
            return 0;
        }

        char[] strArr = str.trim().toCharArray();

        StringBuilder sb = new StringBuilder();
        boolean isNagetive = false;
        boolean start = true;
        for (int i = 0; i < strArr.length; i++) {
            if (start && strArr[i] == '+') {
                start = false;
                continue;
            }

            if (start && strArr[i] == '-') {
                isNagetive = true;
                start = false;
                continue;
            }

            boolean isOtherWordsInStart = start && (strArr[i] > '9' || strArr[i] < '0') && strArr[i] != '-';
            if (isOtherWordsInStart) {
                return 0;
            }

            boolean isOtherWordsInString = !start && (strArr[i] > '9' || strArr[i] < '0');
            if (isOtherWordsInString) {
                break;
            }

            if (strArr[i] >= '0' && strArr[i] <= '9') {
                sb.append(strArr[i]);
                start = false;
            }
        }

        if (sb.toString().length() <= 0) {
            return 0;
        }

        char[] arr = sb.toString().toCharArray();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > '0' && arr[i] <= '9') {
                break;
            }

            if (arr[i] == '0') {
                sb.deleteCharAt(0);
            }
        }

        if (sb.toString().length() > 10) {
            if (isNagetive) {
                return Integer.MIN_VALUE;
            } else {
                return Integer.MAX_VALUE;
            }
        }

        if (sb.toString().length() <= 0) {
            return 0;
        }

        long result = Long.valueOf(sb.toString());

        if (isNagetive) {
            if ((-result) <= Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            } else {
                return -Integer.valueOf(sb.toString());
            }
        } else if (result >= Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        } else {
            return Integer.valueOf(sb.toString());
        }
    }
}