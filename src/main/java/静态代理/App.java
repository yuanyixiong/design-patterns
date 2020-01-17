package 静态代理;

/**
 * 静态代理
 *
 * @ClassName: App
 * @Author： yuanyixiong
 * @Date： 2019/12/26 下午8:30
 * @Description： TODO
 * @Version： 1.0
 */
public class App {

    public static void main(String[] args) {

        ProxyHello proxyHello = new ProxyHello(new Hello());
        proxyHello.sayHello("静态代理");

    }
}
