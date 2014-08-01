package com.IsoftStone.effective.ch03;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 违反对称 equals
 * Created by Administrator on 2014/7/25.
 */
public final class CaseInsensitiveString02 implements Comparable {
    private String s;

    public CaseInsensitiveString02(String s) {
        if (s == null)
            throw new NullPointerException();
        this.s = s;
    }

  /*  public boolean equals(Object o) {
        if (o instanceof CaseInsensitiveString)
            return s.equalsIgnoreCase(((CaseInsensitiveString) o).s);
        if (o instanceof String)
            return s.equalsIgnoreCase((String) o);
        return false;
    }*/

    //Fixed
    public boolean equals(Object o) {
        return o instanceof CaseInsensitiveString02 && ((CaseInsensitiveString02) o).s.equalsIgnoreCase(s);
    }

    private volatile int hashCode = 0;

    public int hashCode() {
        if (hashCode == 0) {
            hashCode = s.toUpperCase().hashCode();
        }
        return hashCode;
    }

    @Override
    public int compareTo(Object o) {
        CaseInsensitiveString02 cis = (CaseInsensitiveString02) o;
        return String.CASE_INSENSITIVE_ORDER.compare(s, cis.s);
    }

    public static void main(String[] args) {
        CaseInsensitiveString ciArgs[] =
                new CaseInsensitiveString[args.length];
        for (int i = 0; i < ciArgs.length; i++)
            ciArgs[i] = new CaseInsensitiveString(args[i]);
        Arrays.sort(ciArgs);
        System.out.println(Arrays.asList(ciArgs));

        // Print arguments with duplicates eliminated
        Set s = new HashSet();
        for (int i = 0; i < ciArgs.length; i++)
            s.add(ciArgs[i]);
        System.out.println(s);
    }
}
