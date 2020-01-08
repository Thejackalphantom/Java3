public class WhiteDwarf extends Star
{
    //initialising field variables
    public String starColor;

    public WhiteDwarf(String starName, String starTemperature, int starMass, double solarRadius)
    {
        super(starName, starTemperature, starMass, solarRadius);
        starColor = "White";
    }
}
