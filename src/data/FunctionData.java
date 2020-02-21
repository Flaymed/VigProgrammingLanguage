package data;

import java.util.ArrayList;

public class FunctionData {

    private String name;
    private ArrayList<String> params;
    private boolean willReturn;

    public FunctionData(String functionName, ArrayList<String> parameters, boolean returns) {
        this.name = functionName;
        this.params = parameters;
        this.willReturn = returns;
    }


    public ArrayList<String> getParams() {
        return this.params;
    }

    public boolean hasReturn() {
        return this.willReturn;
    }


	

}
