package 动态代理_注解增强;

/**
 * @ClassName: App
 * @Author： yuanyixiong
 * @Date： 2019/12/26 下午9:27
 * @Description： TODO
 * @Version： 1.0
 */
public class App {

    public static void main(String[] args) {
        DynaProxy dynaProxy = new DynaProxy();
        BaiDu baiDu = (BaiDu) dynaProxy.bind(BaiDu.class);
        baiDu.query();
        baiDu.query("aop");
        baiDu.query("aop", 121);
    }

}
