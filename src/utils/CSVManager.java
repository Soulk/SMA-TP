package utils;

import core.PropertiesReader;

import java.io.*;
import java.util.Properties;

/**
 * Created by decottignies on 18/01/17.
 */
public class CSVManager {

    private static CSVManager instance;
    static OutputStream output;
    public PrintStream printStream;

    public CSVManager() throws FileNotFoundException {
        output = new FileOutputStream("stat.csv");
        printStream = new PrintStream(output);
    }

    public static CSVManager getInstance()  {
        if(instance == null) {
            try {
                instance = new CSVManager();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return instance;
    }

    public void writeCSV(String line){
        printStream.print(line);
    }

}
