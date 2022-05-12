package JMM;


/*
* 可见性问题
* volatile解决线程读取高速缓存区感知不到主变化的问题
* */
public class DemoJMM02 {
//    static boolean run = true;
    volatile static boolean run = true;

    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(() -> {
            while (run) {

            }
        });
        t.start();
        Thread.sleep(1000);
        run = false;//线程t不会预想的停下来
    }
}
