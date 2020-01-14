import java.util.ArrayList;

abstract class Star
{
    //A list of planets
    public ArrayList<Planet> planets;
    //Name of star
    public String starName;
    //Temperature of the star in Kelvin
    public String starTemperature;
    //Mass of a star in tonnes
    public int starMass;
    //Radius of a star in starradius
    public double solarRadius;
    //Colour of a star
    public String starColor;
    //Boolean that determines whether or not a star can go supernova
    public boolean canSuperNova;

    public Star(String starName, String starTemperature, int starMass, double solarRadius)
    {
        planets = new ArrayList<Planet>();
        this.starName = starName;
        this.starTemperature = starTemperature;
        this.starMass = starMass;
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

    public String getStarTemperature() {
        return starTemperature;
    }

    public void setStarTemperature(String starTemperature) {
        this.starTemperature = starTemperature;
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

    public void setCanSuperNova(boolean canSuperNova) {
        this.canSuperNova = canSuperNova;
    }
    //</editor-fold>

    public void CreatePlanet(String planetName, int planetSize, int distanceFromStar, boolean hasAtmosphere)
    {
        planets.add(new Planet(planetName, planetSize, distanceFromStar, hasAtmosphere));
    }


}
