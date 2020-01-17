package com.behavior;

import java.util.ArrayList;
import java.util.List;

/**
 * 行为模式-观察者设计模式
 *
 * @ClassName: ObserverPattern
 * @Author： yuanyixiong
 * @Date： 2019/12/9 下午3:38
 * @Description： TODO
 * @Version： 1.0
 */
public class ObserverPattern {

    public static void main(String[] args) {

        //主题
        Subject subject = new ConcreteSubject();

        //观察者
        Observer observer1 = new ConcreteObserver();
        Observer observer2 = new ConcreteObserver();
        Observer observer3 = new ConcreteObserver();

        //添加观察者
        subject.attach(observer1);
        subject.attach(observer2);
        subject.attach(observer3);

        //主题发生调用
        subject.invoke();

        //移除观察者
        subject.detach(observer2);
        subject.detach(observer3);

        //主题发生调用
        subject.invoke();

    }
}

/**
 * 观察者
 *
 * @ClassName: Observer
 * @Author: yuanyixiong
 * @Date: 2019/12/9 下午4:04
 * @Description: TODO
 * @Version: 1.0
 */
interface Observer {

    void update(Object object);

    void update();

}

/**
 * 主题
 *
 * @ClassName: Subject
 * @Author: yuanyixiong
 * @Date: 2019/12/9 下午4:04
 * @Description: TODO
 * @Version: 1.0
 */
interface Subject {

    /**
     * 添加观察者
     *
     * @Author: yuanyixiong
     * @Date: 2019/12/9 下午4:05
     * @Description: TODO
     * @Param: [observer]
     * @Version: 1.0
     * @Return: void
     **/
    void attach(Observer observer);

    /**
     * 移除观察者
     *
     * @ClassName: Subject
     * @Author: yuanyixiong
     * @Date: 2019/12/9 下午4:05
     * @Description: TODO
     * @Version: 1.0
     */
    void detach(Observer observer);

    /**
     * 通知观察者
     *
     * @Author: yuanyixiong
     * @Date: 2019/12/9 下午4:05
     * @Description: TODO
     * @Param: [object]
     * @Version: 1.0
     * @Return: void
     **/
    void notifyObservers(Object object);

    /**
     * 主题调用
     *
     * @ClassName: Subject
     * @Author: yuanyixiong
     * @Date: 2019/12/9 下午4:06
     * @Description: TODO
     * @Version: 1.0
     */
    void invoke();
}

/**
 * 观察者实例
 *
 * @ClassName: ConcreteObserver
 * @Author: yuanyixiong
 * @Date: 2019/12/9 下午4:04
 * @Description: TODO
 * @Version: 1.0
 */
class ConcreteObserver implements Observer {
    @Override
    public void update(Object object) {
        System.out.println(String.format("update(%s)", object));
    }

    @Override
    public void update() {
        System.out.println("update()");
    }
}

/**
 * 主题实例
 *
 * @ClassName: ConcreteSubject
 * @Author: yuanyixiong
 * @Date: 2019/12/9 下午4:05
 * @Description: TODO
 * @Version: 1.0
 */
class ConcreteSubject implements Subject {

    private List<Observer> observers = new ArrayList<>();

    @Override
    public void attach(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void detach(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(Object object) {
        observers.forEach(observer -> observer.update(object));
    }

    @Override
    public void invoke() {
        for (int i = 0; i < 10; i++) {
            System.out.println("invoke：" + i);
            this.notifyObservers(i);
        }
    }
}