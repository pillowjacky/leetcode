package _981_time_based_key_value_store;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class TimeMap {

    private class V {
        String value;
        int timestamp;

        V(String value, int timestamp) {
            this.value = value;
            this.timestamp = timestamp;
        }
    }

    private Map<String, List<V>> store;

    public TimeMap() {
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
