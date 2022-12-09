package presentation.console.services;

public class InputArgs {
    private String input;
    private String output;
    private String appInterface;
    public String getInput(){
        return input;
    }

    public String getOutput(){
        return output;
    }

    public String getAppInterface(){
        return appInterface;
    }

    public InputArgs(String newInput, String newOutput, String newAppInterface){
        input = newInput;
        output = newOutput;
        appInterface = newAppInterface;
    }
}
