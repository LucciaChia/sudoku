package sudoku;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Horizontal {
    private List<Cell> column = new ArrayList<>();


    public List<Cell> getColumn() {
        return column;
    }

    public Cell getCellInHorizontal(int i) {
        return column.get(i);
    }
    @Override
    public String toString() {
        String output = "";
        for (int i = 0; i < 9; i++) {
            output += " " + column.get(i).getActualValue();
        }
        return output;
    }

    public Map<Integer, Integer> amountOfParticularPossibilities() {
        Map<Integer, Integer> countOfPossibilities = new HashMap<>();
        for (int i = 0; i < 9; i++) {
            Possibility possibility = column.get(i).getCellPossibilities(); // moznosti v bunke
            if (possibility != null) {
                for (int j = 0; j < possibility.getPosibilities().size(); j++) {
                    if (!countOfPossibilities.containsKey(possibility.getPosibilities().get(j))) {
                        countOfPossibilities.put(possibility.getPosibilities().get(j), 1);
                    } else {
                        int key = possibility.getPosibilities().get(j);
                        countOfPossibilities.put(key, countOfPossibilities.get(key) + 1);
                    }
                }
            }
        }
        return countOfPossibilities;
    }
}
