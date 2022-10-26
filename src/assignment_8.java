/**
 * Chappidi Amarnath – 999902398- section 31
 * @author Chappidi Amarnath
 */
import java.util.Scanner;

public class assignment_8
{

    public static void main(String []arg)
    {
        //Create an instance of the Scanner class.
        Scanner sc = new Scanner(System.in);
        //Prompt the user to input the number of inputs.
        System.out.print("Enter the number of inputs ");
        int num_of_values = sc.nextInt();
        System.out.println("");
        NumberConvertion r = new NumberConvertion();
        //Start the while loop till the number of test cases.
        while(num_of_values != 0)
        {
            r.convertedValue=0;
            //Prompt the user to enter the roman numeral.
            System.out.print("Enter the roman ");
            System.out.print("numeral: ");
            String roman = sc.next();
            System.out.println("");
            //Check if each character of the entered string is a valid roman numeral or not.
            if(r.checkRoman(roman) == false)
            {
                System.out.print("Invalid character ");
                System.out.print("in input. Valid ");
                System.out.print("characters are ");
                System.out.println("I,V,X,L,C,D,M.");
            }
            //Check if there are two consecutive subtractions in a roman numeral.
            else if(r.checkTwoSubtraction(roman) != false)
            {
                System.out.print("Invalid numeral: ");
                System.out.print("two consecutive ");
                System.out.println("subtractions.");
            }
            //Check if there is a subtraction from
            //auxilary numeral.
            else if(r.checkAuxilarySubtraction(roman)	== false)
            {
                System.out.print("Invalid numeral: ");
                System.out.print("can't subtract ");
                System.out.print("auxiliary ");
                System.out.println("symbol.");
            }
            //Check if there are decreasing additions or not.
            else if(r.checkAddition(roman))
            {
                System.out.print("Invalid numeral: ");
                System.out.print("additions don't ");
                System.out.println("decrease.");
            }
            //If the roman numeral is valid, then display the arabic number.
            else
            {
                System.out.print("The arabic number ");
                System.out.print("equivalent to the ");
                System.out.println("roman numeral " + roman + " is: " + r.convertedValue);
            }
            System.out.println("");
            //Decrement the value of number of test cases.
            num_of_values--;
        }
        //Close the scanner object.
        sc.close();
    }
}
class NumberConvertion
{
    //Declare the required variable to store the resultant arabic number.
    static int convertedValue;

    //Define the method checkRoman().
    /**
     * checkRoman function is used for validating the roman numerals(I, V, X, L, C, D, or M)
     * @param romanNumber
     * @return Boolean value
     */
    public static boolean checkRoman(String romanNumber)
    {
        //Start the for loop over the given roman numeral.
        for(int i = 0; i < romanNumber.length();	i++)
        {
            //Check if the current character of the roman numeral is I, V, X, L, C, D, or M.
            if(romanNumber.charAt(i) == 'I' ||	romanNumber.charAt(i) == 'V' ||
                    romanNumber.charAt(i) == 'X' || romanNumber.charAt(i) == 'L' ||
                    romanNumber.charAt(i) == 'C' ||
                    romanNumber.charAt(i) == 'D' || romanNumber.charAt(i) == 'M')
            {}
            //Otherwise, return false.
            else
            {
                return false;
            }
        }
        //If all the numerals are valid, then return true.
        return true;
    }

    //Define the method checkAuxilarySubtraction().
    /**
     * checkAuxilarySubtraction function is used to check number is a Auxilary numeral or not.
     * @param romanNumber
     * @return boolean
     */
    public static boolean checkAuxilarySubtraction(String romanNumber)
    {
        //Start the for loop over the entered roman
        //numeral till the second last character.
        for(int i = 0; i < romanNumber.length()-1; i++)
        {
            //Get the arabic equivalent of current and
            //next numeral using function getValue().
            int num1 = getValue(romanNumber.charAt(i));
            int num2 = getValue(romanNumber.charAt(i + 1));
            //Check if the first number is less than second number.
            if(num1 < num2)
            {
                //If the number 1 is an auxilary numeral, then return false.
                if(checkAux(romanNumber.charAt(i)))
                {
                    return false;
                }
            }
        }
        //Return true, if the there is no subtraction from auxilary numeral.
        return true;
    }

