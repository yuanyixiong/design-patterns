package 动态代理_注解增强;

public interface BaiDu {

    @Get("https://www.baidu.com/s")
    String query(@Query("wd") String word);

    @Get("https://www.baidu.com/s")
    String query();

    @Get("https://www.baidu.com/s")
    String query(@Query("a") String aaa, @Query("b") Integer bbb);

}
