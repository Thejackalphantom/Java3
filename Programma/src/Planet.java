import java.util.ArrayList;

public class Planet
{
    String planetName;
    int planetSize;
    int distanceFromStar;
    boolean hasAtmosphere;
    public ArrayList<Moon> moons;
    public Planet(String planetName, int planetSize, int distanceFromStar, boolean hasAtmosphere)
    {
        this.planetName = planetName;
        this.planetSize = planetSize;
        this.distanceFromStar = distanceFromStar;
        this.hasAtmosphere = hasAtmosphere;
        moons = new ArrayList<Moon>();
    }

    public void newMoon(String moonName, int moonSize, int distanceFromPlanet, boolean hasAtmosphere)
    {
        //Check the size of the moon so that it is not bigger than the planet
        if(moonSize < this.planetSize)
        {
            moons.add(new Moon(moonName, moonSize, distanceFromPlanet, hasAtmosphere));
        }
    }

}
