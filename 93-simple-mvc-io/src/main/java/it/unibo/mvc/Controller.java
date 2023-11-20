package it.unibo.mvc;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

/**
 * Application controller. Performs the I/O.
 */
public class Controller {

    private String pathFile;

    public Controller() {
        this.pathFile = System.getProperty("user.home") + System.getProperty(File.separator) + "output.txt";
    }

    public Controller(String filePath) {
        this.pathFile = filePath;
    }

    private File getMyFile() {
        return new File(this.pathFile);
    }

    private String pathCurrentFile() {
        return this.pathFile;
    }

    void writeStringOnCurrentFile(String content) throws IOException{
        try {
            PrintStream ps = new PrintStream(pathFile, StandardCharsets.UTF_8);
            ps.println(content);
        } catch (IOException e) {
            System.out.println("Error.");
        }
    }
}
