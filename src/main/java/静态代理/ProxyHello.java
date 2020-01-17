package 静态代理;

/**
 * 静态代理：代理对象
 *
 * @ClassName: ProxyHello
 * @Author： yuanyixiong
 * @Date： 2019/12/26 下午8:25
 * @Description： 静态代理:代理对象和目标对象实现共同的接口,并且代理对象持有目标对象的引用
 * @Version： 1.0
 */
public class ProxyHello implements IHello {

    /**
     * 被代理对象的引用
     */
    private IHello target;

    public ProxyHello(IHello target) {
        this.target = target;
    }

    @Override
    public void sayHello(String str) {
        System.out.println("proxy begin");
        this.target.sayHello(str);
        System.out.println("proxy end");
    }
}
