public class PulsarStar extends Star
{
    //initialising field variables
    public String starColor;

    public PulsarStar(String starName, double starTemperature, int starMass, double solarRadius)
    {
        super(starName, starTemperature, starMass, solarRadius);
        starColor = "Blue";
    }
}
