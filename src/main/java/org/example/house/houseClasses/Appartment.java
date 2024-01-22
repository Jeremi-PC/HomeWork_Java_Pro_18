package org.example.house.houseClasses;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Appartment {
    static Random rnd = new Random();
    List<Flat> flatList = new ArrayList<>();

    public Appartment() {
        for (int i = 1; i <= rnd.nextInt(1, 4); i++) {
            flatList.add(new Flat());
        }
    }

    public List<Flat> getFlatList() {
        return flatList;
    }

    @Override
    public String toString() {
        return "\nAppartment " + flatList + "}";
    }

    public void setFlatList(List<Flat> newFlatList) {
    }

    public static class Flat {
        int area;
        public Flat() {
            this.area = rnd.nextInt(10, 41);
        }

        public int getArea() {
            return area;
        }

        @Override
        public String toString() {
            return "Flat{" +
                    "area=" + area +
                    "}";
        }

        public void setArea(int area) {
            this.area = area;
        }
    }
}
