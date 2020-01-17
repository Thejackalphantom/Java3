public class PulsarStar extends Star
{
    //initialising field variables
    public String starColor;

    public PulsarStar(String starName, double starTemperature, int starMass, double solarRadius, int[] starPosition)
    {
        super(starName, starTemperature, starMass, solarRadius, starPosition);
        starColor = "Blue";
    }

    @Override
    public void CreatePlanet(String planetName, int planetSize, int distanceFromStar, boolean hasAtmosphere)
    {
        planets.add(new Planet(planetName, planetSize, distanceFromStar, hasAtmosphere));
    }
}
