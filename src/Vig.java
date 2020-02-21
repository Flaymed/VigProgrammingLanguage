import compiler.KeywordParse;
import compiler.Variables;


import java.io.File;
import java.util.Map;

public class Vig {

	public static void main(String[] args) {

		File compileFile = new File(args[0]);
		Map varData = Variables.identifyVariables(compileFile);
		Map kwData = KeywordParse.getKeyWords(compileFile);

		if (varData != null && kwData != null) {
			System.out.println(varData);
			System.out.println(kwData);
		} else {
			System.out.println("Something went wrong");
		}

	}

}
