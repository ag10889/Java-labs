import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class program {
    public static void main(String[] args){
        System.out.println("Please input the file name you would like to be compared with");
        String myFile1 = System.in();
        System.out.println("Please input the file name you would like to be compared with");
        String myFile2 = System.in();
        try {
            Scanner file1Scan = new Scanner(myFile1);
            Scanner file2Scan = new Scanner(myFile2);

            int lineNo = 1;
            boolean different = false;
            String line1, line2;
            
        }
    }
}
