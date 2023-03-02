package org.example.system.entity;

public class Famous_Say {
    private int id;
    private String author;
    private String famous_Saying;

    public int getId() {
        return id;
    }

    public String getAuthor() {
        return author;
    }

    public String getFamous_Saying() {
        return famous_Saying;
    }

    public Famous_Say(int id, String author, String famous_Saying) {
        this.id = id;
        this.author = author;
        this.famous_Saying = famous_Saying;
    }

    @Override
    public String toString() {
        return this.id+" / "+ this.author+" / "+this.famous_Saying;
    }
}
