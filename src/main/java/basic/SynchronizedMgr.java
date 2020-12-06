package basic;

import org.testng.annotations.Test;

public class SynchronizedMgr {
    @Test
    public void test01() {
        MyTicket mt = new MyTicket();
        new Thread(mt).start();
        new Thread(mt).start();
        new Thread(mt).start();
        new Thread(mt).start();
    }
}

class MyTicket implements Runnable {
    private int tickets = 100;

    @Override
    public void run() {
        while (true) {
            // 用this 和SynchronizedMgr.class来锁的区别：class只存在一份所以线程是绝对安全的，this可以是多实例的不太安全，
            // 如果保证是同一个this实例，也是线程安全的。所以要保证锁的安全需要先确认用来锁的对象的唯一性。
//            synchronized (this) {
            synchronized (SynchronizedMgr.class) {
                if (tickets <= 0) {
                    break;
                }
                try {
                    Thread.sleep(10);                //线程1睡,线程2睡,线程3睡,线程4睡
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "第" + tickets-- + "号票");
            }
        }
    }
}

