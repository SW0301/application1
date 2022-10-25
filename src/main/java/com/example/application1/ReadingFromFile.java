package com.example.application1;



import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;


public class ReadingFromFile {
    public ArrayList<Integer> reading(String filePath) {
        ArrayList<Integer> numberList = new ArrayList<>();
        Path path = Paths.get(filePath);
        try {
            Files.lines(path).forEach(line -> numberList.add(Integer.valueOf(line)));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }



        return numberList;



    }
}
