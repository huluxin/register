package com.IsoftStone.effective.ch03;

/**
 * Created by Administrator on 2014/7/31.
 */
public class HashTable03 implements Cloneable {
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

        Entry deepCopy() {
            Entry result = new Entry(key, value, next);
            for (Entry p = result; p.next != null; p = p.next)
                p.next = new Entry(p.next.key, p.next.value, p.next.next);

            return result;
        }
    }

    public Object clone() throws CloneNotSupportedException {
        HashTable03 result = (HashTable03) super.clone();
        result.buckets = new Entry[buckets.length];
        for (int i = 0; i < buckets.length; i++) {
            if (buckets[i] != null)
                result.buckets[i] = buckets[i].deepCopy();
        }
        return result;
    }
}
