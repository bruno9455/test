import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;
import java.io.*;
import java.util.ArrayList;

class InputOutput {
    private ArrayList<boolean[]> matrix;
    private String fileOutput;
    private BufferedWriter writer;
    private int size;

    public InputOutput() {
        this.matrix = new ArrayList<>();
        this.writer = null;
        this.size = 0;
    }

    /**
     * method to select json file by filechooser
     *
     * @return the file selected by filechooser
     */
    File selectFile() {
        File selectedFile = null;
        JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
        jfc.setDialogTitle("Choose a json file to read the matrix:");
        jfc.setAcceptAllFileFilterUsed(false);
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Json files", "json");
        jfc.addChoosableFileFilter(filter);
        int returnValue = jfc.showOpenDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            selectedFile = jfc.getSelectedFile();
        } else {
            System.out.println("Cancelled");
        }
        // build the string with the name of the output in the same folder of the reading json
        this.fileOutput = selectedFile.getPath().replaceAll(selectedFile.getName(), "resultados - ") + selectedFile.getName().replaceAll("json", "txt");
        // erase the file if already exist
        File file = new File(this.fileOutput);
        if (file.exists())
            file.delete();
        return selectedFile;
    }

    /**
     * Method to read file
     *
     * @return the matrix
     */
    ArrayList<boolean[]> readFile(File file) {
        try (
                BufferedReader reader = new BufferedReader(new java.io.FileReader(file), 4 * 1048576)) {
            String firstLine = reader.readLine();
            startMatrix(firstLine);
            String line;
            while ((line = reader.readLine()) != null) {
                write2Matrix(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return this.matrix;
    }

    /**
     * method to start the matrix
     *
     * @param line first line of matrix
     */
    private void startMatrix(String line) {
        int size = (line.length() - 3) / 2;
        if (size > 1) {
            boolean[] matrixLine = new boolean[size];
            for (int i = 0; i < size; i++) {
                matrixLine[i] = line.charAt(2 * i + 2) != '0';
            }
            this.matrix.add(matrixLine);
        }
    }

    /**
     * method to fill the matrix
     *
     * @param line lines of the matrix
     */
    private void write2Matrix(String line) {
        int sizeTemp = (line.length() - 2) / 2;
        if (sizeTemp > 1) {
            if (this.size == 0) {
                this.size = sizeTemp;
            }
            boolean[] matrixLine = new boolean[this.size];
            for (int i = 0; i < size; i++) {
                matrixLine[i] = line.charAt(2 * i + 1) != '0';
            }
            this.matrix.add(matrixLine);
        }
    }

    /**
     * method to open writer
     */
    void openWriter() {
        try {
            this.writer = new BufferedWriter(new FileWriter(this.fileOutput));
            this.writer.write("[");
            this.writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * method to write to file
     */
    synchronized void write2File(String island) {

        try {
            this.writer.write(island);
            this.writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * method to close the writer
     */
    void closeWriter() {
        try {
            this.writer.write("]");
            this.writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

