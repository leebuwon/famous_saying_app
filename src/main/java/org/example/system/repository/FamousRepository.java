package org.example.system.repository;

import org.example.system.entity.Famous_Say;
import org.example.system.table.FamousTable;

import java.util.ArrayList;
import java.util.List;

public class FamousRepository {

    private final FamousTable famousTable;

    public FamousRepository() {
        famousTable = new FamousTable();
    }

    public Famous_Say findById(long id) {
        return famousTable.findById(id);
    }

    public List<Famous_Say> findAll() {
        return famousTable.findAll();
    }

    public long write(String content, String author) {
        long id = famousTable.getLastId() + 1;
        Famous_Say famous_say = new Famous_Say(id, content, author);
        return famousTable.save(famous_say);
    }

    public void remove(Famous_Say famous_say) {
        // 찾은 명언 객체를 리스트에서 제거
        famousTable.remove(famous_say);
    }

    public void modify(Famous_Say famous_say, String content, String author) {
        famousTable.modify(famous_say, content, author);
    }
}
