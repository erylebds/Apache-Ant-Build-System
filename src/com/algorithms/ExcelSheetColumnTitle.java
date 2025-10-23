package com.algorithms;

public class ExcelSheetColumnTitle {
    public String convertToTitle(int columnNumber) {
        String result = "";

        while (columnNumber > 0) {
            columnNumber--;
            char c = (char) ('A' + (columnNumber % 26));
            result = c + result;
            columnNumber /= 26;
        }

        return result;
    }
}

