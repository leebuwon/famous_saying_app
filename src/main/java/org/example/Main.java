package org.example;

import org.example.system.controller.FamousController;
import org.example.system.entity.Famous_Say;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Famous_Say> famous_says = new ArrayList<>();

        System.out.println("== 명언 앱 ==");

        FamousController famousController = new FamousController(sc, famous_says);


        while (true) {
            System.out.printf("명령) ");
            String cmd = sc.nextLine().trim();

            if (cmd.equals("종료")) {
                famousController.exit();

                break;
            } else if (cmd.equals("등록")) {
                famousController.write();

            } else if (cmd.equals("목록")) {
                famousController.list();

            } else if (cmd.contains("삭제?id=")) {
                famousController.remove(cmd);
            }
        }
    }
}