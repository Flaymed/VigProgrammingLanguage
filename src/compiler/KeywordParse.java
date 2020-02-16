package compiler;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class KeywordParse {
    private static String[] keywords = {"function", "class", "var", "if", "else", "elif"};
    private static Map<String, String> keywordInstances = new HashMap<>();

    private static ArrayList<String> functionNames = new ArrayList<>();

    private static void handleFunction(String functionLine) {

        //TODO: Handle function paramaters & look for function calls

        int endFunction = functionLine.indexOf("{");

        String functionName = "";

        //use 8 to account for length of "function"
        for (int i = 8; i < functionLine.length(); i++) {
            if (functionLine.charAt(i) == '{') {
                break;
            }

            functionName = functionName + functionLine.charAt(i);

        }

        functionNames.add(functionName);

    }

    public static ArrayList<String> getFunctions() {
        return functionNames;
    }

    public static Map getKeyWords(File mainFile) {
        try {
            Scanner readFile = new Scanner(mainFile);
            while (readFile.hasNextLine()) {
                String fileData = readFile.nextLine();

                for (int i = 0; i < keywords.length; i++) {

                    Boolean hasKeyword = fileData.contains(keywords[i]);

                    if (!hasKeyword) {
                        continue;
                    } else {
                        switch (keywords[i]) {
                            case "function":
                                handleFunction(fileData);
                                keywordInstances.put("function", "function");
                                break;
                        }
                    }

                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return keywordInstances;

    }

}
