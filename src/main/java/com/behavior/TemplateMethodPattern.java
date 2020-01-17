package com.behavior;

/**
 * 行为模式-模板方法设计模式
 *
 * @ClassName: TemplateMethodPattern
 * @Author： yuanyixiong
 * @Date： 2019/12/9 下午4:48
 * @Description： TODO
 * @Version： 1.0
 */
public class TemplateMethodPattern {

    public static void main(String[] args) {
        Template template = new DbTemplate();
        template.run();
    }
}

/**
 * 模板-定义好骨架(操作过程的步骤)
 *
 * @ClassName: Template
 * @Author: yuanyixiong
 * @Date: 2019/12/9 下午4:53
 * @Description: TODO
 * @Version: 1.0
 */
abstract class Template {

    public abstract void connect();

    public abstract void select();

    public abstract void process();

    public abstract void disconnect();

    public void run() {
        this.connect();
        this.select();
        this.process();
        this.disconnect();
    }
}

/**
 * 模板的具体实现(实现每一个具体的步骤)
 *
 * @ClassName: DbTemplate
 * @Author: yuanyixiong
 * @Date: 2019/12/9 下午4:53
 * @Description: TODO
 * @Version: 1.0
 */
class DbTemplate extends Template {
    @Override
    public void connect() {
        System.out.println("1.连接数据库");
    }

    @Override
    public void select() {
        System.out.println("2.查询结果");
    }

    @Override
    public void process() {
        System.out.println("3.处理插叙的结果集");
    }

    @Override
    public void disconnect() {
        System.out.println("4.关闭数据库连接");
    }
}