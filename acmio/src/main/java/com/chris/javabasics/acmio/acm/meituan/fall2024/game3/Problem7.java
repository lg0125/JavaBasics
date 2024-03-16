package com.chris.javabasics.acmio.acm.meituan.fall2024.game3;

import java.util.Scanner;

public class Problem7 {
    public static void main(String[] args) {
        Scanner sc          = new Scanner(System.in);
        String ipaddress    = sc.nextLine();

        if(ipaddress.lastIndexOf(".") == ipaddress.length()-1) {
            System.out.println("invalid");
            return;
        }


        String[] seg        = ipaddress.split("\\.");

        boolean isLegal = checkIP(seg);

        if(isLegal) {
            int[] ip = new int[4];
            for (int i = 0; i < seg.length; i++)
                ip[i] = Integer.parseInt(seg[i]);

            if (1 <= ip[0] && ip[0] <= 126 && !(ip[0] == 126 && ip[3] != 0)) {
                System.out.println("A_address");
            } else if (128 <= ip[0] && ip[0] <= 191) {
                System.out.println("B_address");
            } else if (192 <= ip[0] && ip[0] <= 223) {
                System.out.println("C_address");
            } else {
                System.out.println("other");
            }
        } else {
            System.out.println("invalid");
        }
    }

    private static boolean checkIP(String[] seg) {
        if(seg.length != 4) return false;
        if(seg[0].equals("0") && seg[1].equals("0") && seg[2].equals("0") && seg[3].equals("0")) return true;

        for(int i = 0; i < seg.length; ++i) {
            if (seg[i].isEmpty() || !seg[i].matches("\\d+")) return false;
            if (seg[i].length() > 1 && seg[i].charAt(0) == '0') return false;

            int component = Integer.parseInt(seg[i]);
            if (i == 0) {
                if (!(1 <= component && component <= 255)) return false;
            } else {
                if (!(0 <= component && component <= 255)) return false;
            }
        }

        return true;
    }
}
