package ClassLoad;

/*
*类加载练习
* a b是基本类型，再类的准备阶段就加载完成了
* c是包装类型，需要Integer.valueOf(20) 再类初始化阶段才完成
* */
public class DemoLoader02 {
    public static void main(String[] args) {
        System.out.println(E.a);
        System.out.println(E.b);
        System.out.println(E.c);
    }
}

class E{
    public static final int a = 10;
    public static final String b = "hello";
    public static final Integer c = 20; //自动装箱操作 Integer.valueOf(20)
    static {
        System.out.println("init E");
    }
}
