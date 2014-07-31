package com.IsoftStone.effective.ch03;

/**
 * Created by Administrator on 2014/7/31.
 */
public class HashTable02 implements Cloneable {
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
        Entry deepCopy(){
            return new Entry(key,value,next == null ? null : next.deepCopy());
        }
    }

    public Object clone() throws CloneNotSupportedException {
        HashTable02 result = (HashTable02) super.clone();
        result.buckets = new Entry[buckets.length];
        for (int i = 0; i < buckets.length; i++) {
            if(buckets[i] != null)
                result.buckets[i] = buckets[i].deepCopy();
        }
        return result;
    }
}
