package automation;

public class TestA {
    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 2; i++) {

            Thread.sleep(100);
            RootShellCmd.simulateClick(360, 1370);

        }
    }
}
