package hu.nye.game.torpedo.services;


import hu.nye.game.torpedo.domain.Table;

public class UIService {
    public UIService() {}

    public void tablaKirajzolas(Table tabla1, Table tabla2){

        System.out.println("         Your Fields                                         Shoots");
        System.out.println("   A  B  C  D  E  F  G  H  I  J                   A  B  C  D  E  F  G  H  I  J");
        for(int i=0; i<10; i++){
            tabla1.sorKiIratas(i);
            System.out.print("               ");
            tabla2.sorKiIratas(i);
            System.out.println();
        }
    }

    public String gepTalalat(boolean b){
        if (b) {return "            BOT HIT                                 ";}

       return "            BOT MISS                                  ";
    }

    public String jatekosTalalat(boolean b){

        if (b) {return "U HIT";}

        return "U MISS";
    }

}
