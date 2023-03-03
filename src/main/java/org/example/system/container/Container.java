package org.example.system.container;

import java.util.Scanner;

public class Container {
    //공통으로 Scanner를 관리
    private static Scanner sc;

    static {
        sc = new Scanner(System.in);
    }

    public static Scanner getScanner() {
        return sc;
    }
}
