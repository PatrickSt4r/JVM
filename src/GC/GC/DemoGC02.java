package GC.GC;

import java.util.ArrayList;


public class DemoGC02 {
    private static final int _512KB = 512 * 1024;
    private static final int _1MB = 1024 * 1024;
    private static final int _6MB = 6 *1024 * 1024;
    private static final int _7MB = 7 *1024 * 1024;
    private static final int _8MB = 8 *1024 * 1024;

    // -Xms20M -Xmx20M -Xmn10M -XX:+UseSerialGC -XX:+PrintGCDetails -verbose:gc
    public static void main(String[] args) throws InterruptedException {
//        ArrayList<byte[]> list = new ArrayList<>();
        //新生代不够8M，老年代还有空间会直接把8M放入老年代，如果两个则放不下，会报出内存溢出异常
//        list.add(new byte[_8MB]);
//        list.add(new byte[_8MB]);

        //子线程的内存溢出不会导致主线程结束
        new Thread(()->{
            ArrayList<byte[]> list = new ArrayList<>();
            list.add(new byte[_8MB]);
            list.add(new byte[_8MB]);
        }).start();
        System.out.println("sleep...");
        Thread.sleep(1000L);
    }
}
