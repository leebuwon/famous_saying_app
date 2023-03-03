package org.example.system.entity;

public class Famous_Say {
    private long id;
    private String author;
    private String famous_Saying;

    public long getId() {
        return id;
    }

    public String getAuthor() {
        return author;
    }

    public String getFamous_Saying() {
        return famous_Saying;
    }
    public void setId(int id) {
        this.id = id;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setFamous_Saying(String famous_Saying) {
        this.famous_Saying = famous_Saying;
    }

    public Famous_Say(long id, String author, String famous_Saying) {
        this.id = id;
        this.author = author;
        this.famous_Saying = famous_Saying;
    }

    @Override
    public String toString() {
        return this.id+" / "+ this.author+" / "+this.famous_Saying;
    }

    public String toJson() {
        return """
                {
                    "id": %d,
                    "content": "%s",
                    "authorName": "%s"
                }
                """
                .stripIndent()
                .formatted(id, famous_Saying, author);
    }
}
