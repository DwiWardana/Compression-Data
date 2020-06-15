package com.parsect;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class fileprocess {
    public static byte[] readingFile(String file){
        byte[] data = null;
        Path path = Paths.get(file);
        try {
            data = Files.readAllBytes(path);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return data;
    }
    public static void writeFile(byte[] data, String output) throws IOException {
        try {
            // create a writer
            try{
                Path path = Paths.get(output);
                Files.write(path, data);
            } catch (Exception e){
                System.out.println(e);
            }
        } catch (Exception e){
            System.out.println(e);
        }

    }
}
