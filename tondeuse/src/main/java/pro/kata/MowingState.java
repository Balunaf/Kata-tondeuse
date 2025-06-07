package pro.kata;

import pro.kata.behaviours.Behaviour;

public class MowingState {
    private Integer maximumX;
    private Integer maximumY;
    private Coordinates coordinates;
    private Behaviour currentBehaviour;
    private String instructions;

    public MowingState(Integer x, Integer y, Coordinates coordinates, Behaviour behaviour, String instructionsString){
        maximumX = x;
        maximumY = y;
        this.coordinates = coordinates;
        currentBehaviour = behaviour;
        instructions = instructionsString;
    }

    public void run(){

    }

    private void moveForward(){
        currentBehaviour.moveForward(coordinates);
    }

    private void turnLeftBehaviour(){
        currentBehaviour = currentBehaviour.turnLeftBehaviour();
    }

    private void turnRightBehaviour(){
        currentBehaviour = currentBehaviour.turnRightBehaviour();
    }

    public String toString(){
        return coordinates.toString()+" "+currentBehaviour.toString();
    }

    public Integer getXSize(){
        return maximumX;
    }

    public Integer getYSize(){
        return maximumY;
    }

    public Coordinates getCoordinates(){
        return coordinates;
    }

    public Behaviour getBehaviour(){
        return currentBehaviour;
    }

    public void setBehaviour(Behaviour behaviour){
        currentBehaviour = behaviour;
    }

    public String getInstructions(){
        return instructions;
    }
}
