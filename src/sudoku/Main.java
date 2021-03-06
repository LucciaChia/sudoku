package sudoku;

import java.util.*;

public class Main {
    public static List<Vertical> verticals = new ArrayList<>();
    public static List<Horizontal> horizontals = new ArrayList<>();
    public static List<Square> squares = new ArrayList<>();

    public static void main(String[] args) {
        int[][] data =

                //JEDNODUCHE SUDOKU test 1
//                {
//                        {0, 3, 0, 4, 1, 0, 0, 2, 0},
//                        {5, 6, 0, 0, 0, 0, 0, 3, 0},
//                        {8, 0, 0, 0, 0, 7, 0, 0, 0},
//                        {7, 5, 6, 0, 0, 9, 0, 0, 0},
//                        {0, 1, 0, 0, 0, 0, 0, 6, 0},
//                        {0, 0, 0, 6, 0, 0, 3, 5, 7},
//                        {0, 0, 0, 5, 0, 0, 0, 0, 8},
//                        {0, 9, 0, 0, 0, 0, 0, 1, 2},
//                        {0, 7, 0, 0, 8, 2, 0, 9, 0}
//                };

                // JEDNODUCHE SUDOKU test 2
//                {
//                        {1, 0, 6, 2, 0, 0, 0, 0, 0},
//                        {7, 0, 0, 1, 0, 0, 0, 8, 0},
//                        {0, 0, 3, 5, 0, 6, 4, 0, 1},
//                        {0, 6, 1, 0, 0, 0, 0, 0, 8},
//                        {2, 0, 0, 0, 0, 0, 0, 0, 4},
//                        {4, 0, 0, 0, 0, 0, 1, 2, 0},
//                        {8, 0, 5, 3, 0, 2, 9, 0, 0},
//                        {0, 1, 0, 0, 0, 9, 0, 0, 5},
//                        {0, 0, 0, 0, 0, 1, 8, 0, 2}
//                };

                //JEDNODUCHE SUDOKU test 3
//                {
//                        {2, 9, 6, 0, 0, 0, 0, 5, 0},
//                        {5, 1, 0, 9, 3, 8, 0, 0, 0},
//                        {0, 0, 0, 0, 0, 0, 0, 0, 0},
//                        {0, 0, 4, 2, 0, 0, 0, 0, 0},
//                        {0, 0, 5, 7, 0, 9, 8, 0, 0},
//                        {0, 0, 0, 0, 0, 4, 1, 0, 0},
//                        {0, 0, 0, 0, 0, 0, 0, 0, 0},
//                        {0, 0, 0, 8, 1, 2, 0, 6, 7},
//                        {0, 6, 0, 0, 0, 0, 9, 1, 2}
//                };

        //JEDNODUCHE SUDOKU test 4
        {
            {0, 0, 4, 0, 1, 2, 0, 6, 0},
            {0, 3, 7, 0, 0, 0, 0, 9, 0},
            {9, 0, 0, 0, 0, 4, 0, 0, 8},
            {0, 0, 0, 3, 0, 0, 0, 0, 1},
            {6, 0, 0, 0, 8, 0, 0, 0, 3},
            {3, 0, 0, 0, 0, 9, 0, 0, 0},
            {7, 0, 0, 2, 0, 0, 0, 0, 4},
            {0, 8, 0, 0, 0, 0, 7, 2, 0},
            {0, 1, 0, 6, 7, 0, 5, 0, 0}
        };
        //TAZKE SUDOKU test 1 - to do
//        {
//            {0, 0, 0, 2, 0, 1, 4, 3, 0},
//            {1, 0, 2, 7, 0, 0, 0, 6, 5},
//            {0, 0, 0, 0, 0, 5, 0, 0, 1},
//            {0, 7, 9, 0, 0, 0, 0, 0, 6},
//            {0, 0, 6, 0, 0, 0, 1, 0, 0},
//            {3, 0, 0, 0, 0, 0, 7, 4, 0},
//            {8, 0, 0, 3, 0, 0, 0, 0, 0},
//            {7, 1, 0, 0, 0, 4, 9, 0, 8},
//            {0, 6, 4, 8, 0, 9, 0, 0, 0}
//        };
        printIt(data);

        // create necessary objects
        for (int i = 0; i < data.length; i++) {
            Horizontal horizontal = new Horizontal();
            for (int j = 0; j < data[i].length; j++) {
                Cell cell = new Cell(data[i][j], i, j);
                horizontal.getColumn().add(cell);

                if (i == 0) {
                    Vertical vertical = new Vertical();
                    verticals.add(vertical);
                    verticals.get(j).getRow().add(cell);
                } else {
                    verticals.get(j).getRow().add(cell);

                }

                if ((i % 3 == 0 || i % 3 == 3) && (j % 3 == 0 || j % 3 == 3)) {
                    Square square = new Square();
                    squares.add(square);
                }
                if (i < 3) {
                    if (j < 3) {
                        squares.get(0).addCell(cell);
                    }
                    if (j >= 3 && j < 6) {
                        squares.get(1).getcellsInSquare().add(cell);
                    }
                    if (j >= 6 && j < 9) {
                        squares.get(2).getcellsInSquare().add(cell);
                    }
                }
                if (i >= 3 && i < 6) {
                    if (j < 3) {
                        squares.get(3).getcellsInSquare().add(cell);
                    }
                    if (j >= 3 && j < 6) {
                        squares.get(4).getcellsInSquare().add(cell);
                    }
                    if (j >= 6 && j < 9) {
                        squares.get(5).getcellsInSquare().add(cell);
                    }
                }
                if (i >= 6 && i < 9) {
                    if (j < 3) {
                        squares.get(6).getcellsInSquare().add(cell);
                    }
                    if (j >= 3 && j < 6) {
                        squares.get(7).getcellsInSquare().add(cell);
                    }
                    if (j >= 6 && j < 9) {
                        squares.get(8).getcellsInSquare().add(cell);
                    }
                }
            }
            horizontals.add(horizontal);
        }
        System.out.println("POSSIBILITIES: ");
        Solution solution = new Solution(verticals, horizontals, squares, data);
        List<Possibility> pos = solution.output();

        System.out.println(pos.size());
        for (int i = 0; i < pos.size(); i++) {
            System.out.print(i + ": ");
            System.out.println(pos.get(i).toString());
        }
        System.out.println("FINAL SOLUTION:");
        printIt(data);

//        System.out.println(pos.size());
//        for (int i = 0; i < pos.size(); i++) {
//            System.out.print(i + ": ");
//            System.out.println(pos.get(i).toString());
//        }

    }
    private static void printIt(int[][] data){
        for (int i=0; i<data.length; i++) {
            for (int j=0; j<data[i].length; j++) {
                System.out.print(data[i][j] + " ");
            }
            System.out.println();
        }
    }

}
