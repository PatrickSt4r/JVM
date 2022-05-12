package JMM;

/*
* 原子性问题
* synchronized解决静态变量多线程自增自减导致结果不一致的问题
* */
public class DemoJMM01 {

    static int i = 0;

    static Object object = new Object();

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            synchronized (object) {
                for (int j = 0; j < 50000; j++) {
                    i++;
                }
            }
        });

        Thread t2 = new Thread(() -> {
            synchronized (object) {
                for (int j = 0; j < 50000; j++) {
                    i--;
                }
            }
        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();

        System.out.println(i);
    }
}
