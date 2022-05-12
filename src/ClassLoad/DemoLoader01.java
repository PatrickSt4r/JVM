package ClassLoad;

/*
* 类初始化案例
* */
public class DemoLoader01 {
    static{
//        System.out.println("main init");
    }

    public static void main(String[] args) throws ClassNotFoundException {
        //1.静态常量不会触发初始化
//        System.out.println(B.b);
        //2.类对象.class 不会触发初始化
//        System.out.println(B.class);
        //3.创建类的数组不会触发初始化
//        System.out.println(new B[0]);
        //4.不会初始化类B，但会加载B、A
//        ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
//        contextClassLoader.loadClass("ClassLoad.B");
        //5.不会初始化类B，但会加载B、A
//        ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
//        Class.forName("ClassLoad.B",false,contextClassLoader);


        //1.首次访问这个类的静态变量或静态方法
//        System.out.println(A.a);
        //2.子类初始化，如果父类还没初始化，会引发
//        System.out.println(B.c);
        //3.子类访问父类静态变量，只触发父类初始化
//        System.out.println(B.a);
        //4.会初始化类B，并先初始化类A
        Class.forName("ClassLoad.B");
    }
}

class A{
    static int a = 0;
    static {
        System.out.println("a init");
    }
}

class B extends A{
    final static double b = 5.0;
    static boolean c = false;
    static {
        System.out.println("b init");
    }
}
