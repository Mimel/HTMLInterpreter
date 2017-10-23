package parsing;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

/**
 * A loader thread that works with a parser thread to convert a file object into
 * an object that can be manipulated by the browser. The input stream and all associated
 * data are located in this class, and the sole job of this class is to provide data to
 * the parser in chunks.
 *
 * When loading a file, create an instance of this class instead of a parser class.
 */
public class FileLoader implements Runnable {
    public static final int CHUNK_SIZE = 500;
    private BufferedReader inStream;
    private Parser parser;

    public FileLoader(String file) throws IOException {
        URL targetFile = new URL(file);

        String filePath = targetFile.getPath();
        String fileExtension = filePath.substring(filePath.lastIndexOf('.') + 1);

        this.parser = ParserFactory.getParser(fileExtension);
        HttpsURLConnection conn = (HttpsURLConnection) targetFile.openConnection();

        conn.setDoOutput(false);
        conn.setDoInput(true);
        conn.setRequestMethod("GET");

        this.inStream = new BufferedReader(new InputStreamReader(conn.getInputStream()));
    }

    /**
     * Loads chunks, and sends them to the parser.
     * The FileLoader reads a chunk when the Parser thread is waiting.
     */
    @Override
    public void run() {
        String line;
        try {
            while ((line = inStream.readLine()) != null) {
                parser.receive(line.toCharArray());
                parser.parse();
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}
