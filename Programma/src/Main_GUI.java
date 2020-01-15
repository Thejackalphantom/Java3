import javafx.scene.control.ComboBox;

import javax.swing.*;
import javax.swing.plaf.metal.MetalComboBoxIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

public class Main_GUI
{
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

    public static void main(String[] args)
    {
        //Initialize the GUI
        JFrame frame = new JFrame("Universe Simulator");
        frame.setContentPane(new Main_GUI().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public Main_GUI()
    {
        //Creates new ArrayList of Galaxy
        galaxies = new ArrayList<Galaxy>();
        //Get the index of the selected item in the galaxy combo box


        galaxyCreationButton.addActionListener(new ActionListener()
        {
            @Override
            //Create galaxy with the name on button click from the form
            public void actionPerformed(ActionEvent actionEvent)
            {
               createGalaxy(galaxyNameField.getText());
               galaxyNameField.setText(null);
            }
        });

        deleteGalaxyButton.addActionListener(new ActionListener() {
            @Override
            //Delete the galaxy selected in the combo menu
            public void actionPerformed(ActionEvent actionEvent) {
                //While galaxyComboIndex is used in other methods, it cannot be used outside of this scope
                // within actionPerformed otherwise the integer is null
                int galaxyComboIndex = galaxyNameList.getSelectedIndex();
                //Remove the selected index in galaxies
                galaxies.remove(galaxyComboIndex);
                populateGalaxyComboBox();
            }
        });
        createSolarSystemButton.addActionListener(new ActionListener() {
            @Override
            //Create a solar system with a name.
            public void actionPerformed(ActionEvent actionEvent) {
                if(!solarSystemNameField.getText().isEmpty())
                {
                    int galaxyComboIndex = galaxyNameList.getSelectedIndex();

                    Galaxy targetGalaxy = galaxies.get(galaxyComboIndex);
                    targetGalaxy.CreateSolarSytem(solarSystemNameField.getText());
                    System.out.println(targetGalaxy.solarSystems.toString());
                    populateSolarSystemComboBox();
                    solarSystemNameField.setText(null);
                }
                //Give an error otherwise
                else
                {
                    JOptionPane.showMessageDialog( new JFrame("popup"), "No name has been entered!", "Missing Name", JOptionPane.ERROR_MESSAGE);
                }

            }
        });
        galaxyNameList.addItemListener(new ItemListener() {
            @Override
            //Repopulate solar system combo box whenver the galaxy changes
            public void itemStateChanged(ItemEvent itemEvent) {
                populateSolarSystemComboBox();
            }
        });
    }

    public void createGalaxy(String galaxyName)
    {
        //Check if there's something in the galaxyNameField
        if(!galaxyName.isEmpty())
        {
            galaxies.add(new Galaxy(galaxyName));
            populateGalaxyComboBox();
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
        for(Galaxy galaxy : galaxies)
        {
            //For each galaxy in the galaxies array list, add the name of the galaxy to the combo box
            galaxyNameList.addItem(galaxy.getGalaxyName());
        }
    }

    public void populateSolarSystemComboBox()
    {
        //This populates the solar system combo box after a removal or addition to the arrayList or whenever a new galaxy is selected
        //The combo list only displays the galaxy's name and is used to select the specific galaxies
        int galaxyComboIndex = galaxyNameList.getSelectedIndex();

        Galaxy targetGalaxy = galaxies.get(galaxyComboIndex);

        solarSystemNameList.removeAllItems();
        for(SolarSystem solarsystem : targetGalaxy.solarSystems)
        {
            //For each solar system in the solarSystem array list, add the name of the galaxy to the combo box
            solarSystemNameList.addItem(solarsystem.getSolarSystemName());
        }
    }
}

