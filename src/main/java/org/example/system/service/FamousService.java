package org.example.system.service;

import org.example.system.Rq;
import org.example.system.Util;
import org.example.system.container.Container;
import org.example.system.entity.Famous_Say;
import org.example.system.repository.FamousRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class FamousService {

    private final FamousRepository famousRepository;


    public FamousService() {
        famousRepository = new FamousRepository();
    }

    public long write(String content, String author) {
        return famousRepository.write(content, author);
    }

    public void remove(Famous_Say famous_say) {
        famousRepository.remove(famous_say);
        // 찾은 명언 객체를 리스트에서 제거
    }

    public void modify(Famous_Say famous_say, String content, String author) {

        famousRepository.modify(famous_say, content, author);
    }

    public List<Famous_Say> findAll() {
        return famousRepository.findAll();
    }

    public Famous_Say findById(long id) {
        return famousRepository.findById(id);
    }

    public void build() {
        List<Famous_Say> famous_says = famousRepository.findAll();

        Util.file.mkdir("prodBuild");

        String json = "[" + famous_says
                .stream()
                .map(famous_say -> famous_say.toJson())
                .collect(Collectors.joining(", \n")) + "]";

        Util.file.saveToFile("prodBuild/data.json", json);
    }
}
