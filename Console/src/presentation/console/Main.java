package presentation.console;

import domain.services.FileService;
import domain.services.ListService;
import domain.services.interfaces.ListHelper;
import presentation.console.services.*;
import presentation.window.FrameMain;
import utils.SwingUtils;

import java.util.List;
import java.util.Locale;


public class Main {
    private static InputArgsHelper inputArgsService;
    private static ListHelper listService;
    private static InputArgs inputArgs;

    public static void main(String[] argv){
        inputArgsService = new InputArgsService(argv);
        listService = new ListService(new FileService());
        inputArgs = ParseCmdArgs();
        execute(inputArgs.getAppInterface());
    }

    private static InputArgs ParseCmdArgs(){
        var input = inputArgsService.getValueFor("input");
        var output = inputArgsService.getValueFor("output");
        var appInterface = inputArgsService.getValueFor("interface");

        var inputArgs = new InputArgs(input, output, appInterface);

        return inputArgs;
    }

    private static void execute(String appInterface){
        switch (appInterface) {
            case "console" -> consoleApp();
            case "window" -> windowApp();
        }
    }

    private static void consoleApp(){
        List<Integer> mainList = listService.openList(inputArgs.getInput());
        listService.printList(mainList);

        listService.doTask(mainList);

        listService.printList(mainList);
        boolean result = listService.saveList(mainList, inputArgs.getOutput());

        if(result == Boolean.TRUE){
            System.out.println("Файл сохранён");
            System.exit(0);
        }else{
            System.out.println("Ошибка! Файл не сохранён!");
            System.exit(1);
        }
    }

    private static void windowApp(){
        try{
            Locale.setDefault(Locale.ROOT);
            SwingUtils.setDefaultFont("Microsoft Sans Serif", 18);

            java.awt.EventQueue.invokeLater(() -> new FrameMain(listService, inputArgs).setVisible(true));
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }
}
