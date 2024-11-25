package edu.ensign.cs460.solid.ls;

// can all birds fly? can all birds carry coconuts? can all birds swim?
// all birds can lay eggs
public class Bird {
    /**
     * @param name      The name of the bird
     */
    private String name;
    /**
     * @param beakColor The color of the bird's beak
     */
    private String beakColor;

    public Bird(final String name, final String beakColor) {
        this.name = name;
        this.beakColor = beakColor;
    }

    public final String layEgg() {
        return "I laid an egg!";
    }

    public final String getName() {
        throw new UnsupportedOperationException("Not implemented");
    }

    public final String getBeakColor() {
        return beakColor;
    }

    public String fly() {
        return "I am flying!";
    }

    public String carryCoconut() {
        return "I am carrying a coconut!";
    }

    public String swim() {
        return "I am swimming!";
    }

}
