package GC.SoftReference;

import java.io.IOException;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.List;

/*
* 软引用引用队列
* -Xmx20m -XX:+PrintGCDetails -verbose:gc
* */
public class Demo09 {
    private static final int _4MB = 4 * 1024 * 1024;

    public static void main(String[] args) throws IOException {

        List<SoftReference<byte[]>> list = new ArrayList<>();

        //引用队列
        ReferenceQueue<byte[]> queue = new ReferenceQueue<>();

        for(int i = 0 ; i < 5 ; i++){
            //关联了引用队列,当软引用所关联的byte数组被回收时，软引用自己会被加入queue中去
            SoftReference<byte[]> softReference = new SoftReference<>(new byte[_4MB],queue);

            System.out.println(softReference);
            list.add(softReference);
            System.out.println(list.size());
        }

        //从队列中获取无用的软引用对象，并移除
        Reference<? extends byte[]> poll = queue.poll();
        while(poll != null){
            list.remove(poll);
            poll = queue.poll();
        }

        System.out.println("循环结束" + list.size());
        for (SoftReference<byte[]> ref : list){
            System.out.println(ref.get());
        }

    }
}
