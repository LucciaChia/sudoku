package sudoku;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Vertical {
    private List<Cell> row = new ArrayList<>(); // idem zvisle cez kazdy riadok, preto row

    public Vertical() {

    }

    public Vertical(List<Cell> row) {
        this.row = row;
    }

    public List<Cell> getRow() {
        return row;
    }

    public Cell getCellInVertical(int i) {
        return row.get(i);
    }

    @Override
    public String toString() {
        String output = "";
        for (int i = 0; i < 9; i++) {
            output += "\n" + row.get(i).getActualValue();
        }
        return output;
    }

    public Map<Integer, Integer> amountOfParticularPossibilities() {
        Map<Integer, Integer> countOfPossibilities = new HashMap<>();
        for (int i = 0; i < 9; i++) {
            Possibility possibility = row.get(i).getCellPossibilities(); // moznosti v bunke
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
