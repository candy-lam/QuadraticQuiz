/**
 * CSCI1130  Assignment 3 Quadratic Quiz
 * 
 * I declare that the assignment here submitted is original
 * except for the source material explicitly acknowledged,
 * and that the same or closely related material has not been
 * previously submitted for another course 
 * I also acknowledge that I am aware of University policy and
 * regulations on honesty in academic work, and of the disciplinary
 * guidelines and procedures applicable to breaches of such
 * policy and regulation, as contained in the website 
 * 
 * University Guideline on Academic Honesty:
 *   http://www.cuhk,edu,hk/policy/academichonesty
 * Faculty of Engineering Guidelines to Academic Honesty:
 *   http://www.erg.cuhk.edu.hk/erg/AcademicHonesty
 * 
 * Student Name: Lam Hiu Ching
 * Student ID  : 1155129247
 * Date        : 2020/11/03
 */

package quadraticquiz;

import java.util.Random;

/**
 * quadraticQuiz
 * Introduction to Computing: Java Assignment
 * @author Lam Hiu Ching
 * @since 03 November 2020
 */

public class QuadraticQuiz {

    /**
     * main() method, starting point of the Java application
     * @param args the command line arguments in a String array
     */
    public static void main(String[] args) {
        PanelDisplay student = new PanelDisplay();
        Random rndObj = new Random();
        // Object array for the 6 questions
        QuadraticQuestion Question[] = new QuadraticQuestion[6];
        String ans, title;
        int numOfRoots, r1, r2;
        
        /**
         * show trial questions to the user and ask for answer
         * after that check the input answser
         */
        QuadraticQuestion Trial1 = new QuadraticQuestion("Trial 1:",-2 ,2);
        ans = Trial1.getUserInputAnser();
        Trial1.checkAnswer(ans);
        
        QuadraticQuestion Trial2 = new QuadraticQuestion("Trial 2:",-1);
        ans = Trial2.getUserInputAnser();
        Trial2.checkAnswer(ans);
        
        QuadraticQuestion Trial3 = new QuadraticQuestion("Trial 3:",5 ,0);
        ans = Trial3.getUserInputAnser();
        Trial3.checkAnswer(ans);
        
        
        //the six questions for the quiz, randomly generated
        for (int i = 0; i < 6; i++){
            //generate the number of roots within [0,2] randomly
            numOfRoots = (int) (Math.random() * 3);
            title = "Q" + (i + 1) + ": ";
            switch (numOfRoots) {
                // when it is 1 real root question
                case 1:
                    // generate the root with [-5,5] randomly
                    r1 = rndObj.nextInt(5 - -5 + 1) + -5;
                    //constract the question class
                    Question[i] = new QuadraticQuestion(title, r1);
                    //show trial questions to the user and ask for answer
                    ans = Question[i].getUserInputAnser();
                    //check the input answser, if correct add one point to the score
                    if (Question[i].checkAnswer(ans)) 
                        student.setScore(student.getScore() + 1);
                    break;
                // when it is 2 real roots question    
                case 2:
                    // generate the roots with [-5,5] randomly
                    do{
                        r1 = rndObj.nextInt(5 - -5 + 1) + -5;
                        r2 = rndObj.nextInt(5 - -5 + 1) + -5;
                    }while(r1 == r2); //aviod same value of roots generated otherwise it would be 1 real root question
                    //constract the question class
                    Question[i] = new QuadraticQuestion(title, r1, r2);
                    //show question to the user and ask for answer
                    ans = Question[i].getUserInputAnser();
                    //check the input answser, if correct add one point to the score
                    if (Question[i].checkAnswer(ans)) 
                        student.setScore(student.getScore() + 1);
                    break;                    
                // when it is no real root question
                default:
                    //constract the question class
                    Question[i] = new QuadraticQuestion(title);
                    //show question to the user and ask for answer
                    ans = Question[i].getUserInputAnser();
                    //check the input answser, if correct add one point to the score
                    if (Question[i].checkAnswer(ans)) 
                        student.setScore(student.getScore() + 1);
                    break;                    
            }
        }
        
        System.out.println("The End");
    }
    
}
