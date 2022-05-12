package memory;

/**
 * StringTable面试题
 */
public class Demo1 {
    public static void main(String[] args) {
        String s1 = "a";
        String s2 = "b";
        String s3 = "a" + "b"; //ab
        String s4 = s1 + s2; //new String("ab")
        String s5 = "ab";
        String s6 = s4.intern();


        System.out.println(s3 == s4); // false new的ab在堆中不在串池中，所以为false
        System.out.println(s3 == s5); // true s3是编译优化，已经存在与串池中
        System.out.println(s3 == s6); // true s4尝试把ab放入串池，串池中已经有ab，则返回串池中的ab赋予s6

        String x2 = new String("c") + new String("b");
        String x1 = "cb";
        x2.intern();
        //如果x1 x2.intern()调换位置呢？
        //答案为true，因为x2入串池之后和x1在同一串池中
        //如果是jdk1.6呢？
        //jdk1.6的intern为复制一个副本存入串池，与原ab不相同
        System.out.println(x1 == x2); //false x2不在串池中
    }
}
