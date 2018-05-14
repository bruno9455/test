import java.io.File;
import java.util.ArrayList;

class AdjacentCellsChallenge {

    public static void main(String[] args) {
        long startTime, endTime;
        int totalTime = 0;

        InputOutput inputOutput = new InputOutput();
        // choose the json file with fiilechooser
        File file = inputOutput.selectFile();
        System.out.println("Start reading the file");
        // Read the file and create the boolean matrix
        startTime = System.currentTimeMillis();
        ArrayList<boolean[]> matrix = inputOutput.readFile(file);
        endTime = System.currentTimeMillis();
        System.out.println("Time to read and create boolean Matrix " + (endTime - startTime) + " milliseconds");
        totalTime += (endTime - startTime);
        // the size of the readied matrix
        System.out.printf("the matrix have %d x %d\n", matrix.size(), matrix.get(0).length);


        // calling the islandFinder
        IslandFinder islandFinder = new IslandFinder();
        startTime = System.currentTimeMillis();
        islandFinder.findIslands(matrix, inputOutput);
        endTime = System.currentTimeMillis();
        System.out.println("running throw the matrix took " + (endTime - startTime) + " milliseconds");
        totalTime +=(endTime-startTime);

        // print the total time of the operation
        System.out.println("total time spent: " + totalTime + " milliseconds");
    }
}
