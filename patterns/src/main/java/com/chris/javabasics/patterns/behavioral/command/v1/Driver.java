package com.chris.javabasics.patterns.behavioral.command.v1;

import java.util.ArrayList;
import java.util.List;

public class Driver {
    private final List<VehicleCommand> commands = new ArrayList<>();

    public void addCommand(VehicleCommand command){
        commands.add(command);
    }

    public void executeCommands(final String command){
        commands.forEach(c -> c.process(command));
        commands.clear();
    }
}
