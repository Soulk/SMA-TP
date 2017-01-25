package utils;

import core.PropertiesReader;

import java.io.*;
import java.util.Properties;

/**
 * Created by decottignies on 18/01/17.
 */
public class CSVManager {

    private static CSVManager instance;
    private OutputStream output;
    private PrintStream printStream;

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

    public void stopRecord(){
        try {
            output.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void printDeplacement(String type,int posX, int posY) {
        System.out.println();
    }
    public void printNaissance(String type) {
        System.out.println();
    }
    public void printDeces(String type, int age) {
        System.out.println();
    }
}
