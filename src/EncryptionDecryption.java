import java.io.*;
import java.util.*;
public class EncryptionDecryption {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter password : ");
        String pass = scan.nextLine();
        System.out.println("1 . Enter your name and a file name to save : \n2 . enter a file name to load\nEnter your choice");
        int choice = scan.nextInt();
        String name,fileName;
        if(choice==1){
            scan.nextLine();
            System.out.println("enter your name : ");
            name=scan.nextLine();
            System.out.println("enter file name : ");
            fileName=scan.nextLine();
            String encryptedWord = Encrypt(name,pass);
            String fName = fileName+".txt";
            File file = new File(fName);
            file.createNewFile();
            FileWriter writer = new FileWriter(fName);
            writer.write(encryptedWord);
            writer.close();
        }
        else if(choice==2){
            scan.nextLine();
            System.out.println("Enter file name : ");
            fileName=scan.nextLine();
            String decryptedWord=Decrypt(fileName,pass);
            System.out.println(decryptedWord);
        }
    }
    /*
     *@param name of the person , password
     *@return Encrypted name
     */
    public static String Encrypt(String name,String pass){
        char[] encryptedLetters = new char[name.length()];
        int passCount =0;
        for(int i=0;i<name.length();i++){
            if(passCount==pass.length())
                passCount=0;
            encryptedLetters[i] = (char)(name.charAt(i)^pass.charAt(passCount));
            passCount++;
        }
        String encryptedWord=new String(encryptedLetters);
        return encryptedWord;
    }
    /*
     *@param name of the file name , password
     *@return Decrypted name
     */
    public static String Decrypt(String fileName,String pass) throws IOException {
        File file = new File(fileName+".txt");
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String picker;
        picker = reader.readLine();
        char[] encryptedLetters = new char[picker.length()];
        int passCount =0;
        for(int i=0;i<picker.length();i++){
            if(passCount==pass.length())
                passCount=0;
            encryptedLetters[i] = (char)(picker.charAt(i)^pass.charAt(passCount));
            passCount++;
        }
        String DecryptedWord=new String(encryptedLetters);
        return DecryptedWord;
    }
}
