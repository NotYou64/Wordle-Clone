// Cole Delong
// testing out Swing
// 3-4-22


import javax.swing.border.Border;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;


public class WordleFrame extends JFrame
{

    // instance variables
    WordleEventHandler event_handler = new WordleEventHandler(this);

    GridLayout layout = new GridLayout(2, 1);

    GridLayout layout1 = new GridLayout(6, 5);
    Border border1 = BorderFactory.createEmptyBorder(20, 20, 10, -50);
    JPanel row1 = new JPanel();
    JLabel[][] grid = new JLabel[5][6];

    FlowLayout layout2 = new FlowLayout(FlowLayout.CENTER, 10, 10);
    JPanel row2 = new JPanel();
    JTextField input_field = new JTextField(6);
    JButton submit_button = new JButton("Guess");


    // frame constructor
    public WordleFrame()
    {

        // initialize window
        super();
        setTitle("Wordle");
        setLookAndFeel();
        setSize(500, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // set up window layout
        setLayout(layout);


        // create row1, the grid for the past guesses to be shown
        row1.setLayout(layout1);
        row1.setBorder(border1);
        row1.setBackground(Color.white);

        for (int i = 0; i < grid.length; i++)
        {
            for (int j = 0; j < grid[0].length; j++)
            {
                grid[i][j] = new JLabel(Integer.toString(i*6 + j));
                row1.add(grid[i][j]);
            }

        }
        

        // create the area for the guesses to be made
        row2.setLayout(layout2);
        row2.setBackground(Color.white);

        input_field.addKeyListener(event_handler);
        row2.add(input_field);
        submit_button.addActionListener(event_handler);
        row2.add(submit_button);        

        // add the panels to the window
        add(row1);
        add(row2);

        // make the window visible
        setVisible(true);


    }


    // a method that sets the look and feel of the window with error handling
    private void setLookAndFeel()
    {
        try 
        {
            UIManager.setLookAndFeel(
                UIManager.getSystemLookAndFeelClassName()
            );
        }
        catch (Exception exc)
        {
            // ignore error
        }
    }


    public static void main(String[] args)
    {

        new WordleFrame();

    }
    
}