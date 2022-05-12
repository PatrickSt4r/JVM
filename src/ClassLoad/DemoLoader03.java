package ClassLoad;
/*
* 尝试用类加载角度实现单例模式
*
* */
public class DemoLoader03 {
    public static void main(String[] args) {
        Singleton.getInstance();
    }
}

class Singleton{

    private Singleton(){}

    public static void test(){
        System.out.println("test");
    }

    private static class lazyHolder{
        private static final Singleton SINGLETON = new Singleton();
        static {
            System.out.println("lazy holder init");
        }
    }

    public static Singleton getInstance(){
        return lazyHolder.SINGLETON;
    }
}