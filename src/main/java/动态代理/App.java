package 动态代理;

import java.lang.reflect.Proxy;

/**
 * @ClassName: App
 * @Author： yuanyixiong
 * @Date： 2019/12/26 下午8:37
 * @Description： TODO
 * @Version： 1.0
 */
public class App {

    public static void main(String[] args) {

        DynaProxy dynaProxy = new DynaProxy();
        IHello hello = (IHello) dynaProxy.bind(new Hello());
        hello.sayHello("动态代理");
    }
}
