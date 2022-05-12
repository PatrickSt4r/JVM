package GC.GC;


import java.util.ArrayList;

/*
* 演示垃圾回收
* */
public class DemoGC01 {
    private static final int _512KB = 512 * 1024;
    private static final int _1MB = 1024 * 1024;
    private static final int _6MB = 6 *1024 * 1024;
    private static final int _7MB = 7 *1024 * 1024;
    private static final int _8MB = 8 *1024 * 1024;

    // -Xms20M -Xmx20M -Xmn10M -XX:+UseSerialGC -XX:+PrintGCDetails -verbose:gc
    public static void main(String[] args) {
        ArrayList<byte[]> list = new ArrayList<>();
        //第一次只放入伊甸区
        list.add(new byte[_7MB]);
        //第二次内存紧张进行一次gc，清除部分伊甸园并把存货下来的部分放入from区
        list.add(new byte[_512KB]);
        //进行两次gc，内存空间紧张把from区部分放入老年代
        list.add(new byte[_512KB]);
    }
}
