package org.example.house.houseClasses;

import java.util.ArrayList;
import java.util.List;

public class House implements Cloneable {
    List<Appartment> appartmentList = new ArrayList<>();

    public House() {
        for (int i = 1; i < 5; i++) {
            appartmentList.add(new Appartment());
        }
    }

    public List<Appartment> getAppartmentList() {
        return appartmentList;
    }

    @Override
    public String toString() {
        return "House\n" + appartmentList;
    }

    @Override
    public House clone() {
        try {
            House clone = (House) super.clone();
            // TODO: copy mutable state here, so the clone can't change the internals of the original
            return clone;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}