package com.chris.javabasics.patterns.creational.builder.v2;

public class Main {
    public static void main(String... args) {

        // WITH BUILDER
        var user2 = UserWith.builder()
                .with(builder -> {
                    builder.email = "ben@example.com";
                    builder.name = "Ben Weidig";
                })
                .withPermissions(permissions -> {
                    permissions.add("create");
                    permissions.add("view");
                })
                .build();

        System.out.println(user2);
    }
}
