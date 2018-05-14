import java.util.ArrayList;

class Island {
    /**
     * List of cells that contistue an island
     */
    private ArrayList<Cell> island;

    /**
     * empty constructor
     */
    Island() {
        this.island = new ArrayList<>();
    }

    /**
     * Get method of island
     * @return island
     */
    public ArrayList<Cell> getIsland() {
        return island;
    }

    /**
     * boolean method to see if contains the cell
     * @param cell the cell to see if is contained by the island
     * @return true if contains and false otherwise
     */
    public boolean contains(Cell cell){
        return this.island.contains(cell);
    }

    /**
     * method to String to write like as asked
     * @return the representative of the String of the island
     */
    @Override
    public String toString() {
        int size = island.size() -1;
        StringBuilder stringBuilder = new StringBuilder("[");
        for (int i = 0; i < size ; i++) {
            stringBuilder.append(island.get(i)).append(",");
        }
        stringBuilder.append(island.get(size)).append("]");
        return stringBuilder.toString();
    }

    /**
     * method to add a cell to an island
     * @param cell cell to be added in island
     */
    void addCell(Cell cell){
        this.island.add(cell);
    }

    /**
     *
     * @return true if there are more then one and false if exist only one island
     */
    boolean moreThanOne(){
        return this.island.size() > 1;
    }

    boolean arePointOfContact(Island otherIsland){
        for (Cell cell: island) {
            for (Cell otherCell : otherIsland.island) {
                if(cell.isNeighbor(otherCell))
                    return true;
            }
        }
        return false;
    }
}
