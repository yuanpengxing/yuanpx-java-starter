package automation;

public class TestA {
    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 100; i++) {
//            Thread.sleep(40);
            RootShellCmd.simulateClick(226, 1152);

        }
    }
}
