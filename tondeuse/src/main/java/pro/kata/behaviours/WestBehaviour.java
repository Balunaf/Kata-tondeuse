package pro.kata.behaviours;

import pro.kata.Coordinates;

public class WestBehaviour implements Behaviour{

    @Override
    public Behaviour turnLeftBehaviour() {
        return new SouthBehaviour();
    }

    @Override
    public Behaviour turnRightBehaviour() {
        return new NorthBehaviour();
    }

    @Override
    public boolean checkForwardMove(Coordinates coord, Integer dimensionX, Integer dimensionY){
        return (coord.getX()-1 >= 0);
    };

    @Override
    public void moveForward(Coordinates coord) {
        coord.setX(coord.getX()-1);
    }
    
    public String toString(){
        return "W";
    }
}
