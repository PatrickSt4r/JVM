package memory;

import java.io.IOException;
import java.nio.ByteBuffer;

//性能调优
public class Demo07 {
    static int _1GB = 1024*1024*1024;

    /*
     * -XX:+DisableExplicitGC 关闭显式的垃圾回收机制
     * 使用显式的GC会导致程序变慢，触发的是FullGC，会造成暂停时间较长，可以通过Demo06来管理直接内存
     */
    public static void main(String[] args) throws IOException {
        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(_1GB);
        System.out.println("分配完成");
        System.in.read();
        System.out.println("开始释放");
        byteBuffer = null;
        System.gc(); //显式垃圾回收，Full GC
        System.in.read();
    }
}
