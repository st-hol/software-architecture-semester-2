package ua.kpi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ua.kpi.command.Command;
import ua.kpi.command.operations.AbsCommand;
import ua.kpi.command.operations.AddCommand;
import ua.kpi.command.operations.MultiplyCommand;
import ua.kpi.facade.ApplicationFacade;
import ua.kpi.type.ActionCode;

import java.util.EnumMap;
import java.util.Map;


@Component
public class ApplicationController {

    @Autowired
    private ApplicationFacade applicationFacade;

    private Map<ActionCode, Command> commands = new EnumMap<>(ActionCode.class);

    @Autowired
    public ApplicationController(ApplicationFacade applicationFacade,
                                 AddCommand addCommand, AbsCommand absCommand, MultiplyCommand multiplyCommand) {

        this.applicationFacade = applicationFacade;

        commands.put(ActionCode.ABS, absCommand);
        commands.put(ActionCode.ADD, addCommand);
        commands.put(ActionCode.MUL, multiplyCommand);
    }

    public void processActionControl(){
        applicationFacade.process(commands);
    }

    public Map<ActionCode, Command> getCommands() {
        return commands;
    }

    public void setApplicationFacade(ApplicationFacade applicationFacade) {
        this.applicationFacade = applicationFacade;
    }
}
