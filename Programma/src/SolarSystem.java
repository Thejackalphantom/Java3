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
    public void CreateStar(String starName, String starTemperature, int starMass, double solarRadius)
    {
        if(solarRadius <= 0.1)
        {
            new WhiteDwarf(starName, starTemperature, starMass, solarRadius);
        }
        else if(solarRadius > 0.1 && solarRadius <= 10)
        {
            new PulsarStar(starName, starTemperature, starMass, solarRadius);
        }
        else if(solarRadius > 10 && solarRadius < 1000)
        {
            new MainSequenceStar(starName, starTemperature, starMass, solarRadius);
        }
        else
        {
            new RedGiant(starName, starTemperature, starMass, solarRadius);
        }
    }

    //checks if a star can supernova
    public boolean CanSuperNova(ArrayList<Star> stars)
    {
        return true;
    }
}
