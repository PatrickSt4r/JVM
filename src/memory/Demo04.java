package memory;

import java.io.IOException;
import java.nio.ByteBuffer;
/*
用控制台查看byteBuffer的获取直接内存的方式
 */
public class Demo04 {
    static int _1GB = 1024 * 1024 * 1024;

    public static void main(String[] args) throws IOException {
        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(_1GB);
        System.out.println("分配完毕..");
        System.in.read();
        System.out.println("开始释放..");
        byteBuffer = null;
        System.gc();
        System.in.read();

    }
}
