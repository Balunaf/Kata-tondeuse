package pro.kata;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import pro.kata.behaviours.NorthBehaviour;

public class InstructionDecryptor {
    /*
     * Transform a file in a List of MowingState, each corresponding to a single mower, garden and instructions
     */
    public static List<MowingState> readFile(String filePath) throws IOException{
        List<String> lines = Files.readAllLines(Paths.get(filePath));

        List<MowingState> mowingList = new ArrayList<>();

        return mowingList;
    }
}
