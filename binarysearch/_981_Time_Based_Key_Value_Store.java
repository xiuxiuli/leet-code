package binarysearch;

public class _981_Time_Based_Key_Value_Store {
    class TimeMap {

        // Node timestamp, value) -> (4, "bar2")
        private static class Node{
            int timestamp;
            String value;

            Node(int timestamp, String value) {
                this.timestamp = timestamp;
                this.value = value;
            }
        }

        // list: [Node(timestamp = 1, value = "bar"), Node(timestamp = 4, value = "bar2")]
        private Map<String, List<Node>> map;

        // map: {"foo": [Node(1, "bar"), Node(4, "bar2")}
        public TimeMap() {
            map = new HashMap<>();
        }
        
        public void set(String key, String value, int timestamp) {
            map.computeIfAbsent(key, k -> new ArrayList<>()).add(new Node(timestamp, value));
        }
        
        public String get(String key, int timestamp) {
            if(!map.containsKey(key)) return "";

            List<Node> list = map.get(key);
        
            if(list == null || list.isEmpty()) return "";

            // 剪枝 1: 目标时间比最早记录还小
            if(list.get(0).timestamp > timestamp) return "";

            // 剪枝 2: 目标时间大于等于最新记录
            if(list.get(list.size()-1).timestamp <= timestamp) {
                return list.get(list.size() - 1).value;
            }

            int left = 0;
            int right = list.size() - 1;
            String res = "";

            // 二分查找 <= timestamp 的最大时间戳
            while (left <= right){
                int mid = left + (right - left)/2;

                if(list.get(mid).timestamp <= timestamp){
                    res = list.get(mid).value;
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            return res;
        }
    }
}