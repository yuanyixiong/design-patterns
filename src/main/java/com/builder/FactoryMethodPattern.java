package com.builder;

/**
 * 工厂方法模式、多态工厂模式:创建出一系列独立的对象
 *
 * @ClassName: FactoryMethodPattern
 * @Author： yuanyixiong
 * @Date： 2019/11/19 上午11:11
 * @Description： TODO
 * @Version： 1.0
 */
public class FactoryMethodPattern {

    public static void main(String[] args) {

        MobileFactory mobileFactory;
        Mobile mobile;

        mobileFactory = new AppleFactory();
        mobile = mobileFactory.peoduceMobile();
        mobile.Call();

        mobileFactory = new HuaweiFactory();
        mobile = mobileFactory.peoduceMobile();
        mobile.Call();

    }
}

/**
 * 手机工厂
 *
 * @ClassName: MobileFactory
 * @Author: yuanyixiong
 * @Date: 2019/11/19 上午11:16
 * @Description: TODO
 * @Version: 1.0
 */
interface MobileFactory {
    Mobile peoduceMobile();
}

/**
 * 手机
 *
 * @Author: yuanyixiong
 * @Date: 2019/11/19 上午11:16
 * @Description: TODO
 * @Param:
 * @Version: 1.0
 * @Return:
 **/
interface Mobile {
    void Call();
}

/**
 * 具体的手机-苹果手机
 *
 * @Author: yuanyixiong
 * @Date: 2019/11/19 上午11:17
 * @Description: TODO
 * @Param:
 * @Version: 1.0
 * @Return:
 **/
class Apple implements Mobile {
    @Override
    public void Call() {
        System.out.println("苹果手机");
    }
}

/**
 * 具体的手机-华为手机
 *
 * @Author: yuanyixiong
 * @Date: 2019/11/19 上午11:17
 * @Description: TODO
 * @Param:
 * @Version: 1.0
 * @Return:
 **/
class Huawei implements Mobile {
    @Override
    public void Call() {
        System.out.println("华为手机");
    }
}

/**
 * 具体的手机工厂-苹果手机工厂
 *
 * @Author: yuanyixiong
 * @Date: 2019/11/19 上午11:17
 * @Description: TODO
 * @Param:
 * @Version: 1.0
 * @Return:
 **/
class AppleFactory implements MobileFactory {
    @Override
    public Mobile peoduceMobile() {
        System.out.println("苹果工厂");
        return new Apple();
    }
}

/**
 * 具体的手机工厂-华为手机工厂
 *
 * @Author: yuanyixiong
 * @Date: 2019/11/19 上午11:18
 * @Description: TODO
 * @Param:
 * @Version: 1.0
 * @Return:
 **/
class HuaweiFactory implements MobileFactory {
    @Override
    public Mobile peoduceMobile() {
        System.out.println("华为工厂");
        return new Huawei();
    }
}