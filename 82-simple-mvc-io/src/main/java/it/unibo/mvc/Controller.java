package it.unibo.mvc;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

/**
 * Application controller. Performs the I/O.
 */
public class Controller {
    private static final String PATH = System.getProperty("user.home")
            + System.getProperty("file.separator")
            + "output.txt";
    File FILE;
    Controller() {
        this.FILE=new File(FILE, PATH);
    }
    public void setCurrentFile(final File file) {
        this.FILE=file;
    }
    public File getFILE() {
        return FILE;
    }
    public String getPath(){
        return FILE.getPath();
    }
    public void WriteFIle(String write) throws IOException {
        try (PrintStream ps = new PrintStream(FILE.getPath(), StandardCharsets.UTF_8)) {
            ps.print(write);
        }
    }
}
