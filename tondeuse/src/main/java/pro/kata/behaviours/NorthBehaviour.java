package pro.kata.behaviours;

import pro.kata.Coordinates;

public class NorthBehaviour implements Behaviour{

    @Override
    public Behaviour turnLeftBehaviour() {
        return new WestBehaviour();
    }

    @Override
    public Behaviour turnRightBehaviour() {
        return new EastBehaviour();
    }

    @Override
    public boolean checkForwardMove(Coordinates coord, Integer dimensionX, Integer dimensionY){
        return (coord.getY()+1 <= dimensionY);
    };

    @Override
    public void moveForward(Coordinates coord) {
        coord.setY(coord.getY()+1);
    }
    
    public String toString(){
        return "N";
    }
}
