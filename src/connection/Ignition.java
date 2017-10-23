package connection;

import parsing.FileLoader;

import java.io.IOException;

/**
 * The main class.
 * Everything starts here.
 */
public class Ignition {
    public static void main(String args[]) {
        try {
            new Thread(new FileLoader("https://www.google.com/")).start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
