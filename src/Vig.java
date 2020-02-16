import compiler.Variables;

import java.io.File;

public class Vig {

	public static void main(String[] args) {

		File compileFile = new File(args[0]);
		Variables.identifyVariables(compileFile);

	}

}
