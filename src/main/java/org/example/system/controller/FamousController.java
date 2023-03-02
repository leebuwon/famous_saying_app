package org.example.system.controller;

import org.example.system.entity.Famous_Say;

import java.util.List;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class FamousController {

    private final Scanner sc;
    private int cnt = 0;
    private final List<Famous_Say> famous_says;

    public FamousController(Scanner sc, List<Famous_Say> famous_says) {
        this.sc = sc;
        this.famous_says = famous_says;
    }

    public void exit() {
        System.out.println("종료 되었습니다.");
    }

    public void write() {
        System.out.printf("명언 : ");
        String famousSaying = sc.nextLine();
        System.out.printf("작가 : ");
        String author = sc.nextLine();
        cnt++;
        Famous_Say famous_say = new Famous_Say(cnt, author, famousSaying);
        famous_says.add(famous_say);
        System.out.println(cnt + "번 명언이 등록되었습니다.");
    }

    public void list() {
        System.out.println("번호 / 작가 / 명언");
        System.out.println("----------------------");
        for (int i = famous_says.size() - 1; i >= 0; i--) {
            System.out.println(famous_says.get(i).toString());
        }
    }

    public void remove(String cmd) {
        int id = parseInt(cmd.replaceAll("[^0-100]", ""));
        famous_says.remove(famous_says.get(id - 1));
        if (famous_says == null || famous_says.isEmpty()){
            System.out.println(id + "명엉은 이미 존재하지 않습니다.");
        }
        System.out.println(id + "번 명언이 삭제되었습니다.");
    }
}
