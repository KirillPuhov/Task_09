package presentation.console.services;

import presentation.console.Main;

import java.util.LinkedHashMap;
import java.util.Map;

public class InputArgsService implements InputArgsHelper{
    private static Map<String, String> parameters = new LinkedHashMap<>();

    private static final String[] validValues = {"console", "window"};

    private static final String[] validParameters = {"input", "output", "interface"};

    public InputArgsService(String[] args){
        parsArgs(args);
    }

    private void parsArgs(String[] args){
        String key = "";
        String value = "";
        try{
            for (String arg : args) {
                String[] parts = arg.split("=", 2);
                key = parts[0].toLowerCase();

                if (key.startsWith("--")) {
                    key = key.substring(2);

                    if(!argsValidate(key, validParameters))
                        throw new IllegalArgumentException();
                } else {
                    throw new IllegalArgumentException();
                }
                value = parts[1];

                if(key.equals("interface") && !argsValidate(value, validValues))
                    throw new Exception();

                parameters.put(key, value);
            }
        }catch(IllegalArgumentException ex){
            System.err.printf("invalid parameters \"%s\"", key);
            System.exit(1);
        }catch(Exception ex){
            System.err.printf("invalid argument \"%s\"", value);
            System.exit(1);
        }
    }

    private boolean argsValidate(String arg, String[] validArgs){
        for(String items : validArgs){
            if(items.equals(arg)){
                return true;
            }
        }
        return false;
    }
    public String getValueFor(String key){
        return parameters.get(key);
    }
}
