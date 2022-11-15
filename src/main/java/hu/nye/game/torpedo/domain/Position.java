package hu.nye.game.torpedo.domain;

import java.util.Objects;

public class Position {
    private int x;
    private int y;
    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
    public Position(){};

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public String toString() {
        return "Pozicio{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position pozicio = (Position) o;
        return x == pozicio.x && y == pozicio.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    public boolean isNegativ(){
        boolean result= false;
        if ((getX()<0)||(getY()<0)) result=true;
        return result;
    }

    public boolean isOut(){
        boolean result= false;
        if ((getX()>9)||(getY()>9)) result=true;
        return result;
    }
}
