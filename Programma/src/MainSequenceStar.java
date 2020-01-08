public class MainSequenceStar extends Star
{
    //initialising field variables
    public String starColor;

    public MainSequenceStar(String starName, String starTemperature, int starMass, double solarRadius)
    {
        super(starName, starTemperature, starMass, solarRadius);
        starColor = "Yellow";
    }
}
