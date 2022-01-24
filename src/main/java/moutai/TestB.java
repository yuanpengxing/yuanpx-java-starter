package moutai;

public class TestB {
    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 100; i++) {
            ThreadA t = new ThreadA();
            t.start();
        }
    }
}
