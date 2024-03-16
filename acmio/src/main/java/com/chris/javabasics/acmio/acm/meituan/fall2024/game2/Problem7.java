package com.chris.javabasics.acmio.acm.meituan.fall2024.game2;

import java.util.*;

public class Problem7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();

        HashMap<String, String> info = new HashMap<>();
        for(int i = 0; i < n; ++i) {
            String[] line = sc.nextLine().split(" ");

            if(!Character.isLowerCase(line[0].charAt(0))) continue;

            if(!info.containsKey(line[0])) {
                info.put(line[0], line[1] + " " + 0);
            } else {
                String[] values = info.get(line[0]).split(" ");

                boolean isDistinct = true;
                for(int j = 0; j < values.length - 1; ++j) {
                    if (values[j].equals(line[1])) {
                        isDistinct = false;
                        break;
                    }
                }

                if(isDistinct) {
                    int cnt = Integer.parseInt(values[values.length-1]) + 1;

                    StringBuilder sb = new StringBuilder();
                    for(int k = 0; k < values.length-1; ++k)
                        sb.append(values[k]).append(" ");
                    sb.append(line[1]).append(" ").append(cnt);

                    info.put(line[0], sb.toString());
                }
            }
        }

        List<String> keys = new ArrayList<>(info.keySet());
        Collections.sort(keys);
        for(String key : keys) {
            String[] values = info.get(key).split(" ");
            System.out.println(key + " " + values[0] + " " + values[values.length - 1]);
        }
    }
}
