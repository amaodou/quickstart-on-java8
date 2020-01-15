package xyz.mdou.quickstart.collectiontopics;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Pet {
    private String name;

    public Pet(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return super.toString() + " " + name;
    }
}

public class FillingLists {
    public static void main(String[] args) {
        List<Pet> pets = new ArrayList<>(Collections.nCopies(4, new Pet("Tom")));
        System.out.println(pets);

        Collections.fill(pets, new Pet("Jekyll"));
        System.out.println(pets);
    }
}
