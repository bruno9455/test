import java.util.ArrayList;

/**
 * class for find islands
 *
 * @author brunosantos
 */
class IslandFinder2 {
    private ArrayList<Cell> islands;

    public IslandFinder2() {
        this.islands = new ArrayList<>();
    }

    void findIslands(ArrayList<boolean[]> matrix, InputOutput inputOutput) {
        int columnSize = matrix.get(0).length;
        int rowSize = matrix.size();
        // inputOutput.openWriter();
        for (int i = 0; i < rowSize; i++) {
            for (int j = 0; j < columnSize; j++)
                if (matrix.get(i)[j]) {
                    Cell cell = new Cell(i,j);
                   // this.islands.add(cell);
                }
        }
        //  inputOutput.closeWriter();
    }

    /**
     * recursive method to find neighbors around the 1
     *
     * @param i      index of line
     * @param j      index of column
     * @param matrix matrix of booleans
     * @param island an island created
     * @param size   size of matrix
     */
    private void getHisNeighbors(int i, int j, ArrayList<boolean[]> matrix, Island island, int columnSize, int rowSize) {
        int ii, jj;
        Cell cell = new Cell(i, j);
        island.addCell(cell);
        matrix.get(i)[j] = false;

        // verify right
        if (i < rowSize - 1) {
            ii = i + 1;
            if (matrix.get(ii)[j]) {
                getHisNeighbors(ii, j, matrix, island, columnSize, rowSize);
            }
        }
    }
}
