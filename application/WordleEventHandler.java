// Cole Delong
// event handler for Wordle clone
// 3-5-22

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class WordleEventHandler implements ActionListener, KeyListener
{

    // window object
    WordleFrame in;

    // game variables
    ArrayList<String> objective_list = new ArrayList<>();
    ArrayList<String> valid_words = new ArrayList<>();
    Scanner file_scanner;
    File obj_file;
    int nguess = 0;
    boolean game_state = true;
    String wordle;

    public WordleEventHandler(WordleFrame in)
    {

        // take wordle object in to modify its components
        this.in = in;

        System.out.println(new File(".").getAbsolutePath());

        // put each word from the objective_list in the src folder into an array
        try
        {
            obj_file = new File("C:\\Users\\cole4\\Desktop\\Java\\Wordle\\wordle_copy\\application\\objective_list.txt");
            file_scanner = new Scanner(obj_file);
            while (file_scanner.hasNextLine())
            {
                objective_list.add(file_scanner.nextLine());
            }
        }
        catch (FileNotFoundException e)
        {

        }
        
        // put each word from the valid_words in the src folder into an array
        try
        {
            obj_file = new File("C:\\Users\\cole4\\Desktop\\Java\\Wordle\\wordle_copy\\application\\valid_words.txt");
            file_scanner = new Scanner(obj_file);
            while (file_scanner.hasNextLine())
            {
                valid_words.add(file_scanner.nextLine());
            }
        }
        catch (FileNotFoundException e)
        {

        }
        finally
        {
            file_scanner.close();
        }


        // determine the game objective
        wordle = objective_list.get((int)(Math.random() * objective_list.size()));
        System.out.println(wordle);

    }

    // method to handle submitted guesses from the user
    public void makeGuess(String guess)
    {
        
        // make the guess upper case and then check if it's valid
        guess = guess.toUpperCase();
        if (isValidGuess(guess))
        {

            in.input_field.setText("");
            insertWord(guess);

            // increment the number of guesses. if 5 guesses, end game
            nguess++;
            if (nguess > 5)
            {
                game_state = false;
            }

            // TODO: finish guess method

        }
        // if the guess isn't valid, tell the user 
        else
        {
            // TODO: let the user know that they're a dumbass when they try something invalid
        }

    }

    // method that returns true if the guess is valid and false if it isn't
    public boolean isValidGuess(String guess)
    {

        // check if the length of the guess is 5 characters
        if (guess.length() != 5)
        {
            return false;
        }

        // check if the guess only has english letters in it (no special chars)
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        for (int i = 0; i < 5; i++)
        {
            if (alphabet.indexOf(guess.charAt(i)) == -1)
            {
                return false;
            }
        }

        // use a binary search to check if the guess is in the dictionary of 5 letter words
        if (!binarySearch(valid_words, guess))
        {
            return false;
        }

        // if all above conditions are true, the guess is valid
        return true;

    }

    // binary search algorithm. returns true if element is in arraylist and -1 if not
    boolean binarySearch(ArrayList<String> arr, String x)
    {
        int l = 0, r = arr.size() - 1;
        while (l <= r) 
        {
            int m = l + (r - l) / 2;
            int res = x.compareTo(arr.get(m));

            // check if x is present at mid
            if (res == 0)
            {
                return true;
            }
            // if x greater, ignore left half
            if (res > 0)
            {
                l = m + 1;
            }
            // if x is smaller, ignore right half
            else
            {
                r = m - 1;
            }
        }
        return false;
    }

    // method to put a user guess into the guess grid
    public void insertWord(String word)
    {
        for (int i = 0; i < 5; i++)
        {
            in.grid[nguess][i].setText(word.substring(i, i+1));
        }
    }

    // action handler for the submit button
    @Override
    public void actionPerformed(ActionEvent event)
    {
        // use getSource() to find out which object the action was from
        if (game_state)
        {
            makeGuess(in.input_field.getText());
        }
    }
    // action handlers for keyboard events to see when the user presses enter
    @Override
    public void keyPressed(KeyEvent event)
    {
        if (event.getKeyCode() == 10 && game_state)
        {
            makeGuess(in.input_field.getText());
        }
    }
    @Override
    public void keyReleased(KeyEvent event) {}
    @Override
    public void keyTyped(KeyEvent event) {}


}