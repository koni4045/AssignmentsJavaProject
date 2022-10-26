import java.util.*;
public class RomanToNumerical {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter number of roman numbers : ");
        int n=scan.nextInt();
        for(int i=0;i<n;i++) {
            System.out.println("Enter roman number : ");
            String input = scan.next();
            Converter c = new Converter();
            if (!c.checkCharecters(input)) {
                System.out.println("1.Invalid charecter in input");
            } else if (c.invalidRepeat(input)) {
                System.out.println("invalid repetation of 'V','L' or 'D'");
            } else if (c.convertRomanToInt(input) == -1) {
                System.out.println("Invalid numeral! cant substract auxilary symbol");
            } else if (c.convertRomanToInt(input) == -2) {
                System.out.println("invalid numeral! two consequtuve substractions");
            } else if (c.convertRomanToInt(input) == -3) {
                System.out.println("invalid numeral! additons doesnt decrease");
            } else if (c.longRepetation(input)) {
                System.out.println("Too long repetition");
            } else {
                System.out.println(c.convertRomanToInt(input));
            }
        }
    }
}
class Converter{
    char[] romanNumerals = {'I','X','C','M','V','L','D'};
    char[] auxilary = {'V','L','D'};
    int[] arabicNumerals = {1,10,100,1000,5,50,500};
    /*
     *@param roman number
     *@return arabic number
     */
    int convertRomanToInt(String romanInput) {
        int arabicValue = 0;
        int counter=0;
        for (int i=0; i<romanInput.length(); i++) {
            int s1 = arabicNumerals[findIndex(romanInput.charAt(i))];
            if (i+1 <romanInput.length()) {
                if(counter==1){
                    counter--;
                }
                int s2 = arabicNumerals[findIndex(romanInput.charAt(i+1))];
                if (s1 >= s2) {
                    arabicValue +=  + s1;
                }
                else {
                    if(inAuxi(romanInput.charAt(i))){
                        arabicValue = -1;
                        return arabicValue;
                    }
                    arabicValue -= s1;
                    counter++;
                    if(counter==2){
                        arabicValue=-2;
                        return arabicValue;
                    }
                }
            }
            else {
                arabicValue += s1;
            }
        }
        return arabicValue;
    }
    /*
     *@param charecter
     *@return index
     */
    private int findIndex(char charecter) {
        int index=0;
        for(int i=0;i<romanNumerals.length;i++){
            if(charecter==romanNumerals[i]){
                index=i;
                break;
            }
        }
        return index;
    }
    /*
     *@param roman number
     *@return true/false
     */
    boolean checkLength(String input){
        boolean flag = true;
        if(input.length()<=4){
            flag=true;
        }
        else{
            flag=false;
        }
        return flag;
    }
    /*
     *@param roman number
     *@return true/false
     */
    boolean checkCharecters(String input){
        boolean flag=true;
        for(int i=0;i<input.length();i++){
            if(checkExistance(input.charAt(i))){
                flag=true;
            }
            else{
                flag = false;
                break;
            }
        }
        return flag;
    }
    /*
     *@param charecter
     *@return true/false
     */
    boolean checkExistance(char charecter){
        for(int i=0;i<romanNumerals.length;i++){
            if(charecter==romanNumerals[i]){
                return true;
            }
        }
        return false;
    }
    /*
     *@param charecter
     *@return true/false
     */
    boolean inAuxi(char c){
        for(int i=0;i<auxilary.length;i++){
            if(c==auxilary[i]){
                return true;
            }
        }
        return false;
    }
    /*
     *@param roman number
     *@return true/false
     */
    boolean invalidRepeat(String input){
        int[] repeatCountArray = {0,0,0};
        for(int i=0;i<input.length();i++){
            if(input.charAt(i)=='V'){
                repeatCountArray[0]++;
            }
            if(input.charAt(i)=='L'){
                repeatCountArray[1]++;
            }
            if(input.charAt(i)=='D'){
                repeatCountArray[2]++;
            }
        }
        if(repeatCountArray[0]>1||repeatCountArray[1]>1||repeatCountArray[2]>1)
            return true;
        else
            return false;
    }
    /*
     *@param roman number
     *@return true/false
     */
    boolean longRepetation(String input){
        int[] repeatCountArray = {0,0,0,0,0,0,0};
        for(int i=0;i<input.length();i++){
            if(input.charAt(i)=='I'){
                repeatCountArray[0]++;
            }
            if(input.charAt(i)=='X'){
                repeatCountArray[1]++;
            }
            if(input.charAt(i)=='C'){
                repeatCountArray[2]++;
            }if(input.charAt(i)=='M'){
                repeatCountArray[3]++;
            }
            if(input.charAt(i)=='V'){
                repeatCountArray[4]++;
            }
            if(input.charAt(i)=='L'){
                repeatCountArray[5]++;
            }
            if(input.charAt(i)=='D'){
                repeatCountArray[6]++;
            }
        }
        if(repeatCountArray[0]>3||repeatCountArray[1]>3||repeatCountArray[2]>3
                ||repeatCountArray[3]>3||repeatCountArray[4]>3||repeatCountArray[5]>3||repeatCountArray[6]>3)
            return true;
        else
            return false;
    }
}
