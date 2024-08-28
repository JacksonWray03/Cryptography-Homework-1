
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import java.util.ArrayList;
import java.util.Scanner;

public class Part_2 {


    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please input a ciphertext sentence");
        String cipherText;


        cipherText = scanner.nextLine();

        cipherText = cipherText.toLowerCase();


        int i;
        int j;
        int k;
        Character tempchar;
        String tempString = "";

        ArrayList<String> cleanSample = cleanSample("data/sample.txt");
        ArrayList<String> cleanCipher = cipherList(cipherText);

        ArrayList<ArrayList<String>> theMatrix = new ArrayList<>();



        for (i = 0; i < 26; i++) {
            ArrayList<String> option = new ArrayList<>();
            for (String word : cleanCipher) {
                for (j = 0; j < word.length(); j++) {
                    tempchar = word.charAt(j);

                    for (k = 0; k < i; k++) {
                        tempchar--;
                        if (tempchar.charValue() == 96) {
                            tempchar = 'z';
                        }
                    }
                    tempString = tempString.concat(String.valueOf(tempchar));


                }


                word = word.replace(word, tempString);
                tempString = "";

                option.add(word);
            }

            theMatrix.add(option);
        }




        ArrayList<String> bestSolution = new ArrayList<>(heuristic(theMatrix,cleanSample));
        System.out.println(bestSolution);
        System.out.println(theMatrix);

    }


    public static ArrayList<String> heuristic(ArrayList<ArrayList<String>> theMatrix, ArrayList<String> sampleText)
    {
        ArrayList<String> best = new ArrayList<>();
        int i=0;
        int checks;

        for(ArrayList<String> option : theMatrix)
        {
            checks=0;
            for(String word : option)
            {
                if (sampleText.contains(word))
                {
                    checks++;
                    if (checks==option.size())
                    {
                        best = option;
                        System.out.println("The Used Key is: " + i);
                    }
                }
            }
            i++;
        }

        return best;
    }


    public static ArrayList<String> cipherList(String cipherText) {
        ArrayList<String> clean = new ArrayList<>();

        if (cipherText.charAt(cipherText.length() - 1) != '.' || cipherText.charAt(cipherText.length() - 1) != ' ' || cipherText.charAt(cipherText.length() - 1) != ',') {
            cipherText = cipherText.concat(".");
        }

        String temp = "";
        int i;


        for (i = 0; i < cipherText.length(); i++) {

            temp = temp.concat(String.valueOf(cipherText.charAt(i)));

            if (cipherText.charAt(i) == ' ' || cipherText.charAt(i) == ',' || cipherText.charAt(i) == '.') {
                temp = temp.toLowerCase();
                temp = temp.substring(0, temp.length() - 1);

                if (temp != "") {
                    clean.add(temp);
                }
                temp = "";
            }

        }


        return clean;
    }

    public static ArrayList<String> cleanSample(String filePath) throws FileNotFoundException {
        ArrayList<String> clean = new ArrayList<>();
        FileInputStream fis = new FileInputStream(filePath);
        Scanner scanner = new Scanner(fis);
        String full = "";
        String temp = "";
        int i;

        while (scanner.hasNextLine()) {
            full = full.concat(scanner.nextLine());
        }

        for (i = 0; i < full.length(); i++) {

            temp = temp.concat(String.valueOf(full.charAt(i)));

            if (full.charAt(i) == ' ' || full.charAt(i) == ',' || full.charAt(i) == '.') {
                temp = temp.toLowerCase();
                temp = temp.substring(0, temp.length() - 1);

                if (temp != "") {
                    clean.add(temp);
                }
                temp = "";
            }

        }


        return clean;
    }
}






