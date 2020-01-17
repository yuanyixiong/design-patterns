package 动态代理;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 静态代理：代理对象
 *
 * @ClassName: DynaProxy
 * @Author： yuanyixiong
 * @Date： 2019/12/26 下午8:34
 * @Description： 静态代理, 代理对象实现InvocationHandler接口, 持有被代理对象的引用,通过实现InvocationHandler接口中的invoke方法实现代理
 * @Version： 1.0
 */
public class DynaProxy implements InvocationHandler {

    /**
     * 被代理对象的引用
     */
    private Object target;

    public Object bind(Object target) {
        this.target = target;
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.out.println("proxy begin");
        Object result = method.invoke(target, args);
        System.out.println("proxy end");

        return result;
    }
}
