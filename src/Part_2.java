import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Part_2
{

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please input a ciphertext sentence");
        String cipherText;


        cipherText = scanner.nextLine();

        cipherText = cipherText.toLowerCase();


        int i;

        ArrayList<String> cleanSample = cleanSample("data/sample.txt");
        System.out.println(cleanSample);
        ArrayList<String> cleanCipher = cipherList(cipherText);
        System.out.println(cleanCipher);


    }

    public static ArrayList<String> cipherList(String cipherText)
    {
        ArrayList<String> clean = new ArrayList<>();

        if ( cipherText.charAt(cipherText.length()-1)!= '.'      ||   cipherText.charAt(cipherText.length()-1)!= ' '  || cipherText.charAt(cipherText.length()-1)!= ',' )
        {
            cipherText = cipherText.concat(".");
        }

        String temp="";
        int i;



        for(i=0; i< cipherText.length(); i++)
        {

            temp = temp.concat(String.valueOf(cipherText.charAt(i)));

            if (cipherText.charAt(i) == ' '|| cipherText.charAt(i) == ',' || cipherText.charAt(i) == '.')
            {
                temp= temp.toLowerCase();
                temp = temp.substring(0,temp.length()-1);

                if (temp != "")
                {
                    clean.add(temp);
                }
                temp="";
            }

        }


        return clean;
    }

    public static ArrayList<String> cleanSample(String filePath) throws FileNotFoundException {
        ArrayList<String> clean = new ArrayList<>();
        FileInputStream fis = new FileInputStream(filePath);
        Scanner scanner = new Scanner(fis);
        String full="";
        String temp="";
        int i;

        while (scanner.hasNextLine())
        {
           full = full.concat(scanner.nextLine());
        }

        for(i=0;i<full.length();i++)
        {

            temp = temp.concat(String.valueOf(full.charAt(i)));

            if (full.charAt(i) == ' '|| full.charAt(i) == ',' || full.charAt(i) == '.')
            {
                temp= temp.toLowerCase();
                temp = temp.substring(0,temp.length()-1);

                if (temp != "")
                {
                    clean.add(temp);
                }
                temp="";
            }

        }


        return clean;
    }




}
