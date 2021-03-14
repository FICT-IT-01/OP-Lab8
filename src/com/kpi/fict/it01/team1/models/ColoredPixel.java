package com.kpi.fict.it01.team1.models;

public class ColoredPixel extends Pixel {
    private Color color;

    public ColoredPixel(Coordinates coordinates, Color color) {
        super(coordinates);
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "ColoredPixel" + getCoordinates() + ", " + color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        ColoredPixel that = (ColoredPixel) o;

        return color.equals(that.color);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + color.hashCode();
        return result;
    }
}
