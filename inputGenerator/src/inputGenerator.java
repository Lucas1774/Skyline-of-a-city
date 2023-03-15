import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class inputGenerator {
    private static Scanner scanner = new Scanner(System.in); 
    public static void main (String []args) throws java.lang.InterruptedException, IOException {
        System.out.println("Enter path of output file (C:\\\\Directory\\\\Subdirectory\\\\file.txt)");
        String string = scanner.nextLine(); 
        FileWriter file = new FileWriter(string);
        PrintWriter writer = new PrintWriter(file);
        System.out.println("Enter number of buildings");
        int N = scanner.nextInt();
        System.out.println("Enter max city width");
        int M = scanner.nextInt();
        System.out.println("Enter max building width");
        int O = scanner.nextInt();
        System.out.println("Enter max building height");
        int P = scanner.nextInt();
        Random random = new Random();
        for (int i=0; i < N; i++) {
            int x1 = random.ints(0, M).findFirst().getAsInt();
            int x2 = random.ints(x1 + 1, x1 + O + 1).findFirst().getAsInt();
            int y = random.ints(1, P + 1).findFirst().getAsInt();
            writer.println(x1 + "," + x2 + "," + y);
        }
        System.out.println("Succesfully updated file");
        file.close();
    }
}