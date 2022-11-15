package hu.nye.game.torpedo.services;

import hu.nye.game.torpedo.domain.Boat;
import hu.nye.game.torpedo.domain.Position;
import hu.nye.game.torpedo.domain.Table;
import hu.nye.game.torpedo.interfaces.MainServiceInterface;

import java.util.*;

public class MainService implements MainServiceInterface {
    private Random random = new Random();
    boolean orient;
    private int kiValaszPozi;
    public MainService() {}

    public void hajoLerakas(Table tabla, Position poz, int hossz, boolean orient) {
        Set<Position> halmaz = new HashSet<>();
        int x = 0;
        int y = 0;
        if (!orient) x = 1;
        if (orient) y = 1;
        for (int h = 0; h < hossz; h++) {
            for (int i = -1; i < 2; i++) {
                for (int j = -1; j < 2; j++) {
                    halmaz.add(new Position((poz.getX() + (h * x)) + i, (poz.getY() + (h * y)) + j));
                }
            }
        }
        halmaz.removeIf(pozicio -> ((pozicio.isNegativ()) || (pozicio.isOut())));
        for (Position pozicio : halmaz) {
            tabla.setJatekTeMezo(pozicio.getX(), pozicio.getY(), false);
        }
    }


    public Table getTabla(){
        List<Position> szabadHajoHelyek ;
        List<Boat>  hajok=new ArrayList<>();
        Table jatekTer=new Table(10,10);
        int h ;
        for (int j = 4; j > 0; j--) {
            h = j;
            while (h > 0) {

                orient = intToBool(random.nextInt(2));
                szabadHajoHelyek = jatekTer.getSzabadPozFor(h, orient);
                kiValaszPozi = random.nextInt(szabadHajoHelyek.size());
                hajoLerakas(jatekTer, szabadHajoHelyek.get(kiValaszPozi), h, orient);
                hajok.add(new Boat(szabadHajoHelyek.get(kiValaszPozi), h, orient));
                h--;
            }
        }
        int x = 0;
        int y = 0;
        Table result = new Table(10, 10);
        for (int i = 0; i < hajok.size(); i++) {
            for (int j = 0; j < hajok.get(i).getHajoElemek().size(); j++) {
                x = hajok.get(i).getHajoElemek().get(j).getX();
                y = hajok.get(i).getHajoElemek().get(j).getY();
                result.setJatekTeMezo(x, y, false);
            }
        }
        return result;
    }
    public boolean intToBool(int i) {
        return i == 1;
    }
}
