package pro.kata.behaviours;

import pro.kata.Coordinates;

public class EastBehaviour implements Behaviour{

    @Override
    public Behaviour turnLeftBehaviour() {
        return new NorthBehaviour();
    }

    @Override
    public Behaviour turnRightBehaviour() {
        return new SouthBehaviour();
    }

    @Override
    public boolean checkForwardMove(Coordinates coord, Integer dimensionX, Integer dimensionY){
        return (coord.getX()+1 <= dimensionX);
    };

    @Override
    public void moveForward(Coordinates coord) {
        coord.setX(coord.getX()+1);
    }

    public String toString(){
        return "E";
    }
}
