import java.util.ArrayList;

/**
 * class for find islands
 *
 * @author brunosantos
 */
class IslandFinder {


    /**
     * method to get and print in file the island, one by one
     * @param matrix this is the matrix, arraylist of array of chars
     * @param inputOutput the object inputOutput that have the writers methods to write to the file
     */
    void findIslands(ArrayList<boolean[]> matrix, InputOutput inputOutput) {
        int columnSize = matrix.get(0).length;
        int rowSize = matrix.size();
        inputOutput.openWriter();
        for (int i = 0; i < rowSize; i++) {
            for (int j = 0; j < columnSize; j++)
                if (matrix.get(i)[j]) {
                    Island island = new Island();
                    getHisNeighbors(i, j, matrix, island, columnSize, rowSize);
                    if (island.moreThanOne()) {
                        inputOutput.write2File(island.toString());
                    }
                }
        }
        inputOutput.closeWriter();
    }

    /**
     * recursive method to find neighbors around the 1
     * @param i index of line
     * @param j index of column
     * @param matrix matrix of booleans
     * @param island an island created
     * @param columnSize size of columns
     * @param rowSize size of rows
     */
    private void getHisNeighbors(int i, int j, ArrayList<boolean[]> matrix, Island island, int columnSize, int rowSize) {
        int ii, jj;
        Cell cell = new Cell(i, j);
        island.addCell(cell);
        matrix.get(i)[j] = false;
        // verify right
        if (j < columnSize - 1) {
            jj = j + 1;
            if (matrix.get(i)[jj]) {
                getHisNeighbors(i, jj, matrix, island, columnSize, rowSize);
            }
        }
        // verify down
        if (i < rowSize - 1) {
            ii = i + 1;
            if (matrix.get(ii)[j]) {
                getHisNeighbors(ii, j, matrix, island, columnSize, rowSize);
            }
        }
        // verify left
        if (j > 0) {
            jj = j - 1;
            if (matrix.get(i)[jj]) {
                getHisNeighbors(i, jj, matrix, island, columnSize , rowSize);
            }
        }
        // verify up
        if (i > 0) {
            ii = i - 1;
            if (matrix.get(ii)[j]) {
                getHisNeighbors(ii, j, matrix, island, columnSize , rowSize);
            }
        }
    }
}
