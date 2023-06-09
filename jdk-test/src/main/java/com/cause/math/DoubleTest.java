package com.cause.math;

import java.math.BigDecimal;

/**
 * double精度丢失原因：比如：0.3计算的时候转二进制，变成无限循环的小数
 * BigDecimal精度不丢失的原因，比如：0.003先乘以100再转二进制计算，然后再处以100
 */
public class DoubleTest {
    public static void main(String[] args) {
        String a = "0.01";
        double aDouble = Double.valueOf(a);
        System.out.println(aDouble);

        double b = 3.30;
        double c = 1.10;
        int cc = (int) (b - c);
        System.out.println(cc);
        System.out.println(b - c);

        BigDecimal bigDecimal = new BigDecimal("0.3");
        BigDecimal bigDecimal2 = new BigDecimal("0.1");
        System.out.println(bigDecimal.subtract(bigDecimal2));

        double i = 300;
        double h = i / 100;
        System.out.println(h);
        System.out.println(Math.ceil(i));
    }
}
