package org.example.system.controller;

import org.example.system.Rq;
import org.example.system.container.Container;
import org.example.system.entity.Famous_Say;
import org.example.system.service.FamousService;

import java.util.List;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class FamousController {
    private final FamousService famousService;

    public FamousController() {
        famousService = new FamousService();
    }
    public void exit() {
        System.out.println("종료 되었습니다.");
    }

    public void write() {
        System.out.printf("명언 : ");
        String content = Container.getScanner().nextLine().trim();
        System.out.printf("작가 : ");
        String author = Container.getScanner().nextLine().trim();

        long id = famousService.write(content, author);

        System.out.printf("%d번 명언이 등록되었습니다. \n", id);

    }

    public void list() {
        List<Famous_Say> famous_says = famousService.findAll();

        System.out.println("번호 / 명언 / 작가");
        System.out.println("----------------------");
        for (int i = famous_says.size() - 1; i >= 0; i--) {
            System.out.println(famous_says.get(i).toString());
        }
    }

    public void remove(Rq rq) {
        long id = rq.getIntParam("id", -1);

        if (id == -1){
            System.out.println("id에 정수를 입력해주세요");
            return;
        }

        // 입력된 id와 일치하는 명언객체 찾기
        Famous_Say famous_say = famousService.findById(id);

        if (famous_say == null){
            System.out.printf("%d번 명언은 존재하지 않습니다. \n", id);
        }

        famousService.remove(famous_say);

    }

    public void modify(Rq rq) {
        long id = rq.getIntParam("id", -1);

        if (id == -1){
            System.out.println("id에 정수를 입력해주세요");
            return;
        }

        // 입력된 id와 일치하는 명언객체 찾기
        Famous_Say famous_say = famousService.findById(id);

        if (famous_say == null){
            System.out.printf("%d번 명언은 존재하지 않습니다. \n", id);
            return;
        }

        System.out.printf("명언(기존) : %s \n", famous_say.getFamous_Saying());
        System.out.printf("명언 : ");
        String content = Container.getScanner().nextLine();

        System.out.printf("작가(기존) : %s \n", famous_say.getAuthor());
        System.out.printf("작가 : ");
        String author = Container.getScanner().nextLine();

        famousService.modify(famous_say, content, author);

        System.out.println(famous_say.getId() + "번 명언이 수정되었습니다.");
    }

    public void build() {
        famousService.build();
        System.out.println("data.json 파일의 내용이 갱신되었습니다.");
    }
}
