package GC.WeakReference;

import java.lang.ref.WeakReference;
import java.util.ArrayList;

/*
* 演示弱引用
* -Xmx20m -XX:+PrintGCDetails -verbose:gc
* */
public class Demo01 {

    private static final int _4MB = 4 * 1024 * 1024;

    public static void main(String[] args) {
        ArrayList<WeakReference<byte[]>> list = new ArrayList<>();
        for(int i = 0; i<10 ;i++){
            WeakReference<byte[]> weakReference = new WeakReference<>(new byte[_4MB]);
            list.add(weakReference);
            for(WeakReference<byte[]> w : list){
                System.out.println(w.get() + "");
            }
            System.out.println();
        }
        System.out.println("循环结束" + list.size());
    }
}
