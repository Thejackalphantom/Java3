import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class SolarSystemTest {

    public ArrayList<Star> stars;
    public String starName;
    public double starTemperature;
    public int starMass;
    public double solarRadius;

    @Test
    void createStar()
    {
        stars = new ArrayList<Star>();
        stars.add(new WhiteDwarf(starName , starTemperature, starMass, solarRadius));
    }
}