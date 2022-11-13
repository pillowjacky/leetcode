package _981_time_based_key_value_store;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

class TimeMap {

    Map<String, TreeMap<Integer, String>> store;

    public TimeMap() {
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
