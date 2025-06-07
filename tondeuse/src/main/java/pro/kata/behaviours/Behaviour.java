package pro.kata.behaviours;

import pro.kata.Coordinates;

public interface Behaviour {
    public Behaviour turnLeftBehaviour();

    public Behaviour turnRightBehaviour();

    public void moveForward(Coordinates coord);

    public boolean checkForwardMove(Coordinates coord, Integer dimensionX, Integer dimensionY);
}
