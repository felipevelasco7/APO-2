package model;

import java.util.ArrayList;

class Pair<K, V> {
    private K key;
    private V value;

    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }
}

public class HashTable<K extends Comparable,V> {
    public  ArrayList<Pair<K, V>>[] map;
    private int size = 100;

    public HashTable() {
        map = new ArrayList[size];
        for(int i = 0; i<size ; i++){
            map[i] = new ArrayList();
        }
    }

    public int hash(K key){
        return key.hashCode() % size;
    }

    public void insert(K key, V value) throws Exception{
        if (search(key) == null){
            Pair nv = new Pair(key, value);
            map[hash(key)].add(nv);
        }
        else {
            throw new Exception("Id ya existente!");
        }
    }

    public V search(K key){
        V result = null;
        for(Pair<K, V> item : map[hash(key)]) {
            if (item.getKey().equals(key)) {
                result = item.getValue();
            }
        }
        return result;
    }

}
