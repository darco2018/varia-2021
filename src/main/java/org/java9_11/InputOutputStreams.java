package org.java9_11;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class InputOutputStreams {

    public static void main(String[] args) throws IOException {

        // InputStream finally gets a super useful method to transfer data to an OutputStream,
        // a usecase that's very common when working with streams of raw data.
        var classLoader = ClassLoader.getSystemClassLoader();
        var inputStream = classLoader.getResourceAsStream("myFile.txt");
        var tempFile = File.createTempFile("myFileCopy", "txt");
        try (var outputStream = new FileOutputStream(tempFile)) {
            inputStream.transferTo(outputStream);
        }
    }
}
