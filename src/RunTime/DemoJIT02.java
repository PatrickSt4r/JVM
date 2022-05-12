package RunTime;
/*
* 方法内联
* */
public class DemoJIT02 {

    //-XX:+UnlockDiagnosticVMOptions -XX:+PrintInlining -XX:CompileCommand=dontinline,*DemoJIT02.square
    //-XX:+PrintCompilation

    public static void main(String[] args) {
        int x = 0;
        for (int i =0 ; i < 500 ; i++){
            long start = System.nanoTime();
            for(int j=0 ; j < 1000; j++){
                x = sqare(9);
            }
            long end = System.nanoTime();
            System.out.printf("%d\t%d\t%d\n",i,x,(end-start));
        }
    }

    private static int sqare(final int i) {return i*i;}
}
