package example;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RiverApp {
    public static Set<String> visitedSet = new HashSet<>();
    public static List<Integer> riverLengths = new ArrayList<>();
    public static int[][] directions8 = {{-1, 0}, // North
            {-1, 1}, // North-East
            {0, 1}, // East
            {1, 1}, // South-East
            {1, 0}, // South
            {1, -1}, // South-West
            {-1, -1},  // North-West
            {0, -1} // West
    };
    public static int[][] directions4 = {{-1, 0}, // North
            {0, 1}, // East
            {1, 0}, // South
            {0, -1} // West
    };

    public static void main(String[] args) {
        int[][] data = {{1, 1, 0, 0, 0}, {0, 1, 0, 0, 0}, {1, 0, 0, 1, 0}, {0, 1, 0, 0, 0}};

        int rows = data.length;
        int columns = data[0].length;
        String positionStr = null;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                positionStr = i + "-" + j;
                if (data[i][j] == 1 && !visitedSet.contains(positionStr)) {
                    riverLengths.add(findRiverLength(data, i, j, 0));
                }
            }
        }

        riverLengths.stream().forEach(System.out::println);
    }

    private static int findRiverLength(int[][] data, int i, int j, int currentRiverLength) {
//        if (!((i >= 0 && i < data.length) && (j < data[0].length && j >= 0))) {
//            return currentRiverLength;
//        }
        String positionStr = i + "-" + j;
        if (!visitedSet.contains(positionStr) && (i >= 0 && i < data.length) && (j < data[0].length && j >= 0) && data[i][j] == 1) {
            currentRiverLength++;
            visitedSet.add(positionStr);
            for (int[] direction : directions8) {
                currentRiverLength = findRiverLength(data, i + direction[0], j + direction[1], currentRiverLength); // Top
            }
//            currentRiverLength = findRiverLength(data, i - 1, j, currentRiverLength); // Top
//            currentRiverLength = findRiverLength(data, i, j + 1, currentRiverLength); // Left
//            currentRiverLength = findRiverLength(data, i + 1, j, currentRiverLength); // Bottom
//            currentRiverLength = findRiverLength(data, i, j - 1, currentRiverLength); // Right
        }
        return currentRiverLength;
    }

}
