package com.builder;

/**
 * 抽象工厂模式:创建出一些列相关对象
 *
 * @ClassName: AbstractFactoryPattern
 * @Author： yuanyixiong
 * @Date： 2019/11/19 下午2:45
 * @Description： TODO
 * @Version： 1.0
 */
public class AbstractFactoryPattern {
    public static void main(String[] args) {

        AbstractFactory factory;
        Client client;

        factory = new ConcreateFactory1();
        client = new Client(factory);
        client.run();

        factory = new ConcreateFactory2();
        client = new Client(factory);
        client.run();
    }
}

/**
 * 抽象工厂用于创建一些列相关的对象
 *
 * @ClassName: AbstractFactory
 * @Author: yuanyixiong
 * @Date: 2019/11/19 下午2:57
 * @Description: TODO
 * @Version: 1.0
 */
interface AbstractFactory {

    AbstractProductA createProductA();

    AbstractProductB createProductB();
}

class ConcreateFactory1 implements AbstractFactory {
    @Override
    public AbstractProductA createProductA() {
        return new ProductA1();
    }

    @Override
    public AbstractProductB createProductB() {
        return new ProductB1();
    }
}

class ConcreateFactory2 implements AbstractFactory {
    @Override
    public AbstractProductA createProductA() {
        return new ProductA2();
    }

    @Override
    public AbstractProductB createProductB() {
        return new ProductB2();
    }
}

/**
 * 抽象的产品:1
 *
 * @ClassName: AbstractProductA
 * @Author: yuanyixiong
 * @Date: 2019/11/19 下午2:56
 * @Description: TODO
 * @Version: 1.0
 */
interface AbstractProductA {

}

class ProductA1 implements AbstractProductA {

}

class ProductA2 implements AbstractProductA {

}

/**
 * 抽象的产品:2
 *
 * @ClassName: AbstractProductB
 * @Author: yuanyixiong
 * @Date: 2019/11/19 下午2:56
 * @Description: TODO
 * @Version: 1.0
 */
interface AbstractProductB {

}

class ProductB1 implements AbstractProductB {

}

class ProductB2 implements AbstractProductB {

}

/**
 * 业务操作
 *
 * @ClassName: Client
 * @Author: yuanyixiong
 * @Date: 2019/11/19 下午2:54
 * @Description: TODO
 * @Version: 1.0
 */
class Client {

    /**
     * 抽象的产品:1
     */
    AbstractProductA productA;

    /**
     * 抽象的产品:2
     */
    AbstractProductB productB;

    /**
     * 初始化决定使用的抽象工厂具体的实现，来创建出一系列相关对象,实现交互
     *
     * @Author: yuanyixiong
     * @Date: 2019/11/19 下午2:55
     * @Description: TODO
     * @Param: [factory]
     * @Version: 1.0
     * @Return:
     **/
    public Client(AbstractFactory factory) {
        productA = factory.createProductA();
        productB = factory.createProductB();
    }

    /**
     * 对象的交互操作
     *
     * @Author: yuanyixiong
     * @Date: 2019/11/19 下午2:54
     * @Description: TODO
     * @Param: []
     * @Version: 1.0
     * @Return: void
     **/
    public void run() {
        System.out.println(productA.getClass());
        System.out.println(productB.getClass());
    }
}