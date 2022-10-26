import java.io.*;
class ElementOperations{
    void retriveInfoFromFile() throws IOException {
        File file = new File("3nums.txt");//creating a file
        System.out.print("Reading numbers from file "+file);
        BufferedReader reader = new BufferedReader(new FileReader(file));// creating a reader
        System.out.println("...done");
        String picker;
        picker = reader.readLine();//reading the file
        String[] numbers = picker.split(" ");//seprating the numbers
        int sum=0;
        for(int i=0;i<numbers.length;i++){//loop to print and add the numbers in the file
            System.out.print(numbers[i]);
            if(i!=numbers.length-1)
                System.out.print("+");
            else
                System.out.print("=");
            sum+=Integer.parseInt(numbers[i]);
        }
        System.out.println(sum);//printing the sum
    }
}
public class AddElementsFromFile {
    public static void main(String[] args) throws IOException {
        ElementOperations e = new ElementOperations();
        e.retriveInfoFromFile();
    }
}