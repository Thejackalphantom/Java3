
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Main_GUI {
    //initialize field variables
    public ArrayList<Galaxy> galaxies;
    //Intialize GUI Elements
    private JButton galaxyCreationButton;
    private JPanel panel1;
    private JTextField galaxyNameField;
    private JPanel createGalaxyPanel;
    private JPanel galaxySelectionPanel;
    private JComboBox galaxyNameList;
    private JPanel galaxyOptionPanel;
    private JButton deleteGalaxyButton;
    private JButton createSolarSystemButton;
    private JTextField solarSystemNameField;
    private JPanel solarSystemSelectionPanel;
    private JComboBox solarSystemNameList;
    private JPanel solarSystemOptionPanel;
    private JButton deleteSolarSystemButton;
    private JPanel starOptionPanel;
    private JTextField starNameField;
    private JButton createStarButton;
    private JTextField starTempField;
    private JTextField starMassField;
    private JTextField starRadiusField;
    private JLabel starNameLabel;
    private JLabel starMassLabel;
    private JLabel starRadiusLabel;
    private JLabel starTempLabel;
    private JPanel starSelectionPanel;
    private JComboBox starList;

    public static void main(String[] args) {
        //Initialize the GUI
        JFrame frame = new JFrame("Universe Simulator");
        frame.setContentPane(new Main_GUI().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public Main_GUI() {
        //Creates new ArrayList of Galaxy
        galaxies = new ArrayList<Galaxy>();
        //Get the index of the selected item in the galaxy combo box

        //<editor-fold desc="Galaxy-related Elements">
        galaxyCreationButton.addActionListener(new ActionListener() {
            @Override
            //Create galaxy with the name on button click from the form
            public void actionPerformed(ActionEvent actionEvent) {
                createGalaxy(galaxyNameField.getText());
                galaxyNameField.setText(null);
                populateGalaxyComboBox();
            }
        });

        deleteGalaxyButton.addActionListener(new ActionListener() {
            @Override
            //Delete the galaxy selected in the combo menu
            public void actionPerformed(ActionEvent actionEvent) {
                //While galaxyComboIndex is used in other methods, it cannot be used outside of this scope
                // within actionPerformed otherwise the integer is null
                if (!galaxies.isEmpty()) {
                    int galaxyComboIndex = galaxyNameList.getSelectedIndex();
                    //Remove the selected index in galaxies
                    galaxies.remove(galaxyComboIndex);
                    populateGalaxyComboBox();
                    populateSolarSystemComboBox();
                }
            }
        });
        galaxyNameList.addActionListener(new ActionListener() {
            @Override
            //This refreshes the solar system combo box whenever someone interacts with the combo box.
            //We did not use onItemChange because in most cases this causes the commands to be executed twice.
            public void actionPerformed(ActionEvent actionEvent) {
                populateSolarSystemComboBox();
            }
        });
        //</editor-fold>

        //<editor-fold desc="Solar-System Elements">
        createSolarSystemButton.addActionListener(new ActionListener() {
            @Override
            //Create a solar system with a name.
            public void actionPerformed(ActionEvent actionEvent) {
                if (!solarSystemNameField.getText().isEmpty()) {
                    int galaxyComboIndex = galaxyNameList.getSelectedIndex();

                    Galaxy targetGalaxy = galaxies.get(galaxyComboIndex);
                    targetGalaxy.CreateSolarSystem(solarSystemNameField.getText());
                    populateSolarSystemComboBox();
                    solarSystemNameField.setText(null);
                }
                //Give an error otherwise
                else {
                    JOptionPane.showMessageDialog(new JFrame("popup"), "No name has been entered!", "Missing Name", JOptionPane.ERROR_MESSAGE);
                }

            }
        });

        deleteSolarSystemButton.addActionListener(new ActionListener()
        {
            @Override
            //Remove the solar system in the solar system array
            public void actionPerformed(ActionEvent actionEvent)
            {
                Galaxy targetGalaxy = getTargetGalaxy();
                if (!targetGalaxy.solarSystems.isEmpty())
                {
                    int solSysComboIndex = solarSystemNameList.getSelectedIndex();
                    //Remove the selected index in solar system
                    targetGalaxy.solarSystems.remove(solSysComboIndex);
                    populateGalaxyComboBox();
                    populateSolarSystemComboBox();
                }
            }

        });
        createStarButton.addActionListener(new ActionListener() {
            @Override
            //Create a star if all names, temp and such are valid
            public void actionPerformed(ActionEvent e) {
                //Check if none of the fields are empty.
                if (!starNameField.getText().isEmpty() || !starMassField.getText().isEmpty()
                        || !starRadiusField.getText().isEmpty() || !starTempField.getText().isEmpty())
                {
                    String starName = starNameField.getText();
                    //check if starmass or starRadius are truly only numeric
                    if (starMassField.getText().matches("^[0-9]*$")
                            || starRadiusField.getText().matches("^[0-9]*$")
                            || starTempField.getText().matches("^[0-9]*$"))
                    {
                        int starMass = Integer.parseInt(starMassField.getText());
                        float starTemp = Float.parseFloat(starTempField.getText());
                        float starRadius = Float.parseFloat(starRadiusField.getText());
                        SolarSystem targetSolarSystem = getTargetSolarSystem();
                        targetSolarSystem.createStar(starName, starTemp, starMass, starRadius);
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(new JFrame("popup"), "Star Mass,  Star Radius & Star Temp only accept numbers!", "Only Numbers", JOptionPane.ERROR_MESSAGE);
                    }
                }
                else
                {
                    JOptionPane.showMessageDialog(new JFrame("popup"), "Some of Star's fields are empty!", "Empty Fields", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

    public Galaxy getTargetGalaxy()
    {
        //Get the target galaxy for usage in other methods
        if (!galaxies.isEmpty())
        {
            int galaxyComboIndex = galaxyNameList.getSelectedIndex();
            Galaxy targetGalaxy;
            try
            {
                targetGalaxy = galaxies.get(galaxyComboIndex);
            }
            catch (IndexOutOfBoundsException ee)
            {
                targetGalaxy = galaxies.get(0);
            }
            return targetGalaxy;
        }else {
            return null;
        }
    }

    public SolarSystem getTargetSolarSystem()
    //Get the target solar system for usage in other methods
    {
        Galaxy targetGalaxy = getTargetGalaxy();
        if(!targetGalaxy.solarSystems.isEmpty())

        {
            int solSysComboIndex = solarSystemNameList.getSelectedIndex();
            SolarSystem targetSolarSystem;
            try {
                targetSolarSystem = targetGalaxy.solarSystems.get(solSysComboIndex);
            } catch (IndexOutOfBoundsException ee) {
                targetSolarSystem = targetGalaxy.solarSystems.get(0);
            }
            return targetSolarSystem;
        }
        else
        {
            return null;
        }

    }
    //</editor-fold>

    //<editor-fold desc="Galaxy-related Methods">
    public void createGalaxy(String galaxyName)
    {
        //Check if there's something in the galaxyNameField
        if(!galaxyName.isEmpty())
        {
            galaxies.add(new Galaxy(galaxyName));
        }
        //Give an error otherwise
        else
        {
            JOptionPane.showMessageDialog( new JFrame("popup"), "No name has been entered!", "Missing Name", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void populateGalaxyComboBox()
    {
        //This populates the galaxy combo box after a removal or addition to the arrayList
        //The combo list only displays the galaxy's name and is used to select the specific galaxies
        galaxyNameList.removeAllItems();
        if(!galaxies.isEmpty()) {
            for (Galaxy galaxy : galaxies) {
                //For each galaxy in the galaxies array list, add the name of the galaxy to the combo box
                galaxyNameList.addItem(galaxy);
            }
        }
    }

    //</editor-fold>

    //<editor-fold desc="Solar System-related Methods">
    public void populateSolarSystemComboBox()
    {
        //This populates the solar system combo box after a removal or addition to the arrayList or whenever a new galaxy is selected
        //The combo list only displays the galaxy's name and is used to select the specific galaxies
        solarSystemNameList.removeAllItems();
        Galaxy targetGalaxy = getTargetGalaxy();
            for (SolarSystem solarsystem : targetGalaxy.solarSystems) {
                //For each solar system in the solarSystem array list, add the name of the galaxy to the combo box
                solarSystemNameList.addItem(solarsystem);
            }

    }

    //</editor-fold>

    public void populateStarComboBos()
    {
        //This populates the star combo box after a removal or addition to the arrayList or whenever a new solar system is selected
        //The combo list only displays the star's name and type and is used to select the specific stars
        starList.removeAllItems();
        SolarSystem targetSolarSystem = getTargetSolarSystem();
        for(Star star : targetSolarSystem.stars)
        {
            starList.addItem(star);
        }
    }

}

