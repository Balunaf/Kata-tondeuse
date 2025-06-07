package pro.kata;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import pro.kata.behaviours.Behaviour;
import pro.kata.behaviours.EastBehaviour;
import pro.kata.behaviours.NorthBehaviour;
import pro.kata.behaviours.SouthBehaviour;
import pro.kata.behaviours.WestBehaviour;

public class InstructionDecryptor {
    /*
     * Transform a file in a List of MowingState, each corresponding to a single mower, garden and instructions
     * 
     * This file will ignore and not raise an error if a three line state is incomplete
     */
    public static List<MowingState> readFile(String filePath) throws IOException, TypeNotPresentException{
        List<String> lines = Files.readAllLines(Paths.get(filePath));

        List<MowingState> mowingList = new ArrayList<>();

        String[] dimensions = lines.get(0).split(" ");
        Integer dimensionX = Integer.valueOf(dimensions[0]);
        Integer dimensionY = Integer.valueOf(dimensions[1]);
        
        Integer lineNumber = 1;
        while (lines.size()>=lineNumber+2) {
            String startingPositionLine = lines.get(lineNumber);
            String instructionsLine = lines.get(lineNumber+1);
            mowingList.add(generateMowingState(dimensionX, dimensionY, startingPositionLine, instructionsLine));
            lineNumber += 2;
        }

        return mowingList;
    }

    private static MowingState generateMowingState(Integer dimensionX, Integer dimensionY, String startingPositionLine, String instructionsLine) throws TypeNotPresentException{
        String[] position = startingPositionLine.split(" ");
        Coordinates coordinates = new Coordinates(Integer.valueOf(position[0]), Integer.valueOf(position[1]));
        Behaviour behaviour = matchBehaviour(position[2]);
        return new MowingState(dimensionX, dimensionY, coordinates, behaviour, instructionsLine);
    }

    private static Behaviour matchBehaviour(String label) throws TypeNotPresentException{
        switch (label) {
            case "N":
                return new NorthBehaviour();
            case "S":
                return new SouthBehaviour();
            case "E":
                return new EastBehaviour();
            case "W":
                return new WestBehaviour();
        
            default:
                throw new TypeNotPresentException(label, null);
        }
    }
}
