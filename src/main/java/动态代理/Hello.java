package 动态代理;

/**
 *
 * @ClassName: Hello
 * @Author： yuanyixiong
 * @Date： 2019/12/26 下午8:24
 * @Description：
 * @Version： 1.0
 */
public class Hello implements IHello {

    @Override
    public void sayHello(String str) {
        System.out.println("Hello:" + str);
    }

}
