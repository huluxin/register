package com.IsoftStone.effective.ch03;

/**
 * Created by Administrator on 2014/7/31.
 */
public class HashTable implements Cloneable {
    private Entry[] buckets = new Entry[11];

    private static class Entry {
        Object key;
        Object value;
        Entry next;

        Entry(Object key, Object value, Entry next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    public Object clone() throws CloneNotSupportedException {
        HashTable result = (HashTable) super.clone();
        result.buckets = (Entry[]) buckets.clone();
        return result;
    }
}
