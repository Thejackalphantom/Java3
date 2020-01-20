import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

class SolarSystemTest
{
    ArrayList<Star> stars;

    @Test
    void starTestPulsarStar()
    {
        //Tests for pulsar star
        stars = new ArrayList<>();

        SolarSystem sun = new SolarSystem("test1");
        sun.createStar("test1", 100, 200, 8, new int[2]);
        //Compares the output to what it should give.
        assertEquals("Pulsar Star test1", sun.stars.get(0).getStarName());
    }
    @Test
    void starTestMainSequenceStar()
    {
        //Tests for Main Sequence Star
        stars = new ArrayList<>();

        SolarSystem sun = new SolarSystem("test2");
        sun.createStar("test2", 14340, 4540, 500, new int[2]);
        //Compares the output to what it should give.
        assertEquals("Main Sequence Star test2", sun.stars.get(0).getStarName());
    }

    @Test
    void starTestWhiteDwarf()
    {
        //Tests for White Dwarf
        stars = new ArrayList<>();

        SolarSystem sun = new SolarSystem("test3");
        sun.createStar("test3", 3400, 20000, 0.1, new int[1]);
        //Compares the output to what it should give.
        assertEquals("White Dwarf test3", sun.stars.get(0).getStarName());
    }

    @Test
    void starTestRedGiant()
    {
        //Tests for Red Giant
        stars = new ArrayList<>();

        SolarSystem sun = new SolarSystem("test4");
        sun.createStar("test4", 1304, 2006, 1001, new int[5]);
        //Compares the output to what it should give.
        assertEquals("Red Giant test4", sun.stars.get(0).getStarName());
    }
}