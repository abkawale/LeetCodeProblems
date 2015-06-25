/*
 * Design and implement a data structure for Least Recently Used (LRU) cache.
 * It should support the following operations: get and set.
 * get(key) - Get the value (will always be positive) of the key if the key exists in the cache,
 *       otherwise return -1.
 * set(key, value) - Set or insert the value if the key is not already present. 
 *   When the cache reached its capacity, i
 *   it should invalidate the least recently used item before inserting a new item.
 */
package LeetCodeProblems;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 *
 * @author Abhay Kawale
 */
public class LRUCache {

    private final Map<Integer, Integer> cacheMap;

    public LRUCache(int capacity) {

        this.cacheMap = new LinkedHashMap<Integer, Integer>(capacity, 0.8f, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
                return this.size() > capacity;
            }
        };

    }

    public synchronized int get(int key) {
        if (cacheMap.containsKey(key)) {
            return cacheMap.get(key);
        }
        return -1;
    }

    public synchronized void set(int key, int value) {
        cacheMap.put(key, value);
    }

}
