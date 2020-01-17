package 静态代理;

/**
 * 静态代理：目标对象
 * @ClassName: Hello
 * @Author： yuanyixiong
 * @Date： 2019/12/26 下午8:24
 * @Description： 静态代理:代理对象和目标对象实现共同的接口,并且代理对象持有目标对象的引用
 * @Version： 1.0
 */
public class Hello implements IHello {

    @Override
    public void sayHello(String str) {
        System.out.println("Hello:" + str);
    }

}
