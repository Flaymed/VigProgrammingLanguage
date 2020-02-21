package compiler;

import data.FunctionData;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class KeywordParse {
    private static String[] keywords = {"function", "class", "var", "if", "else", "elif"};
    private static Map<String, FunctionData> functionInstance = new HashMap<>();
    private static ArrayList<String> functionParams = new ArrayList<>();

    private static void handleFunction(String functionLine) {

        //TODO: Handle function parameters & look for function calls

        String functionName = "";

        //use 8 to account for length of "function"
        for (int i = 8; i < functionLine.length(); i++) {
            if (functionLine.charAt(i) == '{') {
                break;
            }

            functionName = functionName + functionLine.charAt(i);

        }

        //get parameters

        int startParams = functionLine.indexOf("(");
        int endParams = functionLine.indexOf(")");
        String params = "";
        //clear the parameter array before loading the function
        functionParams.clear();
        //Add 1 to skip over the (
        for (int i = startParams + 1; i < endParams; i++) {
            if (functionLine.charAt(i) == ',') {
                functionParams.add(params);
                params = "";
            } else {
                params = params + functionLine.charAt(i);
            }
        }

        FunctionData function = new FunctionData(functionName, functionParams, false);
        functionInstance.put(functionName, function);
    }

    public static Map<String, FunctionData> getKeyWords(File mainFile) {
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
                                break;
                        }
                    }

                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return functionInstance;

    }

}
