package Polymorphism;

import java.io.IOException;

/*
* 演示多态原理，注意加上下面的JVM参数，禁止指针压缩
* -XX:-UseCompressedOops -XX:-UseCompressedClassPointers
* */
public class DemoPo01 {

    public static void test(Animal animal){
        animal.eat();
        System.out.println(animal.toString());
    }

    public static void main(String[] args) throws IOException {
        test(new Cat());
        test(new Dog());
        System.in.read();
    }
}

abstract class Animal{
    public abstract void eat();

    @Override
    public String toString() {
        return "我是" + this.getClass().getSimpleName();
    }
}

class Dog extends Animal{
    @Override
    public void eat() {
        System.out.println("啃骨头");
    }
}

class Cat extends Animal{
    @Override
    public void eat() {
        System.out.println("吃鱼");
    }
}
