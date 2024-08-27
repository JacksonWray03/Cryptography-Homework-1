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

       plainText = plainText.toLowerCase();




        System.out.println("Please input the desired key");
        int key=0;




        try
        {
            key = scanner.nextInt();
        }
        catch(Exception e)
        {
            System.out.println("Value entered is not an integer ... Exiting");
        }



        int i;


        Character temp;
        ArrayList<Character> splitter = new ArrayList<>();

        for (i=0;i<plainText.length();i++)
        {

            temp=plainText.charAt(i);


            if (!temp.equals(' '))
            {
                for (int j = 0; j<key;j++)
                {

                    temp++;
                    if(temp.charValue()==123)
                    {
                        temp = 'a';
                    }
                }


            }

            splitter.add(temp);
        }

        for(Character c : splitter)
        {
            System.out.print(c);
        }





    }


}
