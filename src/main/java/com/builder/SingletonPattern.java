package com.builder;

/**
 * 单例模式
 *
 * @ClassName: SingletonPattern
 * @Author： yuanyixiong
 * @Date： 2019/11/19 上午10:23
 * @Description： TODO
 * @Version： 1.0
 */
public class SingletonPattern {

    public static void main(String[] args) {
        System.out.println(Singleton.getInstance() == Singleton.getInstance());
    }

}

/**
 * @ClassName: Singleton
 * @Author: yuanyixiong
 * @Date: 2019/11/19 上午10:25
 * @Description: TODO
 * @Version: 1.0
 */
class Singleton {

    private Singleton() {

    }

    //懒汉式,不会存在多线程并发问题
    private static Singleton singleton = new Singleton();

    public static Singleton getInstance() {
        return singleton;
    }

//    //饿汉式,会出现多线程问题导致生成多个实例
//    private static Singleton singleton;
//
//    public static Singleton getInstance() {
//        if (null == singleton) {
//            singleton = new Singleton();
//        }
//        return singleton;
//    }

}