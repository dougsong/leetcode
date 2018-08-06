public class Solution {

    public String convert(String s, int numRows) {
        if (s == null || numRows <= 0) {
            return null;
        }

        if (numRows == 1) {
            return s;
        }

        int row = 0;
        int col = 0;
        int lastRow = 0;
        int index = 0;

        char[] arr = s.toCharArray();

        char[][] printArr = new char[numRows][arr.length];

        boolean start = true;
        while (index < arr.length) {
            if (lastRow == (numRows - 1) || !start) {
                row--;
                col++;
                lastRow--;
                start = false;
            }

            printArr[row][col] = arr[index];
            index++;

            if (start) {
                lastRow = row;
                if (row < (numRows - 1)) {
                    row++;
                }
            }

            if (row == 0) {
                start = true;
                row++;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (char[] aPrintArr : printArr) {
            for (char anAPrintArr : aPrintArr) {
                if (anAPrintArr != 0) {
                    sb.append(anAPrintArr);
                }
            }
        }
        return sb.toString();
    }
}