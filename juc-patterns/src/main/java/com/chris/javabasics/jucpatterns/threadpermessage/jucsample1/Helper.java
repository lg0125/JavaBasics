package com.chris.javabasics.jucpatterns.threadpermessage.jucsample1;

public class Helper {
    public void handle(int count, char c) {
        System.out.println("        handle(" + count + ", " + c + ") BEGIN");

        for (int i = 0; i < count; i++) {
            slowly();
            System.out.print(c);
        }

        System.out.println();
        System.out.println("        handle(" + count + ", " + c + ") END");
    }

    private void slowly() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException ignored) {
        }
    }
}
