// Cole Delong
// event handler for Wordle clone
// 3-5-22

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class WordleEventHandler implements ActionListener, KeyListener
{

    WordleFrame in;

    public WordleEventHandler(WordleFrame in)
    {

        this.in = in;

    }

    // action handler for the submit button
    @Override
    public void actionPerformed(ActionEvent event)
    {

        // use getSource() to find out which object the action was from
        System.out.println("Button pressed");

    }


    // action handlers for keyboard events to see when the user presses enter
    @Override
    public void keyPressed(KeyEvent event)
    {

        // use the getKeyChar() method to find out which key is pressed if it's a character
        // if it's a space, enter, or something else like that, use getKeyCode()
        // you can use getKeyText() to get "F1", "Home", or something like that as text

    }
    @Override
    public void keyReleased(KeyEvent event)
    {



    }
    @Override
    public void keyTyped(KeyEvent event)
    {



    }


}