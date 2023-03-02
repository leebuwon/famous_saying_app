package org.example;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Famous_Say> famous_says = new LinkedList<>();

        System.out.println("== 명언 앱 ==");
        int cnt = 0;

        while (true){
            System.out.printf("명령) ");
            String cmd = sc.nextLine();

            if (cmd.equals("종료")){
                System.out.println("종료 되었습니다.");
                break;
            }else if (cmd.equals("등록")){
                System.out.printf("명언 : ");
                String famousSaying = sc.nextLine();
                System.out.printf("작가 : ");
                String author = sc.nextLine();
                cnt++;
                Famous_Say famous_say = new Famous_Say(cnt, author, famousSaying);
                famous_says.add(famous_say);
                System.out.println(cnt + "번 명언이 등록되었습니다.");
            } else if (cmd.equals("목록")) {
                System.out.println("번호 / 작가 / 명언");
                System.out.println("----------------------");
                for (int i = 0; i < famous_says.size(); i++){
                    System.out.println(famous_says.get(i).toString());
                }
            }
        }
    }
}

class Famous_Say{
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