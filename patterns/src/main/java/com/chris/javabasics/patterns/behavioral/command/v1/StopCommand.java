package com.chris.javabasics.patterns.behavioral.command.v1;

public record StopCommand(Vehicle vehicle) implements VehicleCommand {
    @Override
    public void process(String command) {
        if(command.contains("stop")){
            vehicle.stop();
            System.out.println("STOP:" + vehicle);
        }
    }
}
