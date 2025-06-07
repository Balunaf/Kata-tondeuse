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
        for(String string : instructions.split("")){
            switch (string) {
                case "A":
                    if(checkForwardMove()){
                        moveForward();}
                    break;
                case "D":
                    turnRightBehaviour();
                    break;
                case "G":
                    turnLeftBehaviour();
                    break;
            
                default:
                    break;
            }
        }
    }

    private boolean checkForwardMove(){
        return currentBehaviour.checkForwardMove(coordinates, maximumX, maximumY);
    }

    private void moveForward(){
        currentBehaviour.moveForward(coordinates);
    }

    private void turnLeftBehaviour(){
        setBehaviour(currentBehaviour.turnLeftBehaviour());
    }

    private void turnRightBehaviour(){
        setBehaviour(currentBehaviour.turnRightBehaviour());
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
