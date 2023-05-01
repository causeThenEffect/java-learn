package com.cause.math;

import java.math.BigInteger;

public class BigIntegerTest {
    public static void main(String[] args) {
        BigInteger bigInteger = new BigInteger("16");
        System.out.println(bigInteger.toString(2));

        BigInteger bigInteger1 = new BigInteger("-9");
        System.out.println(bigInteger1.toString(2));
    }
}
