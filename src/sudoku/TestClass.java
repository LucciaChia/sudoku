package sudoku;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class TestClass {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        arrayList.add(1);
        arrayList.add(3);
        arrayList.add(4);
        arrayList.add(3);
        arrayList.add(8);

        Map<Integer, Integer> test = new HashMap<Integer, Integer>();
        int amount = 0;
        for (Integer i : arrayList) {
            if (test.containsKey(i)) {
                test.put(i, test.get(i) + 1);
            } else {
                test.put(i, 1);
            }

        }

    }
}
