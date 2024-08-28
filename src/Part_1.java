import java.util.ArrayList;
import java.util.Scanner;

public class Part_1
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
            System.exit(0);
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
            if (temp.charValue()<=96 || temp.charValue()>=123)
            {
                temp= ' ';
            }
            splitter.add(temp);
        }

        for(Character c : splitter)
        {
            System.out.print(c);
        }
        System.out.println("");






        System.out.println("Please input a ciphertext sentence");
        scanner.nextLine();
        String cipherText = scanner.nextLine();
        System.out.println("Please input the decryption key");

        try
        {
            key = scanner.nextInt();
        }
        catch(Exception e)
        {
            System.out.println("Value entered is not an integer ... Exiting");
            System.exit(0);
        }

        cipherText = cipherText.toLowerCase();

        ArrayList<Character> splitter2 = new ArrayList<>();

        for (i=0;i<cipherText.length();i++)
        {

            temp=cipherText.charAt(i);


            if (!temp.equals(' '))
            {
                for (int j = 0; j<key;j++)
                {

                    temp--;
                    if(temp.charValue()==96)
                    {
                        temp = 'z';
                    }
                }


            }

            splitter2.add(temp);
        }

        for(Character c : splitter2)
        {
            System.out.print(c);
        }


    }


}
