import java.util.ArrayList;

public class Main_GUI
{
    //initialising field variables
    public ArrayList<Galaxy> galaxies;
    public String galaxyName;

    //Creates new ArrayList of Galaxy
    public Main_GUI()
    {
        galaxies = new ArrayList<Galaxy>();
    }

    //Create a new galaxy and add it to the ArrayList
    public void CreateGalaxy(String galaxyName)
    {
        this.galaxyName = galaxyName;
        galaxies.add(new Galaxy(galaxyName));
    }

    //Remove Galaxy from ArrayList
    public void RemoveGalaxy()
    {

    }
}
