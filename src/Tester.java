import java.util.ArrayList;
import java.util.Scanner;

public class Tester
{

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please input a plaintext sentence");
        String plainText;



        plainText= scanner.nextLine();
        System.out.println(plainText);

        System.out.println(plainText.length());

        System.out.println("Please input desire key");
        int key=0;




        try
        {
            key = scanner.nextInt();
        }
        catch(Exception e)
        {
            System.out.println("Value entered is not an integer ... Exiting");
        }

        System.out.println(key);

        int i;


        ArrayList<Character> splitter = new ArrayList<>();

        for (i=0;i<plainText.length();i++)
        {




        }

    }


}