    //Define the method checkTwoSubtraction().
    /**
     * checkTwoSubtraction : This function is used to checkTwoSubtraction if there are 2 consecutive subtractions
     * @param romanNumber
     * @return boolean value if there are no 2 consecutive subtraction
     */
    public static boolean checkTwoSubtraction(String romanNumber)
    {
        //Start the for loop till the last 2 characters of a string containing roman numeral.
        for(int i = 0; i < romanNumber.length()-2;i++)
        {
            //Get the three consecutive arabic numbers of equivalent numerals.
            int num1 = getValue(romanNumber.charAt(i));
            int num2 = getValue(romanNumber.charAt(i + 1));
            int num3 = getValue(romanNumber.charAt(i + 2));
            //If the first number is less than second and second number is less than third number, then return true.
            if(num1 < num2 && num2 < num3)
            {
                return true;
            }
        }
        //If there are two consecutive subtraction, then
        //return false.
        return false;
    }

    //Define the method checkAddition().
    /**
     * This function is used to checkAddition
     * @param romanNumber
     * @return boolean value
     */
    public static boolean checkAddition(String romanNumber)
    {
        //Declare the variable to store the last added value.
        int last = 0;
        for(int i = 0; i < romanNumber.length(); i++)
        {
            //Get the arabic equivalent of current numeral.
            int num1 = getValue(romanNumber.charAt(i));
            //Check if the next i is less than the length of the string.
            if(i+1 < romanNumber.length())
            {
                //Get the arabic number equivalent to
                //the next character of the string.
                int num2 = getValue(romanNumber.charAt(i+1));
                if(num1 >= num2)
                {
                    //Add the first number to the
                    //variable convertedValue.
                    convertedValue = convertedValue + num1;
                    //If the last added value is not 0
                    //and less than num1, then return
                    //true.
                    if(last != 0 && last < num1)
                    {
                        return true;
                    }
                    //Make number 1 as last added value.
                    last = num1;
                }
                //If the number 1 is less than number 2.
                else
                {
                    //Add the difference of num2 and
                    //num1 to the convertedValue.
                    convertedValue = convertedValue + num2 - num1;
                    //If the last added value is 0 and
                    //less tahn the difference of two
                    //numbers, then return true.
                    if(last != 0 && last < (num2 - num1))
                    {
                        return true;
                    }
                    //Make the difference of two
                    //numbers as last added value.
                    last = num2 - num1;
                    //Increment the i of the loop.
                    i++;
                }
            }
            //Check if the current i of the loop is
            //equal to the length of the string.
            else
            {
                //Add the num1 to the convertedValue.
                convertedValue = convertedValue + num1;
                //Increment the value of i of the for loop.
                i++;
            }
        }
        //Return false, if there are not decreasing additions.
        return false;
    }

    //Define the method checkAux().
    /**
     * This function is used to check Aux character
     * @param num
     * @return boolean value
     */
    public static boolean checkAux(char num)
    {
        //If the given character is equal to V, L, or D,
        //return true.
        if(num == 'V' || num == 'L' || num == 'D')
        {
            return true;
        }
        //Return false, if any character is not V, L, or
        //D.
        return false;
    }

    //Define the method getValue().
    /**
     * This function is used to get number for numeral.
     * @param num
     * @return returns number for numeral
     */
    public static int getValue(char num)
    {
        //If the given numeral is I, return the value 1.
        if(num == 'I')
        {
            return 1;
        }
        //If the given numeral is V, return the value 5.
        if(num == 'V')
        {
            return 5;
        }
        //If the given numeral is X, return the value 10.
        if(num == 'X')
        {
            return 10;
        }
        //If the given numeral is L, return the value 50.
        if(num == 'L')
        {
            return 50;
        }
        //If the given numeral is C, return the value 100.
        if(num == 'C')
        {
            return 100;
        }
        //If the given numeral is D, return the value 500.
        if(num == 'D')
        {
            return 500;
        }
        //If the given numeral is M, return the value 1000.
        if(num == 'M')
        {
            return 1000;
        }
        //Return 0 to the calling function.
        return 0;
    }

}