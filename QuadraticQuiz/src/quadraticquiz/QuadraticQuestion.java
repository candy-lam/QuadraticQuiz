package quadraticquiz;

import java.util.Random;
import javax.swing.*;

/**
 * QuadraticQuestion for generating question dialogs and check the answers
 * Introduction to Computing: Java Assignment
 * @author Lam Hiu Ching
 * @since 03 November 2020
 */

public class QuadraticQuestion {
    /**
     * declare the variables
     * as num of roots and roots will not change, set it as final
     * 
     * quest is a String for storing the quadratic equation
     * As A is always 1 accoding to the requirment, the question will always start with x^2
     */
    private final int numOfRoots, root1, root2;
    private final int b, c;
    
    private String quest = "x^2";
    
    //Constructor of QuadraticQuestion while the quadratic equation has 2 real roots.
    public QuadraticQuestion(String title, int r1, int r2){
        // 2 real roots
        numOfRoots = 2;
        // check whether the roots are in range of [-5,5]
        if ((r1 < -5) || (r2 < -5) || (r1 > 5) || (r2 > 5)){
            // if not in the vaild range
            root1 = 1;
            root2 = 2;
        }
        else{
            // if in the vaild range
            root1 = r1;
            root2 = r2;
        }

        // calculating the values of B and C
        b = -r1 + -r2;
        c = -r1 * -r2;   
        
        // if B is non-zero, show it in the quadratic equation
        if (b != 0){
            if (b == 1)
                quest += String.format("+x");
            else if (b == -1)
                quest += String.format("-x");
            else
                quest += String.format("%+dx", b);
        }
        // if B is C, show it in the quadratic equation
        if (c != 0)
            quest += String.format("%+d", c);
        // show quadratic equation and the roots
        System.out.printf(quest + " = 0, 2 real roots: %d, %d\n", root1, root2);
        // combine the question number and the quadratic equation for the ease to display question in getUserInputAnser(String)
        quest = title + quest;
    }
    
    //Constructor of QuadraticQuestion while the question has 1 real root.
    public QuadraticQuestion(String title, int r){
        // 1 real root
        numOfRoots = 1;
        // check whether the roots are in range of [-5,5]
        if ((r < -5) || (r > 5)){
            // if not in the vaild range
            root1 = 1;
            root2 = 1;
        }
        else{
            // if in the vaild range
            root1 = r;
            root2 = r;
        }
        
        // calculating the values of B and C
        b = -r + -r;
        c = -r * -r;
        
        // if B is non-zero, show it in the quadratic equation
        if (b != 0){
            if (b == 1)
                quest += String.format("+x");
            else if (b == -1)
                quest += String.format("-x");
            else
                quest += String.format("%+dx", b);
        }
        // if C is non-zero, show it in the quadratic equation
        if (c != 0)
            quest += String.format("%+d", c);      
        // show quadratic equation and the root
        System.out.printf(quest + " = 0, 1 real root: %d\n", root1);
        // combine the question number and the quadratic equation for the ease to display question in getUserInputAnser(String)
        quest = title + quest;
    }   
    
    //Constructor of QuadraticQuestion while the question has no real root.
    public QuadraticQuestion(String title){
        Random rngObj = new Random();
        // no real root
        numOfRoots = 0;
        root1 = -10;
        root2 = -10;
        //generate B and C randomly with the range of [-10, 10] and (0, 50] repectively
        b = rngObj.nextInt(10 - -10 + 1) + -10;
        c = rngObj.nextInt(50) + 1;        
        
        // if B is non-zero, show it in the quadratic equation
        if (b != 0){
            if (b == 1)
                quest += String.format("+x");
            else if (b == -1)
                quest += String.format("-x");
            else
                quest += String.format("%+dx", b);
        }
        // if C is non-zero, show it in the quadratic equation
        if (c != 0)
            quest += String.format("%+d", c);
        // show quadratic equation and state no real root
        System.out.printf(quest + " = 0, 0 real root.\n");
        // combine the question number and the quadratic equation for the ease to display question in getUserInputAnser(String)
        quest = title + quest;
    }
    
    /**
     * Show the quiz question and ask for the answer
     * will loop until the user input integer input
     * @return a String of user input which could change to integer
     */
    public String getUserInputAnser(){
        String input;
        boolean re;
        do{
            input = JOptionPane.showInputDialog(String.format("%s = 0, how many real roots", quest, b, c)
                                                            , "<type answer [0-2] here>");
            
            try{
                // whether the input could change to integer
                Integer.parseInt(input);
                re = false;
            }
            // if the input could not change to integer, keep asking user to input vaild value
            catch (NumberFormatException e){
                re = true;
            }
            
        }while(re == true);
        return input;
    }
    
    /**
     * Check whether the anwser input by the user is correct
     * @param answer is the user input
     * @return a boolean of correct answer(true) or not(false)
     */
    public boolean checkAnswer(String answer){
        return Integer.parseInt(answer) == numOfRoots;
    }
}
