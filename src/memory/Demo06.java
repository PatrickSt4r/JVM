package memory;

import sun.misc.Unsafe;

import java.io.IOException;
import java.lang.reflect.Field;

public class Demo06 {

    static int _1GB = 1024 * 1024 * 1024;

    public static void main(String[] args) throws IOException {
        Unsafe unsafe = getUnsafe();
        //分配内存
        long base = unsafe.allocateMemory(_1GB);//分配获得内存地址
        unsafe.setMemory(base,_1GB,(byte) 0);
        System.in.read();

        //释放内存
        unsafe.freeMemory(base);
        System.in.read();
    }


    public static Unsafe getUnsafe(){
        try{
            Field f = Unsafe.class.getDeclaredField("theUnsafe");
            f.setAccessible(true);
            Unsafe unsafe =(Unsafe) f.get("null");
            return unsafe;
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
