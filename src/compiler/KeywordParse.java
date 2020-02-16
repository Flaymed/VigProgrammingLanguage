package compiler;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class KeywordParse {
    private static String[] keywords = {"function", "class", "var", "if", "else", "elif", "for", "while", "switch", "case"};
    private static Map<String, Integer> keywordInstances = new HashMap<>();

    public static Map getKeyWords(File mainFile) {
        try {
            Scanner readFile = new Scanner(mainFile);
            while (readFile.hasNextLine()) {
                String fileData = readFile.nextLine();

                for (int i = 0; i < keywords.length; i++) {

                    if (!fileData.contains(keywords[i])) {
                        continue;
                    } else {
                        
                    }

                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return keywordInstances;

    }

}
