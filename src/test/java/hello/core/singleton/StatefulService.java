package hello.core.singleton;

public class StatefulService {

    private int price; // 상태를 유지하는 필드

    public void order(String name, int price) {
        System.out.println("name = " + name + " price = " + price);
        this.price = price; //여기가 문제

        // 스프링 빈은 항상 무상태로 설계
        // 현재같은경우 공유필드인 private int price를 매개변수로만 가지고 있어서 리턴으로 전달해주는식으로 바꿔야함
    }
    public int getPrice() {
        return price;
    }
}
