package com.IsoftStone.effective.ch03;

import java.util.HashMap;
import java.util.Map;

public final class PhoneNumber02 implements Comparable{
    private final short areaCode;
    private final short exchange;
    private final short extension;

    public PhoneNumber02(int areaCode, int exchange, int extension) {
        rangeCheck(areaCode, 999, "area code");
        rangeCheck(exchange, 999, "exchange");
        rangeCheck(extension, 9999, "extension");
        this.areaCode = (short) areaCode;
        this.exchange = (short) exchange;
        this.extension = (short) extension;
    }

    private static void rangeCheck(int arg, int max, String name) {
        if (arg < 0 || arg > max)
            throw new IllegalArgumentException(name + ": " + arg);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof PhoneNumber02))
            return false;
        PhoneNumber02 pn = (PhoneNumber02) o;
        return pn.extension == extension &&
                pn.exchange == exchange &&
                pn.areaCode == areaCode;
    }

    public int hashCode() {
        int result = 17;
        result = 37*result + areaCode;
        result = 37*result + exchange;
        result = 37*result + extension;
        return result;
    }

    @Override
    /*public int compareTo(Object o) {
        PhoneNumber02 pn = (PhoneNumber02)o;

        // Compare area codes
        if (areaCode < pn.areaCode)
            return -1;
        if (areaCode > pn.areaCode)
            return  1;

        // Area codes are equal, compare exchanges
        if (exchange < pn.areaCode)
            return -1;
        if (exchange > pn.exchange)
            return  1;

        // Area codes and exchanges are equal, compare extensions
        if (extension < pn.extension)
            return -1;
        if (extension > pn.extension)
            return  1;

        return 0;  // All fields are equal
    }*/
    public int compareTo(Object o) {
        PhoneNumber02 pn = (PhoneNumber02)o;

        // Compare area codes
        int areaCodeDiff = areaCode - pn.areaCode;
        if (areaCodeDiff != 0)
            return areaCodeDiff;

        // Area codes are equal, compare exchanges
        int exchangeDiff = exchange - pn.exchange;
        if (exchangeDiff != 0)
            return exchangeDiff;

        // Area codes and exchanges are equal, compare extensions
        return extension - pn.extension;
    }

    @Override
    public String toString() {
        return "(" + toPaddedString(areaCode, 3) + ") " +
                toPaddedString(exchange,  3) + "-" +
                toPaddedString(extension, 4);
    }

    /**
     * Translates an int to a string of the specified length,
     * padded with leading zeros.  Assumes i >= 0,
     * 1 <= length <= 10, and Integer.toString(i) <= length.
     */
    private static String toPaddedString(int i, int length) {
        String s = Integer.toString(i);
        return ZEROS[length - s.length()] + s;
    }

    private static String[] ZEROS =
            {"", "0", "00", "000", "0000", "00000",
                    "000000", "0000000", "00000000", "000000000"};

    public static void main(String[] args) {
        Map m = new HashMap();
        m.put(new PhoneNumber02(408,867,5309),"Jenny");
        System.out.println(m.get(new PhoneNumber02(408, 867, 5309)));
    }
}
