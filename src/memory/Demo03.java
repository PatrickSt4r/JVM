package memory;

import java.nio.ByteBuffer;
import java.util.ArrayList;
/*
* 直接内存溢出
* */
public class Demo03 {
    static int _1GB = 1024 * 1024 * 1024;
    public static void main(String[] args) {
        ArrayList<ByteBuffer> list = new ArrayList<>();
        int i = 0;
        try{
            while (true){
                ByteBuffer byteBuffer = ByteBuffer.allocateDirect(_1GB);
                list.add(byteBuffer);
                i++;
            }
        }finally {
            System.out.println(i);
        }
    }
}
