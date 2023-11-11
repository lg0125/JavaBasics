package com.chris.javabasics.jucpatterns.future.sample;

/**
 * 表示实际数据的类
 * */
public class RealData implements Data {
    private final String content;

    public RealData(int count, char c) {
        System.out.println("        making RealData(" + count + ", " + c + ") BEGIN");

        char[] buffer = new char[count];
        for (int i = 0; i < count; i++) {
            buffer[i] = c;

            try {
                Thread.sleep(100);
            } catch (InterruptedException ignored) {
            }
        }
        this.content = new String(buffer);

        System.out.println("        making RealData(" + count + ", " + c + ") END");
    }

    @Override
    public String getContent() {
        return content;
    }
}
