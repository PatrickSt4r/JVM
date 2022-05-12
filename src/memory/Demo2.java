package memory;

/**
 * StringTable调优
 * 演示StringTable垃圾回收
 * -Xmx10m -XX:+PrintStringTableStatistics -XX:+PrintGCDetails -verbose:gc
 * 14-17行代码
 * 打印信息中看到循环100次之后StringTable statistics中Number of entries增加100，说明放入了100个数据到StringTable
 * 18-21行代码
 * 打印信息中发现触发了GC回收机制
 */
public class Demo2 {
    public static void main(String[] args) {
        int i = 0;
        try {
//            for (int j = 0 ; j < 100 ; j ++){
//                String.valueOf(j).intern();
//                i++;
//            }
            for (int j = 0 ; j < 10000 ; j ++){
                String.valueOf(j).intern();
                i++;
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            System.out.println(i);
        }
    }
}
