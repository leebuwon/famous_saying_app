package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

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
                System.out.println("작가 : 작자미상");
                cnt++;
                System.out.println(cnt + "번 명언이 등록되었습니다.");
            }
        }
    }
}

class Famous_Say{
    private int id;
    private String author;
    private String famous_Saying;

    public Famous_Say(int id, String author, String famous_Saying) {
        this.id = id;
        this.author = author;
        this.famous_Saying = famous_Saying;
    }
}