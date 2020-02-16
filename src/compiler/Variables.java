package compiler;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.io.File;
import java.util.Scanner;

public class Variables {

    public static Map<String, String> varString = new HashMap<>();
    public static Map<String, Integer> varInt = new HashMap<>();
    public static Map<String, Boolean> varBool = new HashMap<>();

    public static void identifyVariables(File fileName) {
        try {
            Scanner fileReader = new Scanner(fileName);
            while (fileReader.hasNextLine()) {
                String data = fileReader.nextLine();
                if (data.contains("var")) {
                    //Get position of the '=' (accounts for no space between variable name and '=' sign)
                    int equals = data.indexOf("=");
                    String variable = "";
                    //use negative one to account for the first letter in the variable name
                    for (int i = -1; i < equals - 5; i++) {

                        variable = variable + data.charAt(5 + i);
                    }
                    System.out.println(variable);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
            e.printStackTrace();
        }
    }

}
