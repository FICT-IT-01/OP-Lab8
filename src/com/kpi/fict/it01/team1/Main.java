package com.kpi.fict.it01.team1;

import com.kpi.fict.it01.team1.models.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.TreeSet;
import java.util.concurrent.ThreadLocalRandom;

public class Main {
    public static void main(String[] args) {
        TreeSet<ColoredPixel> pixels = new TreeSet<>(new Comparator<ColoredPixel>() {
            @Override
            public int compare(ColoredPixel o1, ColoredPixel o2) {
                return o1.getColor().compareTo(o2.getColor());
            }
        });

        pixels.addAll(generatePixels(3));

        printPixelsArray(pixels);
        pixels.addAll(Arrays.asList(orderPixelsByDefaultComparator(pixels)));
        printPixelsArray(pixels);
    }

    private static ColoredPixel[] orderPixelsByDefaultComparator(TreeSet<ColoredPixel> pixels) {
        var pixelsArray = pixels.toArray(new ColoredPixel[0]);

        Arrays.sort(pixelsArray, new Pixel.DefaultPixelComparator());

        return pixelsArray;
    }

    private static void printPixelsArray(TreeSet<? extends Pixel> pixels) {
        for (var pixel : pixels) {
            System.out.println(pixel.toString());
        }
    }

    private static ArrayList<ColoredPixel> generatePixels(int amount) {
        ArrayList<ColoredPixel> pixels = new ArrayList<>();

        var randGenerator = ThreadLocalRandom.current();

        for (int i = 0; i < amount; ++i) {
            pixels.add(new ColoredPixel(
                    new Coordinates(randGenerator.nextInt(0, 10),
                                    randGenerator.nextInt(0, 100)),
                    new Color(randGenerator.nextInt(0, 255),
                              randGenerator.nextInt(0, 255),
                              randGenerator.nextInt(0, 255))));
        }

        return pixels;
    }
}
