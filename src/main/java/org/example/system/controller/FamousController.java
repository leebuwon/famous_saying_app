package org.example.system.controller;

import org.example.system.Rq;
import org.example.system.container.Container;
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
        String famousSaying = Container.getScanner().nextLine();
        System.out.printf("작가 : ");
        String author = Container.getScanner().nextLine();
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

    public void remove(Rq rq) {
        int id = rq.getIntParam("id", -1);

        if (id == -1){
            System.out.println("id에 정수를 입력해주세요");
            return;
        }

        // 입력된 id와 일치하는 명언객체 찾기
        Famous_Say famous_say = findById(id);
        // 찾은 명언 객체를 리스트에서 제거
        famous_says.remove(famous_say);

    }

    private Famous_Say findById(int id) {
        for (Famous_Say famous_say : famous_says) {
            if ( famous_say.getId() == id){
                System.out.println(famous_say.getId() + "번 명언이 삭제되었습니다.");
                return famous_say;
            }
        }
        return null;
    }
}
