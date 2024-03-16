package com.chris.javabasics.acmio.acm.meituan.fall2021.game8;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Problem1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(), M = sc.nextInt(), Q = sc.nextInt();

        Shelf[] shelves = new Shelf[N+1];
        for(int i = 1; i <= N; ++i)
            shelves[i] = new Shelf();
        shelves[0] = new Shelf();
        Book[] books = new Book[M+1];
        for(int i = 1; i <= M; ++i)
            books[i] = new Book();

        while(Q-- > 0) {
            int op = sc.nextInt();
            switch (op) {
                case 1 -> {
                    int x = sc.nextInt(), y = sc.nextInt();

                    Book book = books[x];

                    if(book.isBorrowed || shelves[book.row].isLock || shelves[y].isLock)
                        continue;

                    shelves[y].set.add(x);
                    books[x].row = y;
                }
                case 2 -> {
                    int y = sc.nextInt();
                    shelves[y].isLock = true;
                }
                case 3 -> {
                    int y = sc.nextInt();
                    shelves[y].isLock = false;
                }
                case 4 -> {
                    int x = sc.nextInt();

                    Book book = books[x];
                    if(book.isBorrowed || shelves[book.row].isLock || book.row == 0) {
                        System.out.println(-1);
                    } else {
                        System.out.println(book.row);

                        shelves[books[x].row].set.remove(x);
                        books[x].isBorrowed = true;
                        books[x].row = 0;
                    }

                }
                case 5 -> {
                    int x = sc.nextInt();
                    if(!books[x].isBorrowed) continue;
                    books[x].isBorrowed = false;
                    books[x].row = 0;
                }
            }
        }
    }
}

class Shelf {
    boolean isLock;
    Set<Integer> set;

    Shelf() {
        isLock = false;
        set = new HashSet<>();
    }
}

class Book {
    boolean isBorrowed;
    int row;

    Book() {
        isBorrowed = false;
        row = 0;
    }
}
