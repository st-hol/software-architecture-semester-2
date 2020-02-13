package ua.kpi.controller;

import java.util.EnumMap;
import java.util.Map;

import ua.kpi.command.Command;
import ua.kpi.command.operations.AbsCommand;
import ua.kpi.command.operations.AddCommand;
import ua.kpi.command.operations.MultiplyCommand;
import ua.kpi.facade.ApplicationFacade;
import ua.kpi.type.ActionCode;


public class ApplicationController {

    private Map<ActionCode, Command> commands = new EnumMap<>(ActionCode.class);

    private static ApplicationController instance;
    private ApplicationFacade applicationFacade;

    private ApplicationController() {
        applicationFacade = ApplicationFacade.getInstance();
    }

    public static ApplicationController getInstance() {
        if (instance == null) {
            synchronized (ApplicationController.class) {
                if (instance == null) {
                    instance = new ApplicationController();
                }
            }
        }
        return instance;
    }

    private void initCommands(){
        commands.put(ActionCode.ABS, new AbsCommand());
        commands.put(ActionCode.ADD, new AddCommand());
        commands.put(ActionCode.MUL, new MultiplyCommand());
    }

    public void processActionControl(){
        initCommands();
        applicationFacade.process(commands);
    }

}
