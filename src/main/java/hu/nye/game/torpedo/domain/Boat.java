package hu.nye.game.torpedo.domain;



import java.util.ArrayList;
import java.util.List;
import hu.nye.game.torpedo.interfaces.BoatInterface;


public class  Boat implements BoatInterface {
    private List<Position> hajoElemek;
    private Position kezdoPoz;
    private int hossz;
    int x;
    int y;
    private boolean orient;

    public Boat(Position kezdoPoz, int hossz, boolean orient) {
        this.kezdoPoz = kezdoPoz;
        this.hossz = hossz;
        this.orient = orient;
    }

    public List<Position> getHajoElemek() {
        int x = 0;
        int y = 0;
        if (!orient) x = 1;
        if (orient) y = 1;
        List<Position> hajoElemek = new ArrayList<>();
        for (int h = 0; h < hossz; h++) {
            hajoElemek.add(new Position(this.kezdoPoz.getX() + (x * h), this.kezdoPoz.getY() + (y * h)));
        }

        return hajoElemek;
    }

    @Override
    public String toString() {
        return "x:y " + this.hajoElemek.get(0).getX() + ":" + this.hajoElemek.get(0).getY() + " hossza:" +
                this.hajoElemek.size();
    }
}