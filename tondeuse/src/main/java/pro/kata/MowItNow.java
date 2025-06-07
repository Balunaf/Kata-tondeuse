package pro.kata;

import java.io.IOException;
import java.util.List;

public class MowItNow {
    public static void main(String[] args) {
        if(args.length == 0)
            System.out.println("Lacking a file argument");
        else{
            try{
                List<MowingState> mowingStates = InstructionDecryptor.readFile(args[0]);
                for (MowingState state : mowingStates){
                    state.run();
                }
                mowingStates.stream().forEach(state -> {System.out.print(state.toString()+" ");});
                System.out.println();
            } catch (IOException e){
                System.out.println("File name '"+args[0]+" is not recognized");
            }
        }
    }
}