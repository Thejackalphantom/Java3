import java.util.ArrayList;

public class SolarSystem
{
    //initialising field variables
    public ArrayList<Star> stars;
    public String solarSystemName;

    //Constructor for solarSystem and creates a ArrayList for Star
    public SolarSystem(String solarSystemName)
    {
        stars = new ArrayList<Star>();
        this.solarSystemName = solarSystemName;
    }

    //Create a new Star and checks for the solarRadius to depict what class the star belongs to
    public void createStar(String starName, double starTemperature, int starMass, double solarRadius)
    {
        if(solarRadius <= 0.1)
        {
            stars.add(new WhiteDwarf("White Dwarf " + starName , starTemperature, starMass, solarRadius));
        }
        else if(solarRadius > 0.1 && solarRadius <= 10)
        {
            stars.add(new PulsarStar("Pulsar Star " + starName, starTemperature, starMass, solarRadius));
        }
        else if(solarRadius > 10 && solarRadius < 1000)
        {
            stars.add(new MainSequenceStar("Main Sequence Star " + starName, starTemperature, starMass, solarRadius));
        }
        else
        {
            stars.add(new RedGiant("Red Giant " + starName, starTemperature, starMass, solarRadius));
        }
    }

    @Override
    public String toString()
    {
        return this.solarSystemName;
    }
}
