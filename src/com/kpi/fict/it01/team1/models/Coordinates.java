package com.kpi.fict.it01.team1.models;

import java.util.Comparator;
import java.util.Objects;

public class Coordinates implements Comparable<Coordinates> {
    private int x;
    private int y;

    public Coordinates(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Coordinates)) return false;
        Coordinates that = (Coordinates) o;
        return getX() == that.getX() && getY() == that.getY();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getX(), getY());
    }

    @Override
    public int compareTo(Coordinates o) {
        if (x + y > o.x + o.y) {
            return 1;
        }
        else if (x + y < o.x + o.y) {
            return -1;
        }

        return 0;
    }
}
