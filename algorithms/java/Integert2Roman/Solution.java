class Solution {

    public String intToRoman(int num) {
        int temp = num, cnt = 0;
        while (temp != 0) {
            cnt++;
            temp /= 10;
        }

        char[] characters = String.valueOf(num).toCharArray();
        int i = cnt - 1;
        StringBuilder sb = new StringBuilder();
        for (int k = 0; k < cnt; k++) {
            int n = characters[k] - '0';
            for (int j = 0; j < i; j++) {
                n *= 10;
            }
            i--;

            sb.append(getRomanNumber(n));
        }

        return sb.toString();
    }

    private String getRomanNumber(int num) {
        StringBuilder sb = new StringBuilder();
        if (num >= 1000) {
            for (int i = 0; i < num / 1000; i++) {
                sb.append("M");
            }
            return sb.toString();
        } else if (num >= 100) {
            if (num == 400) {
                return "CD";
            } else if (num == 900) {
                return "CM";
            } else if (num < 500) {
                for (int i = 0; i < num / 100; i++) {
                    sb.append("C");
                }
                return sb.toString();
            } else {
                sb.append("D");
                for (int i = 0; i < (num - 500) / 100; i++) {
                    sb.append("C");
                }
                return sb.toString();
            }
        } else if (num >= 10) {
            if (num == 40) {
                return "XL";
            } else if (num == 90) {
                return "XC";
            } else if (num < 50) {
                for (int i = 0; i < num / 10; i++) {
                    sb.append("X");
                }
                return sb.toString();
            } else {
                sb.append("L");
                for (int i = 0; i < (num - 50) / 10; i++) {
                    sb.append("X");
                }
                return sb.toString();
            }
        } else {
            if (num == 4) {
                return "IV";
            } else if (num == 9) {
                return "IX";
            } else if (num < 5) {
                for (int i = 0; i < num; i++) {
                    sb.append("I");
                }
                return sb.toString();
            } else {
                sb.append("V");
                for (int i = 0; i < (num - 5); i++) {
                    sb.append("I");
                }
                return sb.toString();
            }
        }
    }
}