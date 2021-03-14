package com.kpi.fict.it01.team1.models;

public class Color implements Comparable<Color> {
    private int r;
    private int g;
    private int b;

    public Color(int r, int g, int b) {
        if (r < 0 || r > 255
            ||g < 0 || g > 255
            ||b < 0 || b > 255) {
            throw new IllegalArgumentException("r, g, b must be in range [0; 255].");
        }

        this.r = r;
        this.g = g;
        this.b = b;
    }

    public Color(String colorHex) {
        r = Integer.valueOf(colorHex.substring(1, 3), 16);
        g = Integer.valueOf(colorHex.substring(3, 5), 16);
        b = Integer.valueOf(colorHex.substring(5, 7), 16);
    }

    public int getR() {
        return r;
    }

    public void setR(int r) {
        if (r < 0 || r > 255) {
            throw new IllegalArgumentException("r must be in range [0; 255].");
        }
        this.r = r;
    }

    public int getG() {
        return g;
    }

    public void setG(int g) {
        if (g < 0 || g > 255) {
            throw new IllegalArgumentException("g must be in range [0; 255].");
        }
        this.g = g;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        if (b < 0 || b > 255) {
            throw new IllegalArgumentException("b must be in range [0; 255].");
        }
        this.b = b;
    }

    private String getHex() {
       return String.format("#%02x%02x%02x", r, g, b);
    }

    @Override
    public String toString() {
        return "Color - " +
                "RGB(" + r + ", " + g + ", " + b + ")" +
                ", Hex(" + getHex() + ")";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Color color = (Color) o;

        if (r != color.r) return false;
        if (g != color.g) return false;
        return b == color.b;
    }

    @Override
    public int hashCode() {
        int result = r;
        result = 31 * result + g;
        result = 31 * result + b;
        return result;
    }

    @Override
    public int compareTo(Color o) {
        if (hashCode() > o.hashCode()) return 1;
        else if (hashCode() < o.hashCode()) return -1;
        return 0;
    }
}
