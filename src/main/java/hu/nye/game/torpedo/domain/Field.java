package hu.nye.game.torpedo.domain;


import java.util.Objects;

public class Field {
    private Position pozicio;
    private boolean szabad;
    private boolean talalat;
    private boolean lovesHelye;

    public Field(){}

    public Position getPozicio() {
        return pozicio;
    }

    public void setPozicio(Position pozicio) {
        this.pozicio = pozicio;
    }

    public boolean isTalalat() {
        return talalat;
    }

    public void setTalalat(boolean talalat) {
        this.talalat = talalat;
    }

    public boolean isLovesHelye() {
        return lovesHelye;
    }

    public void setLovesHelye(boolean lovesHelye) {
        this.lovesHelye = lovesHelye;
    }

    public Field(Position pozicio, boolean szabad) {
        this.pozicio = pozicio;
        this.szabad = szabad;
        this.talalat = false;
        this.lovesHelye = false;
    }

    public void setLovesHelye() {
        this.lovesHelye =true;
    }

    public void setTalalt() {
        this.talalat = true;
    }

    public boolean getTalalat() {
        return this.talalat;
    }

    public boolean isSzabad() {
        return szabad;
    }

    public void setSzabad(boolean szabad) {
        this.szabad = szabad;
    }


    @Override
    public String toString() {
        String result = "";

        if (lovesHelye) {
            return "\u001B[31m[X]";
        }
        if (getTalalat()) {
            return "\u001B[32m[0]";
        }
        if (isSzabad()) {
            return "\u001B[34m[ ]";
        }
        if (!isSzabad()) {
            return "\u001B[33m[#]";
        }


        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Field mezo = (Field) o;
        return szabad == mezo.szabad && Objects.equals(pozicio, mezo.pozicio);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pozicio, szabad);
    }
}
