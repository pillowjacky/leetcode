package java;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * <pre>
 * 
 * 981. Time Based Key-Value Store
 * https://leetcode.com/problems/time-based-key-value-store/
 * 
 * </pre>
 */
class V {
    String value;
    int timestamp;

    V(String value, int timestamp) {
        this.value = value;
        this.timestamp = timestamp;
    }
}


/**
 * <pre>
 * 
 * Hashing + Binary Search
 * 
 * </pre>
 */
class Solution1 {
    private Map<String, List<V>> store;

    public Solution1() {
        this.store = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        store.putIfAbsent(key, new ArrayList<>());
        store.get(key).add(new V(value, timestamp));
    }

    public String get(String key, int timestamp) {
        List<V> value = store.get(key);
        if (value == null) {
            return "";
        }

        String out = "";
        int l = 0;
        int r = value.size() - 1;
        while (l <= r) {
            int m = (l + r) / 2;
            V v = value.get(m);
            if (v.timestamp == timestamp) {
                out = v.value;
                break;
            } else if (v.timestamp <= timestamp) {
                out = v.value;
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return out;
    }
}


/**
 * <pre>
 * 
 * Tree Map
 * 
 * </pre>
 */
class Solution2 {
    private Map<String, TreeMap<Integer, String>> store;

    public Solution2() {
        this.store = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        store.putIfAbsent(key, new TreeMap<>());
        store.get(key).put(timestamp, value);
    }

    public String get(String key, int timestamp) {
        TreeMap<Integer, String> records = store.get(key);
        if (records == null) {
            return "";
        }
        Integer floorKey = records.floorKey(timestamp);
        if (floorKey == null) {
            return "";
        }
        return records.get(floorKey);
    }
}
