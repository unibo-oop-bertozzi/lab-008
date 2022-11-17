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
    private File file;
    Controller() {
        this.file = new File(PATH);
    }
    /**
     * @param file
     */
    public void setCurrentFile(final File file) {
        this.file = file;
    }
    /**
     * @return getfile
     */
    public File getFILE() {
        return file;
    }
    /**
     * @return getpath
     */
    public String getPath() {
        return file.getPath();
    }
    /**
     * @param write
     * @throws IOException
     */
    public void writeFile(final String write) throws IOException {
        try (PrintStream ps = new PrintStream(file.getPath(), StandardCharsets.UTF_8)) {
            ps.print(write);
        }
    }
}
