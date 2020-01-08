public class PulsarStar extends Star
{
    //initialising field variables
    public String starColor;

    public PulsarStar(String starName, String starTemperature, int starMass, double solarRadius)
    {
        super(starName, starTemperature, starMass, solarRadius);
        starColor = "Blue";
    }
}
