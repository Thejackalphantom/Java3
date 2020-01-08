import java.util.ArrayList;

public abstract class Star
{
    //initialising field variables
    public ArrayList<Planet> planets;
    public String starName;
    public String starTemperature;
    public int starMass;
    public double solarRadius;
    public String starColor;
    public boolean canSuperNova;

    public Star(String starName, String starTemperature, int starMass, double solarRadius)
    {
        planets = new ArrayList<Planet>();
        this.starName = starName;
        this.starTemperature = starTemperature;
        this.starMass = starMass;
        this.solarRadius = solarRadius;
        this.canSuperNova = false;
    }

    public void CreatePlanet(String planetName, int planetSize, int distanceFromStar, boolean hasAtmosphere)
    {

    }
}
