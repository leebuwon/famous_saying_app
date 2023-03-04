package org.example;

import org.example.system.Rq;
import org.example.system.container.Container;
import org.example.system.controller.FamousController;
import org.example.system.entity.Famous_Say;

import java.util.*;

import static java.lang.Integer.parseInt;

public class Main {
    public static void main(String[] args) {
        List<Famous_Say> famous_says = new ArrayList<>();

        System.out.println("== 명언 앱 ==");

        FamousController famousController = new FamousController();



        while (true) {
            System.out.printf("명령) ");
            String cmd = Container.getScanner().nextLine().trim();

            Rq rq = new Rq(cmd);

            if (cmd.equals("종료")) {
                famousController.exit();
                break;
            } else if (cmd.equals("등록")) {
                famousController.write();
            } else if (cmd.equals("목록")) {
                famousController.list();
            } else if (cmd.startsWith("삭제")) {
                famousController.remove(rq);
            } else if(cmd.startsWith("수정")){
                famousController.modify(rq);
            } else if (cmd.startsWith("빌드"))
                famousController.build();
        }
    }
}