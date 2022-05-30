import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class code_030_插入删除和随机访问都是O1的容器 {
    public static void main(String[] args) {
    }

    static class RandomizedSet {
        private final HashMap<Integer, Integer> map;
        private final ArrayList<Integer> arr;
        private final Random random;

        public RandomizedSet() {
            map = new HashMap<>();
            arr = new ArrayList<>();
            random = new Random();
        }

        public boolean insert(int val) {
            if (map.containsKey(val)) return false;
            map.put(val, arr.size());
            arr.add(val);
            return true;
        }

        public boolean remove(int val) {
            if (!map.containsKey(val)) return false;
            int curIndex = map.get(val);
            int curVal = arr.get(curIndex);
            int lastIndex = arr.size() - 1;
            int lastVal = arr.get(lastIndex);
            map.put(lastVal, curIndex);
            map.remove(curVal);
            arr.set(curIndex, lastVal);
            arr.remove(lastIndex);
            return true;
        }

        public int getRandom() {
            int index = random.nextInt(arr.size());
            return arr.get(index);
        }
    }
}
