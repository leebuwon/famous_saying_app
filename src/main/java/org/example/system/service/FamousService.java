package org.example.system.service;

import org.example.system.Rq;
import org.example.system.container.Container;
import org.example.system.entity.Famous_Say;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FamousService {

    private long cnt;
    private final List<Famous_Say> famous_says;

    public FamousService() {
        cnt = 0;
        famous_says = new ArrayList<>();
    }
    public long write(String content, String author) {
        long id = cnt + 1;
        Famous_Say famous_say = new Famous_Say(id, content, author);
        famous_says.add(famous_say);

        cnt = id;

        return id;
    }

    public void remove(Famous_Say famous_say) {
        // 찾은 명언 객체를 리스트에서 제거
        famous_says.remove(famous_say);
    }

    public void modify(Famous_Say famous_say, String content, String author) {
        famous_say.setFamous_Saying(content);
        famous_say.setAuthor(author);

    }

    public Famous_Say findById(long id) {
        for (Famous_Say famous_say : famous_says) {
            if ( famous_say.getId() == id){
                System.out.println(famous_say.getId() + "번 명언이 삭제되었습니다.");
                return famous_say;
            }
        }
        return null;
    }

    public List<Famous_Say> findAll() {
        return famous_says;
    }
}
