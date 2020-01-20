import javax.swing.*;
import java.util.ArrayList;

public class SolarSystem
{
    //initialising field variables
    ArrayList<Star> stars;
    String solarSystemName;

    final double WhiteDwarfSize = 0.1;
    final double PulsarStarSize = 10;
    final double MainSequenceStarSize = 1000;

    //Constructor for solarSystem and creates a ArrayList for Star
    SolarSystem(String solarSystemName)
    {
        stars = new ArrayList<Star>();
        this.solarSystemName = solarSystemName;
    }

    //Create a new Star and checks for the solarRadius to depict what class the star belongs to
    public void createStar(String starName, double starTemperature, int starMass, double solarRadius, int[] starPosition)
    {
        if(solarRadius <= WhiteDwarfSize)
        {
            stars.add(new WhiteDwarf("White Dwarf " + starName , starTemperature, starMass, solarRadius, starPosition));
        }
        else if(solarRadius > WhiteDwarfSize && solarRadius <= PulsarStarSize)
        {
            stars.add(new PulsarStar("Pulsar Star " + starName, starTemperature, starMass, solarRadius, starPosition));
        }
        else if(solarRadius > PulsarStarSize && solarRadius < MainSequenceStarSize)
        {
            stars.add(new MainSequenceStar("Main Sequence Star " + starName, starTemperature, starMass, solarRadius, starPosition));
        }
        else if (solarRadius > MainSequenceStarSize)
        {
            stars.add(new RedGiant("Red Giant " + starName, starTemperature, starMass, solarRadius, starPosition));
        }
        else
        {
            JOptionPane.showMessageDialog(new JFrame("popup"), "Something Went Wrong Please try again!", "Oopsie", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public String toString()
    {
        return this.solarSystemName;
    }
}
