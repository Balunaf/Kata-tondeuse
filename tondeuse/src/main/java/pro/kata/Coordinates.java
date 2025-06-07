package pro.kata;

public class Coordinates {
    private Integer x;
    private Integer y;

    public Coordinates(Integer x, Integer y){
        this.x = x;
        this.y = y;
    }

    public Integer getX(){
        return x;
    }

    public Integer getY(){
        return y;
    }

    public void setX(Integer newX){
        x = newX;
    }

    public void setY(Integer newY){
        y= newY;
    }

    public String toString(){
        return x+" "+y;
    }
}
