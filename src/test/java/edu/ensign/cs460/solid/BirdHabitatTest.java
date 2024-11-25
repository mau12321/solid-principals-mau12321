package edu.ensign.cs460.solid;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import edu.ensign.cs460.solid.ls.AfricanSwallow;
import edu.ensign.cs460.solid.ls.Bird;
import edu.ensign.cs460.solid.ls.BirdHabitat;
import edu.ensign.cs460.solid.ls.Penguin;

public class BirdHabitatTest {
    private BirdHabitat birdHabitat;
    private List<Bird> birds;

    @BeforeEach
    public void setUp() {
        this.setupBirds();
        this.birdHabitat = new BirdHabitat(birds);
    }
    

    @Test
    public void birdReport_happyPath_shouldReturnBirdInfo() {
        // act
        String actBirdReport = birdHabitat.birdReport();
        // assert
        assert actBirdReport.toLowerCase().contains("black and white");
        assert actBirdReport.toLowerCase().contains("yellow");
        assert actBirdReport.toLowerCase().contains("penguin");
        assert actBirdReport.toLowerCase().contains("african swallow");
    }

    @Test
    public void haveBirdsLayEggs_happyPath_shouldReturnEggLayingInfo() {
        // act
        String actEggLayingReport = birdHabitat.haveBirdsLayEggs();
        // assert
        assert actEggLayingReport.toLowerCase().contains("penguin");
        assert actEggLayingReport.toLowerCase().contains("african swallow");
        assert actEggLayingReport.toLowerCase().contains("egg");
    }

    @Test
    public void birdActivitiesReport_happyPath_shouldReturnBirdActivities() {
        // act
        String actBirdActivitiesReport = birdHabitat.birdActivitiesReport();
        // assert
        assert actBirdActivitiesReport.toLowerCase().contains("penguin");
        assert actBirdActivitiesReport.toLowerCase().contains("swim");
        assert actBirdActivitiesReport.toLowerCase().contains("african swallow");
        assert actBirdActivitiesReport.toLowerCase().contains("fly");
        assert actBirdActivitiesReport.toLowerCase().contains("carrying a coconut");
    }

    private void setupBirds() {
        this.birds = List.of(
            new Penguin("Penguin", "Black and White"),
            new AfricanSwallow("African Swallow", "Yellow")
        );
    }
}
