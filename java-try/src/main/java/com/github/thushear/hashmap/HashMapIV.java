package com.github.thushear.hashmap;

import java.util.HashMap;

/**
  hash map  inter view  knowlege
 * </pre>
 */
public class HashMapIV {


    public static void main(String[] args) {
        HashMap hashMap = new HashMap();

        for (int i = 0; i < 10000; i++) {
            if (i == 7) {
                System.err.println("");
            }
            if (i == 9999) {
                System.err.println("");
            }
            hashMap.put(new Key(i),i);
        }

        long start = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            hashMap.get(new Key(0));
        }
        long end1 = System.currentTimeMillis();
        System.err.println("cost " + (end1 - start ) + " ms");

        for (int i = 0; i < 10000; i++) {
            hashMap.get(new Key(9999));
        }
        long end2 = System.currentTimeMillis();
        System.err.println("cost " + (end2 - end1 ) + " ms");
    }

}
class Key implements Comparable<Key>{

    private int key;

    public Key(int key) {
        this.key = key;
    }

    @Override
    public int hashCode() {
        return 0;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (obj instanceof Key){
            return key == Integer.valueOf(((Key)obj).getKey());
        }else {
            return false;
        }

    }

    @Override
    public int compareTo(Key o) {
        return  key > o.getKey() ? 1 : -1;
    }
}