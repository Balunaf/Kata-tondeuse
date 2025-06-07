package pro.kata.behaviours;

import pro.kata.Coordinates;

public class SouthBehaviour implements Behaviour{

    @Override
    public Behaviour turnLeftBehaviour() {
        return new EastBehaviour();
    }

    @Override
    public Behaviour turnRightBehaviour() {
        return new WestBehaviour();
    }

    @Override
    public boolean checkForwardMove(Coordinates coord, Integer dimensionX, Integer dimensionY){
        return (coord.getY()-1 >= 0);
    };

    @Override
    public void moveForward(Coordinates coord) {
        coord.setY(coord.getY()-1);
    }
    
    
    public String toString(){
        return "S";
    }
}
