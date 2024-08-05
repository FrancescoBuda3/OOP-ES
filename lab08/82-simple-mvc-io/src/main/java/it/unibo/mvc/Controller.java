package it.unibo.mvc;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;


/**
 * Application controller. Performs the I/O.
 */
public class Controller {

    /**
     * 
     */
    private static String HOME = System.getProperty("user.home");
    /**
     * 
     */
    private static String SEP = System.getProperty("file.separator");

    private File current;

    /**
     * 
     */
    public Controller() {
        this.current = new File(HOME + SEP + "output.txt");
    }


    public void setCurrentFile(File f) {
        this.current = f;
    }

    public File getCurrentFile() {
        return this.current;
    }

    public String getPathString() {
        return this.current.getPath();
    }

    public void writeString(String s) throws IOException {
        try(final OutputStream file = new FileOutputStream(this.current);
        final DataOutputStream out = new DataOutputStream(file);) {
             out.writeUTF(s); 
        }
    }



}
