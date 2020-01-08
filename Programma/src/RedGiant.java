public class RedGiant extends Star
{
    //initialising field variables
    public String starColor;

    public RedGiant(String starName, String starTemperature, int starMass, double solarRadius)
    {
        super(starName, starTemperature, starMass, solarRadius);
        starColor = "red";
    }

}
