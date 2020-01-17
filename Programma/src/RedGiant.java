public class RedGiant extends Star
{
    //initialising field variables
    public String starColor;

    public RedGiant(String starName, double starTemperature, int starMass, double solarRadius, int[] starPosition)
    {
        super(starName, starTemperature, starMass, solarRadius, starPosition);
        starColor = "red";
    }

    @Override
    public void CreatePlanet(String planetName, int planetSize, int distanceFromStar, boolean hasAtmosphere)
    {
        planets.add(new Planet(planetName, planetSize, distanceFromStar, hasAtmosphere));
    }
}
