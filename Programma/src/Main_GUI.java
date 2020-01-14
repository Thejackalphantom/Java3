import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
    private JComboBox galaxyList;
    private JPanel galaxyOptionPanel;
    private JButton deleteGalaxyButton;

    public static void main(String[] args)
    {
        //Initialize the GUI
        JFrame frame = new JFrame("Main_GUI");
        frame.setContentPane(new Main_GUI().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public Main_GUI()
    {
        //Creates new ArrayList of Galaxy

        galaxies = new ArrayList<Galaxy>();
        galaxyCreationButton.addActionListener(new ActionListener()
        {
            @Override
            //Create galaxy with the name on button click from the form
            public void actionPerformed(ActionEvent actionEvent)
            {
                //Check if there's something in the galaxyNameField
                if(!galaxyNameField.getText().isEmpty())
                {
                    galaxies.add(new Galaxy(galaxyNameField.getText()));
                    galaxyNameField.setText(null);
                    populateGalaxyComboBox();
                }
                //Give an error otherwise
                else
                {
                    JOptionPane.showMessageDialog( new JFrame("popup"), "No name has been entered!", "Missing Name", JOptionPane.ERROR_MESSAGE);
                }

            }
        });
        deleteGalaxyButton.addActionListener(new ActionListener() {
            @Override
            //Delete the galaxy selected in the combo menu
            public void actionPerformed(ActionEvent actionEvent) {
                //Get the selected index of the combo list as it is 1:1 to the arraylist
                int comboIndex = galaxyList.getSelectedIndex();
                //Remove the selected index in galaxies
                galaxies.remove(comboIndex);
                populateGalaxyComboBox();
            }
        });
    }

    public void populateGalaxyComboBox()
    {
        //This populates the galaxy combo list after a removal or addition to the arrayList
        galaxyList.removeAllItems();
        for(Galaxy galaxy : galaxies)
        {
            galaxyList.addItem(galaxy.getGalaxyName());
        }
    }
}

