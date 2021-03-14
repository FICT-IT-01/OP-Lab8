package com.kpi.fict.it01.team1.models;

import java.util.Comparator;

public abstract class Pixel {
    private Coordinates coordinates;

    public Pixel(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    @Override
    public String toString() {
        return "Pixel" + coordinates;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pixel)) return false;
        Pixel pixel = (Pixel) o;
        return getCoordinates().equals(pixel.getCoordinates());
    }

    @Override
    public int hashCode() {
        return coordinates.hashCode();
    }

    public static class DefaultPixelComparator implements Comparator<Pixel> {
        @Override
        public int compare(Pixel o1, Pixel o2) {
            return o1.coordinates.compareTo(o2.coordinates);
        }
    }
}
