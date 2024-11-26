package edu.ensign.cs460.solid.ls;

import java.util.ArrayList;
import java.util.List;

public final class LiskovSubstitutionExample {
    private LiskovSubstitutionExample() {
    }
    public static void main(final String[] args) {
        List<Bird> birds = new ArrayList<Bird>() {{
            add(new AfricanSwallow("African Swallow", "Yellow"));
            add(new Penguin("Penguin", "Black"));
        }};

        BirdHabitat birdHabitat = new BirdHabitat(birds);

        System.out.println(birdHabitat.birdReport());
        System.out.println(birdHabitat.haveBirdsLayEggs());
        System.out.println(((AfricanSwallow) birds.get(0)).fly());
        System.out.println(((Penguin) birds.get(1)).swim());
        System.out.println(((AfricanSwallow) birds.get(0)).carryCoconut());
    }
}
