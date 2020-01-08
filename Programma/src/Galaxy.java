import java.util.ArrayList;

public class Galaxy
{
    //initialising field variables
    public ArrayList<SolarSystem> solarSystems;
    public String galaxyName;
    public String solarSystemName;

    //Constructor for Galaxy. Creates new SolarSystem ArrayList
    public Galaxy(String galaxyName)
    {
        solarSystems = new ArrayList<SolarSystem>();
        this.galaxyName = galaxyName;
    }

    //Adds new solarSystem to the ArrayList
    public void CreateSolarSytem(String solarSystemName)
    {
        this.solarSystemName = solarSystemName;
    }
}
