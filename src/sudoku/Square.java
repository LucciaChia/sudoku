package sudoku;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Square {
    private List<Cell> cellsInSquare = new ArrayList<>();


    public List<Cell> getcellsInSquare() {
        return cellsInSquare;
    }


    public void printSquare() {
        for (int i = 0; i < 9; i++) {
                System.out.print(cellsInSquare.get(i).getActualValue());
                if (i%3 == 2) {
                    System.out.println();
                }
        }
    }

    public void addCell(Cell cell) {
        cellsInSquare.add(cell);
    }

    @Override
    public String toString() {
        String output = "";
        int index = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                output +=  " " + cellsInSquare.get(index).getActualValue();
                index++;
            }
            output += "\n";
        }

        return output;
    }

    public Map<Integer, Integer> amountOfParticularPossibilities() {
        Map<Integer, Integer> countOfPossibilities = new HashMap<>();
        for (int i = 0; i < 9; i++) {
            Possibility possibility = cellsInSquare.get(i).getCellPossibilities(); // moznosti v bunke
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
