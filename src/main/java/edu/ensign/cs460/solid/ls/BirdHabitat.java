package edu.ensign.cs460.solid.ls;

import java.util.List;

public final class BirdHabitat {
    /**
     * @param birds The list of birds in the habitat
     */
    private List<Bird> birds;

    public BirdHabitat(final List<Bird> birds) {
        this.birds = birds;
    }

    public void addBird(final Bird bird) {
        birds.add(bird);
    }

    public String birdReport() {
        StringBuilder report = new StringBuilder();
        for (Bird bird : birds) {
            report.append(bird.getName()).append(" is a bird with a ").append(bird.getBeakColor()).append(" beak.\n");
        }
        return report.toString();
    }

    public String haveBirdsLayEggs() {
        StringBuilder report = new StringBuilder();
        for (Bird bird : birds) {
            report.append(bird.getName()).append(" happily chirps - ").append(bird.layEgg()).append("\n");
        }
        return report.toString();
    }

    public String birdActivitiesReport() {
        StringBuilder report = new StringBuilder();
        for (Bird bird : birds) {
            report.append(bird.getName()).append(": ");

            // use instanceof to check if the bird can fly/swim/carry coconuts
            // before calling these methods after refactor
            report.append(bird.fly()).append(" ");
            report.append(bird.carryCoconut()).append(" ");
            report.append(bird.swim()).append(" ");

            report.append("\r\n");
        }
        return report.toString();
    }
}
