package com.chris.javabasics.patterns.creational.builder.v3;

public class FastVehicle implements Vehicle {
    // build pattern II
    // the builder may become a part of the class for which the instance is intended to be created
    //  In such a case, it is possible to decide which element should be added to the newly created specific instance
    final static class Builder {
        private Part engine;
        private Part cabin;
        Builder(){}

        Builder addEngine(String e){
            this.engine = new StandardPart(e);
            return this;
        }

        Builder addCabin(String c){
            this.cabin = new RecordPart(c);
            return this;
        }

        FastVehicle build(){
            return new FastVehicle(engine, cabin);
        }
    }

    // build pattern II
    private final Part engine;
    private final Part cabin;

    FastVehicle(Part engine, Part cabin){
        this.engine = engine;
        this.cabin = cabin;
    }

    @Override
    public void move() {
        System.out.println("FastVehicle, move");

    }

    @Override
    public void parts() {
        System.out.println("FastVehicle,engine: " + engine);
        System.out.println("FastVehicle,cabin: " + cabin);

    }
}
