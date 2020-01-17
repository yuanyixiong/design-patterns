package com.builder;


import java.util.ArrayList;
import java.util.List;

/**
 * 构建者模式：统一调度对象的生成
 *
 * @ClassName: BuilderPattern
 * @Author： yuanyixiong
 * @Date： 2019/11/15 下午5:57
 * @Description： TODO
 * @Version： 1.0
 */
public class BuilderPattern {


    public static void main(String[] args) {

        /*
         * 1. 产品:Product
         * 2. 抽象的构建者:Builder
         * 3. 具体的构建者:ConcreteBuilder[A/B]
         * 4. 指挥者:Director
         */

        /**指挥者**/
        Director director = new Director();

        /**构建者**/
        Builder builderA = new ConcreteBuilderA();
        Builder builderB = new ConcreteBuilderB();

        /**指挥者-指挥-构建者构建产品**/
        director.builder(builderA);
        Product productA = builderA.getProduct();
        productA.show();

        /**指挥者-指挥-构建者构建产品**/
        director.builder(builderB);
        Product productB = builderB.getProduct();
        productB.show();
    }

}

/**
 * 产品
 *
 * @ClassName: Product
 * @Author: yuanyixiong
 * @Date: 2019/11/15 下午6:02
 * @Description: TODO
 * @Version: 1.0
 */
class Product {

    private List<String> list = new ArrayList<>();

    public void add(String data) {
        this.list.add(data);
    }

    public void show() {
        list.stream().forEach(System.out::println);
    }
}

/**
 * 抽象的构建者
 *
 * @ClassName: Builder
 * @Author: yuanyixiong
 * @Date: 2019/11/15 下午6:02
 * @Description: TODO
 * @Version: 1.0
 */
abstract class Builder {

    /**
     * 构建产品：第一步
     *
     * @Author: yuanyixiong
     * @Date: 2019/11/15 下午6:03
     * @Description: TODO
     * @Param: []
     * @Version: 1.0
     * @Return: void
     **/
    public abstract void buildPartA();

    /**
     * 构建产品：第二步
     *
     * @Author: yuanyixiong
     * @Date: 2019/11/15 下午6:04
     * @Description: TODO
     * @Param: []
     * @Version: 1.0
     * @Return: void
     **/
    public abstract void buildPartB();

    /**
     * 返回构建的产品
     *
     * @Author: yuanyixiong
     * @Date: 2019/11/15 下午6:19
     * @Description: TODO
     * @Param: []
     * @Version: 1.0
     * @Return: com.builder.Product
     **/
    public abstract Product getProduct();

}

/**
 * 具体的构建者-A
 *
 * @ClassName: ConcreteBuilderA
 * @Author: yuanyixiong
 * @Date: 2019/11/15 下午6:16
 * @Description: TODO
 * @Version: 1.0
 */
class ConcreteBuilderA extends Builder {

    private Product product = new Product();

    @Override
    public void buildPartA() {
        product.add("part a");
    }

    @Override
    public void buildPartB() {
        product.add("part b");
    }

    @Override
    public Product getProduct() {
        return product;
    }
}

/**
 * 具体的构建者-B
 *
 * @ClassName: ConcreteBuilderB
 * @Author: yuanyixiong
 * @Date: 2019/11/15 下午6:16
 * @Description: TODO
 * @Version: 1.0
 */
class ConcreteBuilderB extends Builder {

    private Product product = new Product();

    @Override
    public void buildPartA() {
        product.add("part x");
    }

    @Override
    public void buildPartB() {
        product.add("part y");
    }

    @Override
    public Product getProduct() {
        return product;
    }
}

/**
 * 指挥者-指挥具体的构建者完成产品的构建
 *
 * @ClassName: Director
 * @Author: yuanyixiong
 * @Date: 2019/11/15 下午6:17
 * @Description: TODO
 * @Version: 1.0
 */
class Director {

    public void builder(Builder builder) {
        builder.buildPartA();
        builder.buildPartB();
    }
}