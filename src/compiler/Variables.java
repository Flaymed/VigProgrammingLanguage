package compiler;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.io.File;
import java.util.Scanner;

public class Variables {

    public static Map<String, String> varData = new HashMap<>();
    public static Map<String, Integer> varPos = new HashMap<>();

    public static Map identifyVariables(File fileName) {
        try {
            Scanner fileReader = new Scanner(fileName);
            while (fileReader.hasNextLine()) {
                String data = fileReader.nextLine();
                if (data.contains("var")) {
                    //Get position of the '=' (accounts for no space between variable name and '=' sign)
                    int equals = data.indexOf("=");
                    String variableName = "";
                    String variableData = "";
                    //use negative one to account for the first letter in the variable name
                    for (int i = -1; i < equals - 5; i++) {

                        variableName = variableName + data.charAt(5 + i);
                    }

                    for (int i = equals + 1; i < data.length(); i++) {

                        if (i + 1 == data.length()) {
                            break;
                        }

                        variableData = variableData + data.charAt(i);
                    }

                    varData.put(variableName, variableData);

                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
            e.printStackTrace();
        }

        return varData;

    }

}
