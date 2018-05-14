/**
 * Class of object cell
 *
 * @author brunosantos
 */
class Cell {
    /**
     * elements of the class Cell
     */
    private int line;
    private int column;

    /**
     * constructor
     *
     * @param line   index of the cell (line)
     * @param column index of the cell (column)
     */
    public Cell(int line, int column) {
        this.line = line;
        this.column = column;
    }


    /**
     * method to String to write like as asked
     *
     * @return the representative of the String of the cell
     */
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("[").append(line).append(",").append(column).append("]");
        return stringBuilder.toString();
    }

    /**
     * equals of cell
     *
     * @param o object to compare to the cell
     * @return
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cell)) return false;
        Cell cell = (Cell) o;
        return line == cell.line &&
                column == cell.column;
    }


    /**
     * method to see if a cell is neighbor of other
     * @param otherCell other cell
     * @return true if it is a neighbor
     */
    boolean isNeighbor(Cell otherCell){
        if((this.line == otherCell.line) && (this.column == otherCell.column +1 || this.column == otherCell.column +1))
            return true;
        if((this.column == otherCell.column) && (this.line == otherCell.line +1 || this.line == otherCell.line +1))
            return true;
        return false;
    }
}
