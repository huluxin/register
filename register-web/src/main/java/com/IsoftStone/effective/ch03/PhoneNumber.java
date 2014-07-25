package com.IsoftStone.effective.ch03;

import java.util.HashMap;
import java.util.Map;

/**
 * 09 覆盖equals时总要覆盖hashCode
 * Created by Administrator on 2014/7/25.
 */
public final class PhoneNumber {
    private final short areaCode;
    private final short exchange;
    private final short extension;

    public PhoneNumber(int areaCode, int exchange, int extension) {
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
        if (!(o instanceof PhoneNumber))
            return false;
        PhoneNumber pn = (PhoneNumber) o;
        return pn.extension == extension &&
                pn.exchange == exchange &&
                pn.areaCode == areaCode;
    }

    public static void main(String[] args) {
        Map m = new HashMap();
        m.put(new PhoneNumber(408,867,5309),"Jenny");
        System.out.println(m.get(new PhoneNumber(408, 867, 5309)));
    }
}
