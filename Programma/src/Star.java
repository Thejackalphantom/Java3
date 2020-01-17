import java.util.ArrayList;

abstract class Star
{
    //A list of planets
    ArrayList<Planet> planets;
    //Name of star
    String starName;
    //Temperature of the star in Kelvin
    double starTemperature;
    //Position of the star
    int[] starPosition;
    //Mass of a star in tonnes
    int starMass;
    //Radius of a star in starradius
    double solarRadius;
    //Colour of a star
    String starColor;
    //Boolean that determines whether or not a star can go supernova
    boolean canSuperNova;

    public Star(String starName, double starTemperature, int starMass, double solarRadius, int[] starPosition)
    {
        planets = new ArrayList<Planet>();
        this.starName = starName;
        this.starTemperature = starTemperature;
        this.starMass = starMass;
        this.starPosition = starPosition;
        this.solarRadius = solarRadius;
        this.canSuperNova = false;
    }

    //<editor-fold desc="Getters & Setters">
    public ArrayList<Planet> getPlanets() {
        return planets;
    }

    public void setPlanets(ArrayList<Planet> planets) {
        this.planets = planets;
    }

    public String getStarName() {
        return starName;
    }

    public void setStarName(String starName) {
        this.starName = starName;
    }


    public int getStarMass() {
        return starMass;
    }

    public void setStarMass(int starMass) {
        this.starMass = starMass;
    }

    public double getSolarRadius() {
        return solarRadius;
    }

    public void setSolarRadius(double solarRadius) {
        this.solarRadius = solarRadius;
    }

    public String getStarColor() {
        return starColor;
    }

    public void setStarColor(String starColor) {
        this.starColor = starColor;
    }

    public boolean isCanSuperNova() {
        return canSuperNova;
    }

    public int[] getStarPosition() {
        return starPosition;
    }

    //</editor-fold>

    public void setCanSuperNova(boolean canSuperNova) {
        this.canSuperNova = canSuperNova;
    }

    public abstract void CreatePlanet(String planetName, int planetSize, int distanceFromStar, boolean hasAtmosphere);

    @Override
    public String toString()
    {
        return this.starName;
    }
}
