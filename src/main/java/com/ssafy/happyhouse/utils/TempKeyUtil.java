package com.ssafy.happyhouse.utils;

import java.util.Random;

public class TempKeyUtil {
    private int size;
    private boolean lowerCheck;

    public String getKey(int size, boolean lowerCheck) {
        this.size = size;
        this.lowerCheck = lowerCheck;
        return init();
    }

    private String init() {
        Random ran = new Random();
        StringBuilder sb = new StringBuilder();

        int num = 0;

        do {
            num = ran.nextInt(75) + 48;

            if((num >= 48 && num <= 57) || (num >= 65 && num <= 90) || (num >= 97 && num <= 122)) {
                sb.append((char)num);
            }else {
                continue;
            }
        } while (sb.length() < size);

        if(lowerCheck) {
            return sb.toString().toLowerCase();
        }

        return sb.toString();
    }
}
