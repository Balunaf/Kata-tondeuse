import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;

import java.io.IOException;
import java.util.List;

import org.junit.jupiter.api.Test;

import pro.kata.Coordinates;
import pro.kata.InstructionDecryptor;
import pro.kata.MowingState;
import pro.kata.behaviours.EastBehaviour;
import pro.kata.behaviours.NorthBehaviour;

public class Tests {
    @Test
    /*
     * In this test we open a file and check that it is correctly changed into a list of MowingStates with the decryptor
     * Dans ce test nous ouvrons un fochier test et vérifions qu'il est transformé correctement en objets
     */
    public void decryptFile(){
        try{
            List<MowingState> mowingStates = InstructionDecryptor.readFile("src/test/java/resources/TestFile.txt");
            assertNotNull(mowingStates);

            MowingState state = mowingStates.get(0);
            assertEquals(state.getXSize(), 5);
            assertEquals(state.getYSize(), 5);
            assertEquals(state.getCoordinates(), new Coordinates(1, 2));
            assertEquals(state.getBehaviour().getClass(), new NorthBehaviour().getClass());
            assertEquals(state.getInstructions(), "GAGAGAGAA");

            state = mowingStates.get(1);
            assertEquals(state.getXSize(), 5);
            assertEquals(state.getYSize(), 5);
            assertEquals(state.getCoordinates(), new Coordinates(3, 3));
            assertEquals(state.getBehaviour().getClass(), new EastBehaviour().getClass());
            assertEquals(state.getInstructions(), "AADAADADDA ");

        } catch (IOException e) {
            System.out.println("Error while accessing test file");
            fail(e);
        }
    }

    @Test
    /*
     * In this test function we test all behaviours and if the mower's state is coherent all throughout
     * Dans cette fonction de test nous testons tous les comportements et si l'état de la tondeuse est cohérent
     */
    public void testBehaviour(){
        //The instructions of this test test all 4 behaviour strategies and makes a single square of movement, so is supposed to end at the same place it starts at
        MowingState state = new MowingState(4, 4, new Coordinates(1, 1), new NorthBehaviour(), "ADGGADGGADGGADGG");
        state.run();
        assertEquals(state.getCoordinates(), new Coordinates(1, 1));
        assertEquals(state.getBehaviour().getClass(), new NorthBehaviour().getClass());

        //Testing the given examples to check correct execution
        MowingState state1 = new MowingState(5, 5, new Coordinates(1, 2), new NorthBehaviour(), "GAGAGAGAA");
        state1.run();
        assertEquals(state1.getCoordinates(), new Coordinates(1, 3));
        assertEquals(state1.getBehaviour().getClass(), new NorthBehaviour().getClass());

        MowingState state2 = new MowingState(5, 5, new Coordinates(3, 3), new EastBehaviour(), "AADAADADDA");
        state2.run();
        assertEquals(state2.getCoordinates(), new Coordinates(5, 1));
        assertEquals(state2.getBehaviour().getClass(), new EastBehaviour().getClass());
    }
} 
